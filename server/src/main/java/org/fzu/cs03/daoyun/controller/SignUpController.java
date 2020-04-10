package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Student;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignUpService;
import org.fzu.cs03.daoyun.service.entity.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class SignUpController {

    @Autowired
    SignUpService signUpService;
    @Autowired
    UserService userService;
    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(SignUpController.class);


    // 用户是否存在
    @GetMapping(value = "/signup/users")
    public String userExist(@RequestParam(value = "userName" ,required = true) String userName, HttpServletRequest request){
        try{
//            String info = "用户: " + request.getSession().getId() + "， 欲访问: "+request.getRequestURI();
            return signUpService.userExist(userName);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PostMapping(value = "/signup")
    public String createAccount(@RequestBody User user, HttpServletRequest request){
        try{
            System.out.println("用户: " + request.getSession().getId() + "， 欲访问: "+request.getRequestURI());
            return signUpService.signUp(user,request.getSession());
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }


}
