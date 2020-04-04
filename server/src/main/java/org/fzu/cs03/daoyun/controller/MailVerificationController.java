package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.service.MailVerificationService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class MailVerificationController {

    @Autowired
    MailVerificationService mailVerificationService;
    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/verification/mail")
    public String getVerificationCode(@RequestParam(value = "email" ,required = true) String email ,HttpSession session){
        try{
            return mailVerificationService.generateVerificationCode(email,session);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseGET(StatusCode.RESPONSE_ERR,e.toString(),"");
        }

    }
}
