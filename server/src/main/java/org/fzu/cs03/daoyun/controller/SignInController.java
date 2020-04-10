package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class SignInController {

    @Autowired
    SignInService signInService;
    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(SignInController.class);

    @PostMapping(value = "/signin")
    public String createAccount(@RequestBody User user, HttpServletRequest request){
        try{
//            String info = "用户: " + request.getSession().getId() + "， 欲访问: "+request.getRequestURI()
//            logger.info(info);
            return signInService.signIn(user,request);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }
}
