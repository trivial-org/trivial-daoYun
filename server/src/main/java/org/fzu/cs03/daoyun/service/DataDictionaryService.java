package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.entity.DataDirectionary;
import org.fzu.cs03.daoyun.exception.DataDictionaryException;
import org.fzu.cs03.daoyun.mapper.DataDictionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
* 本页完全开放安全控制，前端需要自己处理好重复的问题
* */
@Service
public class DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Autowired
    private ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(DataDictionaryService.class);

    public String deleteData(long dictCode, long dataCode ) throws Exception{
        dataDictionaryMapper.deleteData(dictCode,dataCode);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"删除成功");
    }

    public String insertData(DataDirectionary dataDirectionary) throws Exception{

        if (dataDirectionary.getDataCode() == 0 || dataDirectionary.getDictCode() == 0
        || dataDirectionary.getDataName() == null || dataDirectionary.getDictName() == null){
            throw new DataDictionaryException("字典、数据编码不能为0，且Name不能为空！");
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);

        dataDictionaryMapper.insertData(dataDirectionary.getDictCode(),dataDirectionary.getDictName(),
                dataDirectionary.getDataCode(),dataDirectionary.getDataName(),
                dateStr,false);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"插入成功");
    }

    public String getDataDictionaryByDictCode(long dictCode) throws Exception{
        List<DataDirectionary> res = dataDictionaryMapper.getDataDictionaryByDictCode(dictCode);
        if (res.size() == 0){
            throw new DataDictionaryException("该字典下无数据");
        }
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"",res);
    }

    public String getDataDictionaryByDataName(long dictCode, String dataName ) throws Exception{
        List<DataDirectionary> res = dataDictionaryMapper.getDataDictionaryByDataName(dictCode,dataName);
        if (res.size() == 0){
            throw new DataDictionaryException("该字典下未匹配到数据");
        }
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"",res);
    }
}
