package org.fzu.cs03.daoyun.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.fzu.cs03.daoyun.exception.ActivityException;
import org.fzu.cs03.daoyun.mapper.*;
import org.fzu.cs03.daoyun.utils.DateFormater;
import org.fzu.cs03.daoyun.utils.DistanceMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/12 20:00
 */

@Service
public class ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    PublishedActivityMapper publishedActivityMapper;
    @Autowired
    private OrgnizationMapper orgnizationMapper;
    @Autowired
    private OrgMemberMapper orgMemberMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private DateFormater dateFormater;

    private final Logger logger = LoggerFactory.getLogger(ActivityService.class);


    public String createActivity(PublishedActivity publishedActivity, HttpServletRequest request){

        //需要做权限验证;比如签到活动同一时刻只能有一个激活

        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);

        Long orgCode = publishedActivity.getOrgCode();
        if (orgCode == null){
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"未指定班课号");
        }

        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);
        if (orgMemberMapper.userInOrgnization(userId,orgId) == Boolean.FALSE)
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"用户不在指定班课中");

        if (publishedActivity.getActivityTypeId() == null)
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"未指定活动类型");

        if (publishedActivity.getMaxDist() != null)
            if (publishedActivity.getLatitude() == null || publishedActivity.getLongitude() == null)
                return responseService.responseFactory(StatusCode.RESPONSE_ERR,"经纬度不可为空");

        // 设置publishedActivity初始值，
        // 其中ActivityTypeId,
        // activity_description(活动描述),
        // activity_param (活动参数) 一般需要带answer字段
        // 一般需要提供 publishedActivity.getSubmitParams();
        JSONObject submitParams = new JSONObject();
        if (submitParams != null){
            submitParams.put("answer",publishedActivity.getAnswer());
            String jsonString = submitParams.toJSONString();
            publishedActivity.setActivityParam(jsonString);
        }
        publishedActivity.setIsActive(Boolean.TRUE);
        publishedActivity.setBeginDate(dateFormater.getDate());
        publishedActivity.setOrgId(orgId);
        publishedActivity.setCreator(userName);

        publishedActivityMapper.insert(publishedActivity);

        //返回新创建的activityID
        Long id = publishedActivityMapper.getLastActivityId();
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"创建成功",id);
    }

    public String getActivitiesByOrgCode(Long orgCode, HttpServletRequest request) throws Exception{

        //需要做权限验证

        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);
        if (orgCode == null)
            throw new ActivityException("错误的班课号");

        Long orgId = orgnizationMapper.getOrgIdByOrgCode(orgCode);

        Boolean result =  orgMemberMapper.userInOrgnization(userId,orgId);
        if (result == Boolean.FALSE)
            throw new ActivityException("用户不在班课中或无权限");

        QueryWrapper<PublishedActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("is_active",1)
                .eq("org_id",orgId);


        List<PublishedActivity> results;
        results = publishedActivityMapper.selectList(wrapper);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",results);
    }

    public String closeActivityById(Long activityId, HttpServletRequest request){

        //需要做权限验证

        PublishedActivity publishedActivity = new PublishedActivity();
        publishedActivity.setIsActive(Boolean.FALSE);
        publishedActivity.setEndDate(dateFormater.getDate());
        publishedActivity.setId(activityId);
        publishedActivityMapper.updateById(publishedActivity);

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"活动成功被结束");
    }


    // 下面是参与活动部分(包含更新活动答案 等)
    public String attendActivity(AttendActivity attendActivity,  HttpServletRequest request) throws Exception{

        //权限验证
        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);

        Long activityId = attendActivity.getActivityId();
        if (activityId == null)
            throw new ActivityException("请提供活动id");

        PublishedActivity publishedActivity = publishedActivityMapper.selectById(activityId);

        if (publishedActivity == null)
            throw new ActivityException("不存在的活动id");

        if (publishedActivity.getIsActive() == Boolean.FALSE)
            throw new ActivityException("已经结束的活动");


        String activityParams = publishedActivity.getActivityParam();
        String answer = null;
        if (activityParams != null){
            JSONObject jsonObject = JSON.parseObject(activityParams);
            answer = (String) jsonObject.get("answer");
        }

        if (publishedActivity.getMaxDist()!=null){
            Double maxDist = Double.valueOf(publishedActivity.getMaxDist()) ;
            Double lat = Double.valueOf(publishedActivity.getLatitude());
            Double logt = Double.valueOf(publishedActivity.getLongitude());
            Double userLat = Double.valueOf(attendActivity.getLatitude());
            Double userLogt = Double.valueOf(attendActivity.getLongitude());


            Double dist = DistanceMetric.getDistance(lat,logt,userLat,userLogt);
            if (dist > maxDist){
                return responseService.responseFactory(StatusCode.RESPONSE_ERR,"距离活动源距离超出限制");
            }
        }

        String submit = attendActivity.getAnswer(); //提交的答案
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("answer",submit);
        attendActivity.setSubmitParam(jsonObject2.toJSONString()); //为提交参数加入提交的answer

        Boolean consistent ;
        //比较答案和提交是否一致
        if ( (submit == null && answer == null) || submit.equals(answer) )
        {
            attendActivity.setScore(publishedActivity.getMaxscore());
            attendActivity.setValid(Boolean.TRUE);
            consistent = Boolean.TRUE;
        }
        else{
            attendActivity.setScore(0);
            attendActivity.setValid(Boolean.FALSE);
            consistent = Boolean.FALSE;
        }

        attendActivity.setId(null); // 防止id被恶意写入，清空一下
        attendActivity.setGroupId(null);
        attendActivity.setUserId(userId);

        // 判断是否首次参与,一个活动一个账户只能参与一次
        QueryWrapper<AttendActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("activity_id",activityId)
                .eq("user_id",userId);
        AttendActivity result =  activityMapper.selectOne(wrapper);

        //首次参与
        if (result == null){
            attendActivity.setEditTimes(1);
            activityMapper.insert(attendActivity);
        }
        else if (result.getValid() == Boolean.TRUE){
            //已经成功参与，拒绝再次参与
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"已经参加过该活动");
        }
        else{

            attendActivity.setId(result.getId());
            attendActivity.setEditTimes(result.getEditTimes() + 1);
            activityMapper.updateById(attendActivity);
        }

        if (consistent == Boolean.TRUE)
            return responseService.responseFactory(StatusCode.RESPONSE_OK,"参与成功");
        else
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,"答案错误");
    }

    public String getActivityAttendingState(Long activityId, Integer page,Integer pageSize,
                                                          HttpServletRequest request) throws Exception{

        //权限验证

        if (page == null || pageSize == null){
            page = 1;
            pageSize = 10;
        }

        String userName = request.getSession().getAttribute(GlobalConstant.sessionUser).toString();
        Long userId = userMapper.getUserIdByUserName(userName);

        if (activityId == null)
            throw new ActivityException("请提供活动id");

        PublishedActivity publishedActivity = publishedActivityMapper.selectById(activityId);

        if (publishedActivity == null)
            throw new ActivityException("不存在的活动id");

        List<AttendActivity> results;
        Page<AttendActivity> pageManager = new Page<>(page,pageSize);
        QueryWrapper<AttendActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("activity_id",activityId);
        results = activityMapper.selectPage(pageManager,wrapper).getRecords();

        return responseService.responseFactory(StatusCode.RESPONSE_OK,"查询成功",results);
    }


}
