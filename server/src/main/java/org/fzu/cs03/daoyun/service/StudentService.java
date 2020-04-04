package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getStudentList();
}
