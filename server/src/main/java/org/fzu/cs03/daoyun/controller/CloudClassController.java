package org.fzu.cs03.daoyun.controller;

import org.apache.ibatis.annotations.Delete;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.CloudClass;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.fzu.cs03.daoyun.service.CloudClassService;
import org.fzu.cs03.daoyun.service.DataDictionaryService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class CloudClassController {

    @Autowired
    CloudClassService cloudClassService;

    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(CloudClassController.class);

    @PostMapping(value = "/cloudClass")
    public String createCloudClass(@RequestBody CloudClass cloudClass,
                             HttpServletRequest request){
        try{
            return cloudClassService.createCloudClass(cloudClass, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/cloudClass")
    public String getCloudClassInfo(
            @RequestParam(value = "orgCode" ,required = true) Long orgCode,
            HttpServletRequest request){
        try{
            return cloudClassService.getOrgInfoByOrgCode(orgCode, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PutMapping(value = "/cloudClass")
    public String updateCloudClassInfo(
            @RequestParam(value = "orgCode" ,required = true) Long orgCode,
            @RequestBody CloudClass cloudClass,
            HttpServletRequest request){

        try{
            return cloudClassService.updateClassInfoByOrgCode(orgCode,cloudClass, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @DeleteMapping(value = "/cloudClass")
    public String deleteCloudClass(
            @RequestParam(value = "orgCode" ,required = true) Long orgCode,
            HttpServletRequest request){
        try{
            return cloudClassService.deleteCloudClassAndMembers(orgCode, request);
        } catch (Exception e) {
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

}
