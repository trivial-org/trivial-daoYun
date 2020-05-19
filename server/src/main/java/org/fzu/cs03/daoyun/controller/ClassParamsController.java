package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.ClassParams;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.fzu.cs03.daoyun.mapper.ClassParamsMapper;
import org.fzu.cs03.daoyun.service.ClassParamsService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.fzu.cs03.daoyun.utils.DateFormater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/16 15:22
 */
@RestController
@CrossOrigin
public class ClassParamsController {
    @Autowired
    private ResponseService responseService;
    @Autowired
    private DateFormater dateFormater;

    @Autowired
    private ClassParamsService classParamsService ;

    private final Logger logger = LoggerFactory.getLogger(ClassParamsController.class);

    @PostMapping(value = "/params/class")
    public String addParam(
            @RequestBody ClassParams classParams,
            HttpServletRequest request){
        try{
            return classParamsService.addParam(classParams,request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @DeleteMapping(value = "/params/class")
    public String deleteParam(
            @RequestParam(value = "paramId" ,required = true) Long paramId,
            HttpServletRequest request){
        try{
            return classParamsService.deleteParam(paramId, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/params/class")
    public String getParams(
            @RequestParam(value = "orgCode" ,required = true) Long orgCode,
            @RequestParam(value = "page" ,required = false) Long page,
            @RequestParam(value = "pageSize" ,required = false) Long pageSize,
            HttpServletRequest request){
        try{
            return classParamsService.getParams(orgCode,page,pageSize, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PutMapping(value = "/params/class")
    public String updateParam(
            @RequestBody ClassParams classParams,
            HttpServletRequest request){
        try{
            return classParamsService.updateParam(classParams, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }


}
