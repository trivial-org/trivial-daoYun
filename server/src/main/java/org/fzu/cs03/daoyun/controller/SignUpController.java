package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Student;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.SignUpService;
import org.fzu.cs03.daoyun.service.entity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class SignUpController {

    @Autowired
    SignUpService signUpService;
    @Autowired
    UserService userService;
    @Autowired
    ResponseService responseService;


    @GetMapping(value = "/userExist")
    public String createAccount(@RequestParam(value = "userName" ,required = true) String userName){
        try{
            return signUpService.userExist(userName);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseGET(StatusCode.RESPONSE_ERR,e.toString(),"");
        }
    }

    @PostMapping(value = "/signup")
    public String createAccount(@RequestBody User user, HttpSession session){
        try{
            return signUpService.signUp(user,session);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responsePOST(StatusCode.RESPONSE_ERR,e.toString());
        }

    }


}
