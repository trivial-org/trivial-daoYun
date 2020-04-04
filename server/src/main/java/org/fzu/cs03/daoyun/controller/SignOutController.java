package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignInService;
import org.fzu.cs03.daoyun.service.SignOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SignOutController {

    @Autowired
    SignOutService signOutService;
    @Autowired
    ResponseService responseService;

    @PostMapping(value = "/signout")
    public String createAccount(@RequestBody User user , HttpServletRequest request){
        try{
            return signOutService.signOut(user.getUserName() ,request);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseGET(StatusCode.RESPONSE_ERR,e.toString(),"");
        }
    }
}
