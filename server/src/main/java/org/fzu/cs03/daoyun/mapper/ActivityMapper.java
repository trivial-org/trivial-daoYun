package org.fzu.cs03.daoyun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.*;
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


    @Select(" select r.user_id userId , u.role_id roleId ,  u.username username, u.student_id studentId, o.id orgId , o.org_code orgCode  ,'yes' as isPar from user as u , org as o,user_org_info as r " +
            "where u.id = r.user_id and o.id = r.org_id and o.id in (select org_id from published_activity where id = #{activityId} ) and u.id in (select u.id from participate_in_activity as p,user as u where p.activity_id=#{activityId} and u.id = p.user_id)" +
            " union" +
            "  select r.user_id userId , u.role_id roleId ,  u.username username, u.student_id studentId, o.id orgId , o.org_code orgCode ,'no' as isPar from user as u , org as o,user_org_info as r where u.id = r.user_id and o.id = r.org_id and o.id in (select org_id from published_activity " +
            "where id = #{activityId}) and u.id not in (select u.id from participate_in_activity as p,user as u where p.activity_id=#{activityId} and u.id = p.user_id)")
    List<ActivityParticipateState>getActivitiesOrgParStateByActivityId(Long activityId);

    @Select("SELECT user_id userId,username username ,student_id studentId ,sum(score) sumScore FROM participate_in_activity as pi ,user as u\n" +
            " WHERE u.id = pi.user_id AND  pi.activity_id IN (SELECT id  FROM  published_activity as pa \n" +
            " WHERE pa.org_id =(SELECT id FROM org WHERE org_code = #{orgCode})  ) GROUP BY user_id")
    List<OrgMemberScore> getOrgMemberScoreByOrgCode(Long orgCode);


}
