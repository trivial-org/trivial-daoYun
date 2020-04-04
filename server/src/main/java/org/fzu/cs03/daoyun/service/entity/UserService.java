package org.fzu.cs03.daoyun.service.entity;


import org.fzu.cs03.daoyun.entity.User;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> getUserList(){
        return userMapper.getUserList();
    }




}
