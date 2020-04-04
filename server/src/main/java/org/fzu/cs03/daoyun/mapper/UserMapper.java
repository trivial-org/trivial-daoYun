package org.fzu.cs03.daoyun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    void createAccount(long roleId,String userName, String password, String email, String createDate, boolean isActive, boolean isDeleted);

    @Select("SELECT * FROM user ORDER BY user_id")
    List<User> getUserList();

    @Select("SELECT * FROM user where user_id= #{id} ")
    List<User> getUser(long id);

    @Select("SELECT count(user_id) FROM user where username = #{userName} or phone = #{userName} limit 1")
    boolean userExist(String userName);

    @Select("SELECT password FROM user where username = #{userName} or phone = #{userName}")
    String getUserPassword(String userName);

    @Select("SELECT username FROM user where email = #{email}")
    List<User> getAccountByEmail(String email);


}
