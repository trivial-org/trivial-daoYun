package org.fzu.cs03.daoyun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 为什么 直接就绑定上去可以用了?
@RestController
public class HelloCtrl {

//    @Autowired
//    StudentProperties xstudent;

    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;



    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }



    @RequestMapping("/test1")
    public String test() {
        return name+age+"QAQ";
    }

//    @RequestMapping("/test2")
//    public String test2() {
//        return xstudent.getName()+xstudent.getAge();
//    }
}
