package com.iraqsofit.speedoo.controller;

import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.security.SignInRequest;
import com.iraqsofit.speedoo.security.Token;
import com.iraqsofit.speedoo.service.TwilioOTP;
import com.iraqsofit.speedoo.service.UserDateilsService;
import com.iraqsofit.speedoo.user.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gemstone/v1")
public class AuthController {
    @Autowired
    private Token token;
    @Autowired
    private UserDateilsService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TwilioOTP twilioOTP;

    @PostMapping(value = {"/signIn", "/signIn/"})
    public Response<TokenResponse> signIn(@RequestBody SignInRequest signInRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = service.loadUserByUsername(signInRequest.getUsername());
        String tokenSign = token.generateToken(userDetails);
        List<TokenResponse> tokens = new ArrayList<>();
        tokens.add(new TokenResponse(tokenSign));
        return new Response<TokenResponse>(true,tokens, "successful login", 200);
    }

    @PostMapping(value = {"/signUp", "/signUp/"})
    public Response createAccount(@Valid  @RequestBody SingUpRequest singUpRequest) {
        System.out.println(singUpRequest.getPhoneNumber());
        List<OTP> otpList = new ArrayList();
        String date_otp = twilioOTP.sms(singUpRequest.getPhoneNumber());
        String otpDb []=date_otp.split(",");
        UserImp user = new UserImp(
                singUpRequest.getName(),
                singUpRequest.getPhoneNumber(),
                service.getPasswordEncoder().encode(singUpRequest.getPassword()),
                singUpRequest.getLocation(),
                singUpRequest.getCity(),
                singUpRequest.getAddress()
        );
        user.setOtp(date_otp);
        UserImp userImp = service.Save(user);
        OTP otp = new OTP();
        otp.setCode(Integer.parseInt(otpDb[0]));
        otp.setUserID(userImp.getUsername());
        otpList.add(otp);
        return new Response(true,otpList, "successful create account",200);
    }




    @PostMapping(value = {"/otp", "/otp/"})
    public ResponseEntity<Response> otp(@Valid  @RequestBody OTPRequest otpRequest){
        return  new ResponseEntity<>(service.setOtp(otpRequest.getOtp(),otpRequest.getUsername()), HttpStatus.OK);
    }
    @PostMapping(value = {"/changePassword", "/changePassword/"})
    public ResponseEntity<Response> changePassword(@Valid  @RequestBody ChangePassword changePassword){
        return  new ResponseEntity<>(
                service.changePassword(
                        changePassword.getOldPassword(),
                        changePassword.getNewPassword(),
                        changePassword.getUsername()
                ),
                HttpStatus.OK
        );
    }

    @PostMapping(value = {"/forgetPassword", "/forgetPassword/"})
    public ResponseEntity<Response> forgetPassword(@Valid  @RequestBody ForgetPassword forgetPassword){
        return  new ResponseEntity<>(
                service.forgetPassword(
                        forgetPassword.getPassword(),
                        forgetPassword.getUsername(),
                        forgetPassword.getOtp()
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/setOTPForgetPassword/{username}")
    public ResponseEntity setOTPForgetPassword(@PathVariable String username) {
        return new ResponseEntity(service.sendOTPForgetPassword(username), HttpStatus.OK);
    }


    @GetMapping("/getUserDetails/{username}")
    public UserDetails getUserDetails(@PathVariable String username) {
        return  service.loadUserByUsername(username);
    }


    @PostMapping(value = {"/update/{username}"})
    public Response update(@Valid  @RequestBody UserUpdateModel user,@PathVariable String username) {
        return service.updateUser(username,user);
    }

    @GetMapping(value = {"/delete/{username}"})
    public boolean delete(@PathVariable String username) {
        return service.deleteByUsername(username);
    }


}
