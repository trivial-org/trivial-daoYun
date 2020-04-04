package org.fzu.cs03.daoyun.controller;


import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.entity.Student;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.mapper.RoleMapper;
import org.fzu.cs03.daoyun.service.StudentServiceImpl;
import org.fzu.cs03.daoyun.service.entity.RoleService;
import org.fzu.cs03.daoyun.service.entity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import sun.jvm.hotspot.debugger.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


//@Controller
//@ResponseBody
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }


    @RequestMapping("/getRoleList")
    public List<Role> getRoleList(Model model){
        return roleService.getRoleList();
    }

    @RequestMapping("device")
    public String index(HttpServletRequest request){
        LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
        Device device = deviceResolver.resolveDevice(request);

        String device_name ;
        String platform = device.getDevicePlatform().toString();

        if (device.isMobile()){ device_name = "手机"; }
        else if (device.isTablet()){ device_name = "平板电脑"; }
        else if (device.isNormal()){  device_name = "PC端"; }
        else{ device_name = "未知的终端"; }

        return "访问设备:" + device_name + ", 访问平台:" + platform;
    }


}