package org.fzu.cs03.daoyun.service;


import org.apache.commons.lang3.StringUtils;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Menu;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.mapper.MenuMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.utils.DateFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private DateFormater dateFormater;
    @Autowired
    private MenuMapper menuMapper;



//    public String createActivity(PublishedActivity publishedActivity, HttpServletRequest request){
//
//        return responseService.responseFactory(StatusCode.RESPONSE_OK,"创建成功",id);
//    }
    /**
     * 查询系统所有菜单列表
     *
     * @param menu 菜单信息
     * @return 菜单列表
     */

    public List<Menu> selectMenuList()
    {
        List<Menu> menuList = null;
//            menu.getParams().put("userId", userId);
            menuList = menuMapper.selectMenuList();
        return menuList;
    }
    //建立所有的菜单项的菜单树
    public String buildTreeMenuAll(){
        List<Menu> menuList = menuMapper.selectMenuList();
        List<Menu> treeMenuAll = null;
        try {
            treeMenuAll = this.buildTreeMenu(menuList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",treeMenuAll);

    }

    //根据角色id建立该角色拥有的菜单项的菜单树
    public String buildTreeMenuByRoleId(Long roleId , HttpServletRequest request){
        List<Menu> menuList = menuMapper.selectMenuByRoleId(roleId);
        List<Menu> treeMenu = null;
        try {
            treeMenu = this.buildTreeMenu(menuList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",treeMenu);

    }

    //根据用户id建立该角色拥有的菜单项的菜单树
    public String buildTreeMenuByUserId(Long userId , HttpServletRequest request){
        User user =userMapper.selectById(userId);
        Long roleId = user.getRoleId();
        List<Menu> menuList = menuMapper.selectMenuByRoleId(roleId);
        List<Menu> treeMenu = null;
        try {
            treeMenu = this.buildTreeMenu(menuList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",treeMenu);

    }

    public List<Menu> buildTreeMenu(List<Menu> menu) throws Exception {
        List<Menu> parentList = this.findParent(menu);
        return this.findChildren(parentList, menu);
    }

    public List<Menu> findParent(List<Menu> menu) throws Exception {
        List<Menu> menuList = new ArrayList<>();
        for (Menu sysMenu: menu) {
            String parentId = sysMenu.getParentId().toString();
            Boolean flag = true;
            for (Menu sysMenu1:menu) {
                if (parentId.equals(sysMenu1.getId().toString())) {
                    flag = false;
                }
            }
            if (flag) {
                menuList.add(sysMenu);
            }
        }
        return menuList;
    }
    /**
     * 递归查找子节点
     *
     */
    public List<Menu> findChildren(List<Menu> parentList, List<Menu> menu) throws Exception {
        for (Menu sysMenu: parentList) {
            List<Menu> childList = new ArrayList<>();
            for (Menu it : menu) {
                if (sysMenu.getId().toString().equals(it.getParentId().toString())) {
                    childList.add(it);
                }
            }
            sysMenu.setChildren(childList);
            if (childList.size() > 0) {
                findChildren(childList, menu);
            }
        }
        return parentList;
    }

    //新增菜单
    public String insertMenu(Menu menu , HttpServletRequest request){

        menuMapper.insertMenu(menu);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"新增菜单成功");

    }

    //查询菜单是否唯一，也就是菜单是否已存在                           HttpServletRequest request
    public boolean checkMenuNameUnique(Menu menu ){
//        Long menuId;
//        if(menu.getId()==null){
//            menuId= -1L;
//        }else{
//            menuId=menu.getId();
//        }
        //是不是要再加一个id进去查询，保证一下id也不一样？
        Menu info = menuMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());

        if ( info==null )
        {   //查不到菜单名和父ID一样的，说明是唯一的，可以插入
            return true;
        }
        return false;

    }

    public String updateMenu(Menu menu , HttpServletRequest request){

        menuMapper.updateMenu(menu);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"修改菜单成功");

    }


    public boolean hasChildByMenuId(Long menuId ) {
        int result = menuMapper.hasChildByMenuId(menuId);
        return result > 0 ? true : false;
    }


    public boolean checkMenuExistRole(Long menuId)
    {
        int result = menuMapper.checkMenuExistRole(menuId);
        return result > 0 ? true : false;
    }

    public String deleteMenuById(Long menuId)
    {

        menuMapper.deleteMenuById(menuId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"删除菜单成功");
    }

}
