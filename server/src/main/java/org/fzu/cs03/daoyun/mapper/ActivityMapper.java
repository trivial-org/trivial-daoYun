package org.fzu.cs03.daoyun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.Activity_UserState;
import org.fzu.cs03.daoyun.entity.AttendActivity;
import org.fzu.cs03.daoyun.entity.Orgnization;
import org.fzu.cs03.daoyun.entity.PublishedActivity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/5/12 20:06
 */

@Repository
public interface ActivityMapper extends BaseMapper<AttendActivity> {

    @Select("select pa2.id activityId, pa2.activity_type_id activityTypeId, pa2.activity_name activityName, " +
            "pa2.begin_date beginDate, pa2.end_date endDate, pa2.is_active isActive, pa2.activity_param answer, " +
            "pia.user_id userId, pia.creation_date creationDate " +
            "from (SELECT pa.id , pa.activity_param, pa.activity_name , pa.activity_type_id , pa.begin_date, pa.end_date, pa.is_active " +
            "from published_activity as pa  where pa.org_id = #{orgId} ) as pa2 LEFT JOIN \n" +
            "participate_in_activity as pia on pia.activity_id = pa2.id  and pia.user_id = #{userId} \n" +
            "order by creationDate DESC LIMIT #{size} OFFSET #{offset}")
    List<Activity_UserState> getUserActivitiesState(Long userId, Long orgId, Long size, Long offset);

    List<Activity_UserState> getClassActivitiesState(Long activityId, Long orgId);
}
