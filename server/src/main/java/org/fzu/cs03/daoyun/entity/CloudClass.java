package org.fzu.cs03.daoyun.entity;

import org.springframework.stereotype.Component;

//@Component
public class CloudClass {
    private String className;
    private String teacherName;
    private String grade;
    private String teachingMateria;
    private String school;
    private String college;
    private String lessonStartDate;
    private String lessonEndDate;
    private String introduction;


    public void setOrgImage(String orgImage) {
        this.orgImage = orgImage;
    }

    private String orgImage;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTeachingMateria(String teachingMateria) {
        this.teachingMateria = teachingMateria;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setLessonStartDate(String lessonStartDate) {
        this.lessonStartDate = lessonStartDate;
    }

    public void setLessonEndDate(String lessonEndDate) {
        this.lessonEndDate = lessonEndDate;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getClassName() {
        return className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getGrade() {
        return grade;
    }

    public String getTeachingMateria() {
        return teachingMateria;
    }

    public String getSchool() {
        return school;
    }

    public String getCollege() {
        return college;
    }

    public String getLessonStartDate() {
        return lessonStartDate;
    }

    public String getLessonEndDate() {
        return lessonEndDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getOrgImage() {
        return orgImage;
    }
}
