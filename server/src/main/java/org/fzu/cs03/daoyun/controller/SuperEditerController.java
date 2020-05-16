package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.admin.RoleService;
import org.fzu.cs03.daoyun.service.admin.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/16 14:11
 */

@RestController
@CrossOrigin
public class SuperEditerController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private UserService userService ;

    private final Logger logger = LoggerFactory.getLogger(SuperEditerController.class);

    @PostMapping(value = "/super/users")
    public String addUser(
            @RequestBody User user,
            HttpServletRequest request){
        try{
            return userService.addUser(user,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @DeleteMapping(value = "/super/users")
    public String deleteUser(
            @RequestParam(value = "userId" ,required = true) Long userId,
            HttpServletRequest request){
        try{
            return userService.deleteUser(userId, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/super/users")
    public String getUsers(
            @RequestParam(value = "page" ,required = true) Long page,
            @RequestParam(value = "pageSize" ,required = true) Long pageSize,
            HttpServletRequest request){
        try{
            return userService.getUsers(page,pageSize, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PutMapping(value = "/super/users")
    public String updateUser(
            @RequestBody User user,
            HttpServletRequest request){
        try{
            return userService.updateUser(user, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }



}
