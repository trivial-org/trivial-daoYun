package org.fzu.cs03.daoyun.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Menu;
import org.fzu.cs03.daoyun.service.MenuService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class MenuController {
    @Autowired
    MenuService menuService;
    @Autowired
    ResponseService responseService;

    @GetMapping(value = "/menuTreeAll")
    //@RequiresRoles("USER")
    //@RequiresPermissions("system:user:list")
    public String getMenuTreeAll(
            HttpServletRequest request){
        try{
            return menuService.buildTreeMenuAll(request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }


    //根据角色id获取对于的菜单树
    @GetMapping(value = "/roleMenuTree/{roleId}")
    public String roleMenuTree(@PathVariable("roleId") Long roleId ,HttpServletRequest request)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        List<SysMenu> menus = menuService.selectMenuList(loginUser.getUser().getUserId());
        try{
            return menuService.buildTreeMenuByRoleId(roleId,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }
    //根据用户id获取对应的菜单树
    @GetMapping(value = "/userMenuTree/{userId}")
    public String userMenuTree(@PathVariable("userId") Long userId ,HttpServletRequest request)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        List<SysMenu> menus = menuService.selectMenuList(loginUser.getUser().getUserId());
        try{
            return menuService.buildTreeMenuByUserId(userId,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }


    @PostMapping (value = "/menuAdd")
    public String menuAdd(@RequestBody Menu menu , HttpServletRequest request)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        List<SysMenu> menus = menuService.selectMenuList(loginUser.getUser().getUserId());
        if (!menuService.checkMenuNameUnique(menu))
        {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        //menu.setCreateBy(SecurityUtils.getUsername());
        try{
            return menuService.insertMenu(menu,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }

    @PutMapping(value = "/menuEdit")
    public String menuEdit(@RequestBody Menu menu , HttpServletRequest request)
    {
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        List<SysMenu> menus = menuService.selectMenuList(loginUser.getUser().getUserId());
        if (!menuService.checkMenuNameUnique(menu))
        {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        //menu.setCreateBy(SecurityUtils.getUsername());
        try{
            return menuService.updateMenu(menu,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }


    @DeleteMapping("/menuDelete/{menuId}")
    public String menuRemove(@PathVariable("menuId") Long menuId, HttpServletRequest request)
    {
        if (menuService.hasChildByMenuId(menuId))
        {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"存在子菜单,不允许删除");
        }
        if (menuService.checkMenuExistRole(menuId))
        {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"菜单已分配,不允许删除");
        }
        try{
            return menuService.deleteMenuById(menuId);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }

    }




}
