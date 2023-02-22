package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.repository.NotificationRepository;
import com.iraqsofit.speedoo.service.NotificationService;
import com.iraqsofit.speedoo.service.UserDateilsService;
import com.iraqsofit.speedoo.user.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/gemstone/v1")
@RestController
public class HomeAppController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserDateilsService userDateilsService;
    //privacy
    //About
    @GetMapping("/about")
    public PrivacyOrAboutModel about (){
        return  new PrivacyOrAboutModel("2022-12-31","هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع. ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق. هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.\n");
    }

    @GetMapping("/privacy")
    public PrivacyOrAboutModel privacy (){
        return  new PrivacyOrAboutModel("2022-12-30","هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع. ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق. هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.\n");
    }

    @GetMapping("/category")
    public Response GetCategory(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(2,"Category1","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(3,"Category2","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        categoryList.add(new Category(4,"Category3","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(5,"Category4","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        categoryList.add(new Category(6,"Category5","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(7,"Category6","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        return new Response<>(
                true,
                categoryList,
                "success",
                200
        );
    }

    @GetMapping("/banners")
    public Response GetBanners(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Banner1","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        categoryList.add(new Category(1,"Banner2","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        categoryList.add(new Category(1,"Banner3","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        return new Response<>(
                true,
                categoryList,
                "success",
                200
        );
    }


    @GetMapping("/notification/{username}")
    public Response getNotification(@PathVariable String username){
        List<NotificationModel> notificationModelList = new ArrayList<>();
        notificationModelList.add(new NotificationModel("وصول الطلب","الطلب قيد التوصيل رقم الطلب 34","2023-02-22 23:28:07",0,"c07aa8c0-a6cd-438c-a1c4-7d09239e73f7"));
        notificationModelList.add(new NotificationModel("تأكيد الطلب","الطلب رقم 12345 قد تم تأكيده. لمشاهدة التفاصيل اضغط هنا","2023-02-22 23:28:07",1,"52d0c0ea-a0cd-4c97-996f-a406434b5595"));
        notificationModelList.add(new NotificationModel("إلغاء الطلب","الطلب رقم 12345 قد تم إلغاؤه. لمشاهدة التفاصيل اضغط هنا","2023-02-22 23:28:07",2,"8a05702c-a5d2-4cc8-9d89-69e3119d830f"));
        return new Response<>(
                true,
                notificationModelList,
                "success",
                200
        );
    }




}
