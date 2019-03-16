package com.example.a.checkattendance.teacher;

import java.io.Serializable;

public class StudentBean implements Serializable {


    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getGeneralComment() {
        return generalComment;
    }

    public void setGeneralComment(String generalComment) {
        this.generalComment = generalComment;
    }

    public String getRenzhen() {
        return renzhen;
    }

    public void setRenzhen(String renzhen) {
        this.renzhen = renzhen;
    }

    public String getBurenzhen() {
        return burenzhen;
    }

    public void setBurenzhen(String burenzhen) {
        this.burenzhen = burenzhen;
    }

    public String getShuijiao() {
        return shuijiao;
    }

    public void setShuijiao(String shuijiao) {
        this.shuijiao = shuijiao;
    }

    public String getJiaotoujieer() {
        return jiaotoujieer;
    }

    public void setJiaotoujieer(String jiaotoujieer) {
        this.jiaotoujieer = jiaotoujieer;
    }

    private String childName;
    private String childId;
    private String generalComment;
    private String renzhen;
    private String burenzhen;
    private String shuijiao;
    private String jiaotoujieer;


    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    private int attendanceStatus;

}
