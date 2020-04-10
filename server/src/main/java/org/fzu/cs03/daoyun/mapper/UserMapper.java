package org.fzu.cs03.daoyun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fzu.cs03.daoyun.entity.Orgnization;
import org.fzu.cs03.daoyun.entity.Student;
import org.fzu.cs03.daoyun.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

//    @Select("select * from student order by id asc")
//    List<Student> getStudentList();
    @Insert("INSERT INTO user (role_id, username, password, email, creation_date, is_active, is_deleted) VALUES (#{roleId},#{userName}, #{password}, #{email}, #{createDate}, #{isActive}, #{isDeleted} )")
    void createAccount(Long roleId,String userName, String password, String email, String createDate, boolean isActive, boolean isDeleted);

    @Select("SELECT * FROM user ORDER BY user_id")
    List<User> getUserList();

    @Select("SELECT * FROM user WHERE user_id= #{id} ")
    List<User> getUser(Long id);

    @Select("SELECT count(user_id) FROM user WHERE username = #{userName} or phone = #{userName} limit 1")
    boolean userExist(String userName);

    @Select("SELECT password FROM user WHERE username = #{userName} or phone = #{userName}")
    String getUserPassword(String userName);

    @Select("SELECT username FROM user WHERE email = #{email}")
    List<User> getAccountByEmail(String email);

    @Select("SELECT username FROM user WHERE phone = #{phone}")
    String getUserNameByPhone(String phone);

    @Select("SELECT user_id FROM user WHERE username = #{userName} limit 1")
    Long getUserIdByUserName(String userName);

    @Select("SELECT o.org_code, o.org_name, o.extend_json richTextId, o.creation_date, o.creator FROM org AS o INNER JOIN user_org_info AS r ON r.user_id = #{userId} and r.org_id = o.org_id")
    List<Orgnization> getUserJoinedOrgnization(Long userId);

// 带子查询，另一种也可以写成 on + where 哪种快?
//    SELECT org_code, org_name, extend_json richTextId, creation_date, creator FROM (SELECT org_id FROM r_user__org WHERE user_id = #{userId}) LIMIT #{limit} OFFSET #{offset}

    @Select("SELECT o.org_code, o.org_name, o.extend_json richTextId, o.creation_date, o.creator FROM org AS o INNER JOIN user_org_info AS r ON r.user_id = #{userId} and r.org_id = o.org_id LIMIT #{limit} OFFSET #{offset}")
    List<Orgnization> getUserJoinedOrgnizationPage(Long userId, Long limit, Long offset);

    @Select("SELECT o.org_code, o.org_name, o.extend_json richTextId, o.creation_date, o.creator FROM org AS o INNER JOIN user_org_info AS r ON r.user_id = #{userId} and r.org_id = o.org_id WHERE o.creator = #{creator}")
    List<Orgnization> getUserCreatedOrgnization(Long userId, String creator);

    @Select("SELECT o.org_code, o.org_name, o.extend_json richTextId, o.creation_date, o.creator FROM org AS o INNER JOIN user_org_info AS r ON r.user_id = #{userId} and r.org_id = o.org_id WHERE o.creator = #{creator} LIMIT #{limit} OFFSET #{offset}")
    List<Orgnization> getUserCreatedOrgnizationPage(Long userId, String creator, Long limit, Long offset);
}
