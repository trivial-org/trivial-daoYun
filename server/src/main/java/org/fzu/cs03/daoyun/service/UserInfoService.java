package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.*;
import org.fzu.cs03.daoyun.exception.UserInfoException;
import org.fzu.cs03.daoyun.mapper.OrgMemberMapper;
import org.fzu.cs03.daoyun.mapper.OrgnizationMapper;
import org.fzu.cs03.daoyun.mapper.RichTextMapper;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/9 16:40
 */

@Service
public class UserInfoService {
    @Autowired
    private OrgnizationMapper orgnizationMapper;
    @Autowired
    private OrgMemberMapper orgMemberMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RichTextMapper richTextMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private RichTextService richTextService;

    private final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    public String getUserJoinedClass(HttpServletRequest request) throws Exception {
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
//        List<Orgnization> res = userMapper.getUserJoinedOrgnization(userId);
        // 仅返回用户加入的群组（排除用户创建的群组)
        List<Orgnization> res = userMapper.getUserJoinedOrgnizationExcludeCreated(userId, userName);
        JSONArray jsonArray = richTextService.objectListPlusRichText(res,"cloudClass");
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"",jsonArray);
    }

    public String getUserCreatedClass(HttpServletRequest request) throws Exception {
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        List<Orgnization> res = userMapper.getUserCreatedOrgnization(userId,userName);
        System.out.println(res.size());
        JSONArray jsonArray = richTextService.objectListPlusRichText(res,"cloudClass");
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"",jsonArray);
    }

    public String updateUserInfo(UserUpdate userUpdate,  HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        UserUpdate oldUserUpdatableInfo = userMapper.getUserUpdatableInfoByUserId(userId);
        //个体用jsonobj,list用jsonarray
        JSONObject oldJsonObject = (JSONObject) JSON.toJSON(oldUserUpdatableInfo);
        JSONObject newJsonObject = (JSONObject) JSON.toJSON(userUpdate);

        for(Map.Entry<String, Object> entry: newJsonObject.entrySet()){
            if (entry.getValue() != null)
                oldJsonObject.put(entry.getKey(),entry.getValue());
        }

        UserUpdate newUserInfo = JSON.toJavaObject(oldJsonObject,UserUpdate.class);
        userMapper.updateUserInfoByUserId(userId,newUserInfo.getNickName(),newUserInfo.getStudentId(),
                newUserInfo.getGender(),newUserInfo.getProfilePhotoUrl(),newUserInfo.getSchool(),
                newUserInfo.getMajor(),newUserInfo.getCollege(),newUserInfo.getEducation(),
                newUserInfo.getBirthDate(),newUserInfo.getAddress(),newUserInfo.getCity(),
                newUserInfo.getProvince(),newUserInfo.getNation());

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"更新用户信息成功");
    }

    public String getSimpleUserInfo(String userName, HttpServletRequest request) throws Exception{
        if (!userMapper.userExist(userName))
            throw new UserInfoException("无此用户");
        Long userId = userMapper.getUserIdByUserName(userName);
        SimpleUserInfo simpleUserInfo = userMapper.getSimpleUserInfoByUserId(userId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",simpleUserInfo);
    }

    public String getAllUserInfo(HttpServletRequest request) throws Exception{
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        AllUserInfo allUserInfo = userMapper.getAllUserInfoByUserId(userId);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",allUserInfo);
    }

}
