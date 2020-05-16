package org.fzu.cs03.daoyun;

import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.fzu.cs03.daoyun.mapper.ActivityMapper;
import org.fzu.cs03.daoyun.mapper.PublishedActivityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DaoyunApplicationTests {

    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    PublishedActivityMapper publishedActivityMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void func(){

        PublishedActivity publishedActivity = new PublishedActivity();
        publishedActivity.setActivityTypeId(10L);
        publishedActivity.setOrgId(10L);
        publishedActivity.setIsActive(Boolean.TRUE);
        int result = publishedActivityMapper.insert(publishedActivity);

//        publishedActivityMapper.deleteById(1L);
//
//        List<PublishedActivity> pas = publishedActivityMapper.selectList(null);
//        List<AttendActivity> aas = activityMapper.selectList(null);

//        pas.forEach(System.out::println);
//        aas.forEach(System.out::println);
//        System.out.println(result);

    }

}
