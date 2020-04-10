package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.Orgnization;
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
        long userId = userMapper.getUserIdByUserName(userName);
        List<Orgnization> res = userMapper.getUserJoinedOrgnization(userId);
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
}
