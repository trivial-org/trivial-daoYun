package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.CloudClass;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.fzu.cs03.daoyun.mapper.UserMapper;
import org.fzu.cs03.daoyun.service.ActivityService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/14 1:59
 */

@RestController
@CrossOrigin
public class ActivityController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResponseService responseService;
    @Autowired
    private ActivityService activityService;

    private final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @PostMapping(value = "/activities")
    public String createActivity(
            @RequestBody PublishedActivity publishedActivity,
                                   HttpServletRequest request){
        try{
            return activityService.createActivity(publishedActivity, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/activities")
    public String getActivities(
            @RequestParam(value = "orgCode" ,required = true) Long orgCode,
            HttpServletRequest request) {

        try{
            return activityService.getActivitiesByOrgCode(orgCode, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PutMapping(value = "/activities")
    public String closeActivity(
            @RequestParam(value = "activityId" ,required = true) Long activityId,
            HttpServletRequest request){
        try{
            return activityService.closeActivityById(activityId, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }


    @PostMapping(value = "/activities/records")
    public String participateInActivity(
            @RequestBody AttendActivity attendActivity,
            HttpServletRequest request){
        try{
            return activityService.attendActivity(attendActivity, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }


    @GetMapping(value = "/activities/records")
    public String getActivityAttendingState(
            @RequestParam(value = "activityId" ,required = true) Long activityId,
            @RequestParam(value = "page" ,required = true) Integer page,
            @RequestParam(value = "pageSize" ,required = true) Integer pageSize,
            HttpServletRequest request){
        try{
            return activityService.getActivityAttendingState(activityId,page,pageSize, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

}
