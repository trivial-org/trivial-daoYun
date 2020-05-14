package org.fzu.cs03.daoyun.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.fzu.cs03.daoyun.service.SignInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/12 22:24
 */
//@Slf4j
@Component // 一定不要忘记把处理器加到IOC容器中！
public class MyMetaObjectHandler implements MetaObjectHandler {
    private final Logger logger = LoggerFactory.getLogger(SignInService.class);

    @Override
    public void insertFill(MetaObject metaObject) {
//        logger.info("start insert fill.....");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("creationDate",new Date(),metaObject);
        this.setFieldValByName("lastModificationDate",new Date(),metaObject);
        this.setFieldValByName("isDeleted",Boolean.FALSE,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        logger.info("start update fill.....");
        this.setFieldValByName("lastModificationDate",new Date(),metaObject);
    }
}
