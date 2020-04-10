package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.ClassMember;
import org.fzu.cs03.daoyun.entity.ClassMemberUpdate;
import org.fzu.cs03.daoyun.entity.RequestUser;
import org.fzu.cs03.daoyun.exception.OrgMemberException;
import org.fzu.cs03.daoyun.mapper.OrgMemberMapper;
import org.fzu.cs03.daoyun.mapper.OrgnizationMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/9 16:09
 */

@Service
public class ClassMemberService {

    @Autowired
    private OrgnizationMapper orgnizationMapper;
    @Autowired
    private OrgMemberMapper orgMemberMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private RichTextService richTextService;
    @Autowired
    private CloudClassService cloudClassService;

    private final Logger logger = LoggerFactory.getLogger(ClassMemberService.class);

    private boolean userInOrgnization(Long userId, Long orgId){

        return orgMemberMapper.userInOrgnization(userId,orgId);
    }
    private String createDefaultClassMemberInfo(){
        ClassMemberUpdate classMemberUpdate = new ClassMemberUpdate();
        classMemberUpdate.setUserClassCollege("电气学院");
        classMemberUpdate.setUserClassMajor("电力系统及其自动化");
        classMemberUpdate.setUserClassNumber("0000");
        classMemberUpdate.setUserClassSchool("南京航空航天大学");
        String json = JSON.toJSONString(classMemberUpdate);
        return json;
    }

    public String userJoinClass(long orgCode,  HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);

        this.addUserToClass(userId,orgId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"加入成功");
    }

    public String userQuitClass(Long orgCode,  HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        this.removeUserFromClass(userId,orgId);

        //若当前用户退出，班级为空，则删除班级
        if (orgMemberMapper.getClassMemberNumber(orgId) == 0L){
            cloudClassService.deleteCloudClass(orgId);
        }

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"退出成功");
    }


    public String updateClassMemberInfo(long orgCode, ClassMemberUpdate classMemberUpdate, HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if (orgId == null)
            throw new OrgMemberException("班课不存在");

        if ( ! this.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        Long richId = orgMemberMapper.getRichTextId(userId,orgId);
        richTextService.updateRichText(richId,classMemberUpdate);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"更新成功");
    }


    // 获取成员信息
    public String getMembersByOrgCode(Long orgCode, HttpServletRequest request) throws Exception{

        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if (orgId == null)
            throw new OrgMemberException("班课不存在");

        if (!this.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        List<ClassMember> res = orgMemberMapper.getMembersByOrgId(orgId);
        JSONArray jsonArray = richTextService.objectListPlusRichText(res,"memberDetail");

        if(jsonArray.size() == 0)
            throw new OrgMemberException("结果数为0");

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",jsonArray);
    }


    public String getMembersByOrgCode(Long orgCode, Long page, Long pageSize, HttpServletRequest request) throws Exception{

        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if (orgId == null)
            throw new OrgMemberException("班课不存在");

        if (!this.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        List<ClassMember> res = orgMemberMapper.getMembersPageByOrgId(orgId,pageSize,(page-1)*pageSize);
        JSONArray jsonArray = richTextService.objectListPlusRichText(res,"memberDetail");

        if(jsonArray.size() == 0)
            throw new OrgMemberException("结果数为0");

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",jsonArray);
    }


    public void addUserToClass(Long userId, Long orgId) throws Exception {
        if (orgId == null)
            throw new OrgMemberException("班课不存在");
        if (this.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户已经存在于该班课中");

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);

        //创建班级-成员的联系 , 两句最好用事务...
        Long richId = richTextService.createRichText(this.createDefaultClassMemberInfo());
        orgMemberMapper.addUserToOrgnization(userId,orgId,0L,richId,dateStr,false);
    }

    public void removeAllUsersFromClass(Long orgId) throws Exception{
        if (orgId == null)
            throw new OrgMemberException("班课不存在");
        //删除所有班级成员
        orgMemberMapper.deleteAllUsersFromOrgnization(orgId);
    }

    public void removeUserFromClass(Long userId, Long orgId) throws Exception {
        if (orgId == null)
            throw new OrgMemberException("班课不存在");
        if (!this.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        //删除班级-成员的联系
        Long richTextId = orgMemberMapper.getRichTextId(userId,orgId);
        orgMemberMapper.deleteUserFromOrgnization(userId,orgId);
        richTextService.deleteRichText(richTextId);
    }

}
