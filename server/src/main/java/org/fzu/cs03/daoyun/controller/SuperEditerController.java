package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.admin.RoleService;
import org.fzu.cs03.daoyun.service.admin.UserService;
import org.fzu.cs03.daoyun.utils.StringVerifier;
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
            @RequestParam(value = "userId" ,required = false) Long userId,
            @RequestParam(value = "username" ,required = false) String username,
            @RequestParam(value = "page" ,required = false) Long page,
            @RequestParam(value = "pageSize" ,required = false) Long pageSize,
            HttpServletRequest request){
        try{

            if (userId != null)
                return userService.getUserDetailById(userId,request);
            else if (username != null)
                return userService.getUserDetailByName(username,request);
            else
                return userService.getUsers(page,pageSize, request);

        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/super/users/total")
    public String getUsersCount(
            HttpServletRequest request){
        try{
            return userService.getUsersCount(request);
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
