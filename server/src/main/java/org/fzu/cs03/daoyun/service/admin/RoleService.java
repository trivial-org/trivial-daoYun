package org.fzu.cs03.daoyun.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Role;
import org.fzu.cs03.daoyun.exception.RoleException;
import org.fzu.cs03.daoyun.mapper.RoleMapper;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);

    public String addRole(Role role, HttpServletRequest request) throws Exception{
        //auth

        role.setId(null);
        role.setIsTemplate(Boolean.TRUE);

        if (role.getRoleCode() == null)
            throw new RoleException("角色代码不能为空");

        if (role.getRoleName() == null)
            throw new RoleException("角色名不能为空");


        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_code",role.getRoleCode());
        Role res = roleMapper.selectOne(wrapper);
        if (res != null)
            throw new RoleException("角色代码已存在");

        roleMapper.insert(role);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"创建成功");
    }

    public String deleteRole(Long roleId, HttpServletRequest request){
        //auth

        roleMapper.deleteById(roleId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"删除成功");
    }

    public String getRoles(Long page,Long pageSize, HttpServletRequest request) throws Exception{
        //auth

        List<Role> results;
        Page<Role> pageManager = new Page<>(page,pageSize);
        results = roleMapper.selectPage(pageManager,null).getRecords();
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",results);
    }

    public String updateRole(Role role, HttpServletRequest request) throws Exception{
        //auth
        if (role == null || role.getId() == null){
            throw new RoleException("未指定的参数id");
        }

        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_code",role.getRoleCode());
        List<Role> res = roleMapper.selectList(wrapper);
        if (res.size() > 1)
            throw new RoleException("角色代码已存在");
        if (res.get(0).getId() != role.getId())
            throw new RoleException("角色代码已存在");

        roleMapper.updateById(role);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"更新成功");
    }
}
