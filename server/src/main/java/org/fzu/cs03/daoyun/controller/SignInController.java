package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SignInController {

    @Autowired
    SignInService signInService;
    @Autowired
    ResponseService responseService;

    @PostMapping(value = "/signin")
    public String createAccount(@RequestBody User user, HttpServletRequest request){
        try{
            return signInService.signIn(user,request);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responsePOST(StatusCode.RESPONSE_ERR,e.toString());
        }
    }
}
