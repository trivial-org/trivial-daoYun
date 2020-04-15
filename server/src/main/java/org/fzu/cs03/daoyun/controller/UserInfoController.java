package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.CloudClass;
import org.fzu.cs03.daoyun.entity.UserUpdate;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/user/info")
    public String updateUserInfo(
            @RequestBody UserUpdate userUpdate,
            HttpServletRequest request){
        try{
            return userInfoService.updateUserInfo(userUpdate,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/user/info")
    public String getUserInfo(
            @RequestParam(value = "userName" ,required = false) String userName,
            HttpServletRequest request){
        try{
            String currUserName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
            if (userName == null || userName.equals(currUserName))
                return userInfoService.getAllUserInfo(request);
            else
                return userInfoService.getSimpleUserInfo(userName, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }


}
