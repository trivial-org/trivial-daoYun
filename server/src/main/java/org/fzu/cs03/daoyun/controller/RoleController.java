package org.fzu.cs03.daoyun.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.ClassParams;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.service.ClassParamsService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.service.admin.RoleService;
import org.fzu.cs03.daoyun.utils.DateFormater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/16 15:29
 */
@RestController
@CrossOrigin
public class RoleController  {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private RoleService roleService ;

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @PostMapping(value = "/role")
    public String addRole(
            @RequestBody Role role,
            HttpServletRequest request){
        try{
            return roleService.addRole(role,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @DeleteMapping(value = "/role")
    public String deleteRole(
            @RequestParam(value = "roleId" ,required = true) Long roleId,
            HttpServletRequest request){
        try{
            return roleService.deleteRole(roleId, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/role")
    public String getRoles(
            @RequestParam(value = "roleId" ,required = false) Long roleId,
            @RequestParam(value = "page" ,required = false) Long page,
            @RequestParam(value = "pageSize" ,required = false) Long pageSize,
            HttpServletRequest request){
        try{
            if (roleId == null)
                return roleService.getRoles(page,pageSize, request);
            else
                return roleService.getRoleById(roleId,request);

        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/role/total")
    public String getRolesCount(
            HttpServletRequest request){
        try{
            return roleService.getRolesCount(request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PutMapping(value = "/role")
    public String updateRole(
            @RequestBody Role role,
            HttpServletRequest request){
        try{
            return roleService.updateRole(role, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

}
