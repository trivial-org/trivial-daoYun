package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignInService;
import org.fzu.cs03.daoyun.service.SignOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class SignOutController {

    @Autowired
    SignOutService signOutService;
    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(SignOutController.class);


    @PostMapping(value = "/signout")
    public String createAccount(@RequestBody User user , HttpServletRequest request){
        try{
//            String info = "用户: " + request.getSession().getId() + "， 欲访问: "+request.getRequestURI();
            return signOutService.signOut(user.getUserName() ,request);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }
}
