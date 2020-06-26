package org.fzu.cs03.daoyun.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT role_name FROM role WHERE id = #{id}")
    String getRolenameByRoleId(Long id);

}
