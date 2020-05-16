package org.fzu.cs03.daoyun.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.exception.RoleException;
import org.fzu.cs03.daoyun.exception.UserException;
import org.fzu.cs03.daoyun.mapper.RoleMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/16 14:13
 */

@Service
// 该服务用于对用户的完全控制，仅限超级管理员使用
public class UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String addUser(User user, HttpServletRequest request) throws Exception{
        //auth

        user.setId(null);

        if (user.getUsername() == null)
            throw new UserException("用户名不能为空");

        if (user.getPassword() == null)
            throw new UserException("密码不能为空");

        user.setIsActive(Boolean.TRUE);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        User res = userMapper.selectOne(wrapper);
        if (res != null)
            throw new UserException("用户名已存在");

        userMapper.insert(user);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"创建成功");
    }

    public String deleteUser(Long userId, HttpServletRequest request){
        //auth
        userMapper.deleteById(userId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"删除成功");
    }

    public String getUsers(Long page,Long pageSize, HttpServletRequest request) throws Exception{
        //auth

        List<User> results;
        Page<User> pageManager = new Page<>(page,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select(User.class, info -> !info.getColumn().equals("password"));
        results = userMapper.selectPage(pageManager,wrapper).getRecords();
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",results);
    }

    public String updateUser(User user, HttpServletRequest request) throws Exception{
        //auth
        if (user == null || user.getId() == null){
            throw new UserException("未指定的用户id");
        }
        //可以直接更新密码，但不能读取.

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        List<User> res = userMapper.selectList(wrapper);
        if (res.size() > 1)
            throw new RoleException("用户名已存在");
        if (res.get(0).getId() != user.getId())
            throw new RoleException("用户名已存在");

        userMapper.updateById(user);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"更新成功");
    }
}
