package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.mapper.StudentMapper;
import org.fzu.cs03.daoyun.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {

        try {
            return studentMapper.getStudentList();
        }
        catch (Exception e) {
            throw e;
        }
    }

}
