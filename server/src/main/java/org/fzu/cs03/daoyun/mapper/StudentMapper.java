package org.fzu.cs03.daoyun.mapper;



import org.fzu.cs03.daoyun.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Select("select * from student order by id asc")
    List<Student> getStudentList();
//    void test();

//    List<Student> getStudentList2();
}