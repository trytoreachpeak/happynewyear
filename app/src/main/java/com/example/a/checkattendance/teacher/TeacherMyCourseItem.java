package com.example.a.checkattendance.teacher;

public class TeacherMyCourseItem {
    public String getWeek() {
        return week;
    }

    public String getSite() {
        return site;
    }

    public String getTime() {
        return time;
    }

    private String week;
    private String site;
    private String time;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    public String getCourseTotalNum() {
        return courseTotalNum;
    }

    public void setCourseTotalNum(String courseTotalNum) {
        this.courseTotalNum = courseTotalNum;
    }

    private String courseName;
    private String courseClass;
    private String courseTotalNum;
    public TeacherMyCourseItem(String week,String site,String time,
                               String courseName,String courseClass,String courseTotalNum){
        this.week=week;
        this.site=site;
        this.time=time;
        this.courseName=courseName;
        this.courseClass=courseClass;
        this.courseTotalNum=courseTotalNum;
    }
}
