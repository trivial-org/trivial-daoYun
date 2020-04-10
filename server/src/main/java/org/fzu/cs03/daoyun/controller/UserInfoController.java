package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/9 16:40
 */


@RestController
@CrossOrigin
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @GetMapping(value = "/user/joinedClass")
    public String getUserJoinedClass(
            HttpServletRequest request){
        try{
            return userInfoService.getUserJoinedClass(request);

        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/user/createdClass")
    public String getUserCreatedClass(
            HttpServletRequest request){
        try{
            return userInfoService.getUserCreatedClass(request);

        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }




}
