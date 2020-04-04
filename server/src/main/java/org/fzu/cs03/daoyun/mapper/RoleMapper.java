package org.fzu.cs03.daoyun.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface RoleMapper {

    @Select("select * from role")
    List<Role> getRoleList();
}
