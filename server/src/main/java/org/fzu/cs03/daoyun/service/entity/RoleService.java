package org.fzu.cs03.daoyun.service.entity;

import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.mapper.RoleMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRoleList(){
        return roleMapper.getRoleList();
    }
}
