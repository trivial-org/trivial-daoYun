package org.fzu.cs03.daoyun.controller;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.fzu.cs03.daoyun.service.DataDictionaryService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class DataDictionaryController {

    @Autowired
    DataDictionaryService dataDictionaryService;

    @Autowired
    ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(DataDictionaryController.class);

    @DeleteMapping(value = "/dataDictionary")
    public String deleteData(@RequestParam(value = "dictCode" ,required = true) long dictCode,
                             @RequestParam(value = "dataCode" ,required = true) long dataCode,
                             HttpServletRequest request){
        try{
            return dataDictionaryService.deleteData(dictCode,dataCode);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @PostMapping(value = "/dataDictionary")
    public String insertData(@RequestBody DataDirectionary dataDirectionary, HttpServletRequest request){
        try{
            return dataDictionaryService.insertData(dataDirectionary);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }

    @GetMapping(value = "/dataDictionary")
    public String getData(@RequestParam(value = "dictCode" ,required = true) long dictCode,
                          @RequestParam(value = "dataName" ,required = false) String dataName,
                          HttpServletRequest request){
        try{
            if (dataName == null) return dataDictionaryService.getDataDictionaryByDictCode(dictCode);
            else return dataDictionaryService.getDataDictionaryByDataName(dictCode,dataName);
        } catch (Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }



}
