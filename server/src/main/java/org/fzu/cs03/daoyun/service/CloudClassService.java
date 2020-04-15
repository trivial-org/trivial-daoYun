package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.CloudClass;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.fzu.cs03.daoyun.entity.Orgnization;
import org.fzu.cs03.daoyun.exception.CloudClassException;
import org.fzu.cs03.daoyun.exception.DataDictionaryException;
import org.fzu.cs03.daoyun.exception.OrgMemberException;
import org.fzu.cs03.daoyun.exception.OrgnizationException;
import org.fzu.cs03.daoyun.mapper.OrgMemberMapper;
import org.fzu.cs03.daoyun.mapper.OrgnizationMapper;
import org.fzu.cs03.daoyun.mapper.RichTextMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Service
public class CloudClassService {

    @Autowired
    private RichTextMapper richTextMapper;
    @Autowired
    private OrgnizationMapper orgnizationMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private RichTextService richTextService;
    @Autowired
    private OrgMemberMapper orgMemberMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClassMemberService classMemberService;

    private final Logger logger = LoggerFactory.getLogger(CloudClassService.class);


    public String createCloudClass(CloudClass cloudClass, HttpServletRequest request) throws Exception{
        Long orgCode ;
        Long lastOrgCode = orgnizationMapper.getLastOrgCode();

        if (lastOrgCode == null) orgCode = 10000L;
        else orgCode = lastOrgCode + 1;

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        String creator = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        String orgName = creator + " 创建的组织";

        Long userId = userMapper.getUserIdByUserName(creator);
        if (userId == null)
            throw new CloudClassException("创建班级失败，创建者账户异常");

        String cloudClassDetail = JSON.toJSONString(cloudClass);
        Long richTextId = richTextService.createRichText(cloudClassDetail);
        //创建班课
        orgnizationMapper.cerateOrgnization(orgCode,orgName,richTextId,dateStr,creator,false);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        //创建者与组织的关系
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        classMemberService.addUserToClass(userId,orgId);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"创建成功",orgCode);
    }

    public String getOrgInfoByOrgCode(Long orgCode, HttpServletRequest request) throws Exception{
        if ( ! orgnizationMapper.OrgExistByOrgCode(orgCode)){
            throw new OrgnizationException("未找到对应组织");
        }
        Orgnization orgnization = orgnizationMapper.getOrgInfoByOrgCode(orgCode);
        JSONObject jsonObject = richTextService.objectPlusRichText(orgnization,"classCloud");
//        String classInfo = richTextService.getRichText(orgnization.getRichTextId());
//        JSONObject jsonObject = (JSONObject) JSON.toJSON(orgnization);
//        jsonObject.put("classCloud",JSON.parseObject(classInfo));
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"",jsonObject);
    }


    public String updateClassInfoByOrgCode(Long orgCode, CloudClass updateInfo,  HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if (orgId == null)
            throw new OrgMemberException("班课不存在");
        if (!orgMemberMapper.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        Long richTextId = orgnizationMapper.geRichTextIdByOrgCode(orgCode);
        richTextService.updateRichText(richTextId,updateInfo);

//        String classInfo = richTextService.getRichText(richTextId);
//        JSONObject readJsonObject = JSON.parseObject(classInfo);
//        JSONObject updateJsonObject = (JSONObject) JSON.toJSON(updateInfo);
//
//        for(Map.Entry<String, Object> entry: updateJsonObject.entrySet()){
//            if (entry.getValue() != null)
//                readJsonObject.put(entry.getKey(),entry.getValue());
//        }
//        richTextMapper.updateText(orgInfoId,JSON.toJSONString(readJsonObject));

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"修改成功");
    }


    public String deleteCloudClassAndMembers(Long orgCode,  HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if ( ! orgnizationMapper.OrgExistByOrgId(orgId))
            throw new CloudClassException("班课不存在，删除失败");
        if (!orgMemberMapper.userInOrgnization(userId,orgId))
            throw new OrgMemberException("用户不在该班课中");

        //删除班级+班级-成员联系
        this.deleteCloudClass(orgId);
        classMemberService.removeAllUsersFromClass(orgId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"删除成功");
    }


    //==== 共享调用 for classMember

    public void deleteCloudClass(Long orgId) throws Exception{
        Long richTextId = orgnizationMapper.geRichTextIdByOrgId(orgId);
        orgnizationMapper.deleteOrgnizationByOrgId(orgId);
        richTextService.deleteRichText(richTextId);
    }

}
