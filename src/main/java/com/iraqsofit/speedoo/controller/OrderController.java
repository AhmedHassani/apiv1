package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.service.NotificationService;
import com.iraqsofit.speedoo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/api/gemstone/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    NotificationService notificationService;

    @PostMapping(value = "/initOrder")
    public ResponseEntity initOrder(@RequestBody  RequestInitOrders requestInitOrders,@RequestHeader("playerId") String playerId) {
        if(!playerId.isEmpty()){
            notificationService.sentNotification(playerId,false);
        }
        return  new ResponseEntity(orderService.initOrder(requestInitOrders),HttpStatus.OK);
    }


    @GetMapping(value = {"/lastOrder/{username}"})
    public ResponseEntity lastOrder(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity(orderService.ListOrder(username,pageNo,pageSize,sortBy),HttpStatus.OK);
    }


    @DeleteMapping(value = {"/delete/{id}"})
    public ResponseEntity delete(@PathVariable long id){
        return new ResponseEntity<>(orderService.deleteOrder(id),HttpStatus.OK);
    }
}
