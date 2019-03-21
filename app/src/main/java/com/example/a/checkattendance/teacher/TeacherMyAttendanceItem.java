package com.example.a.checkattendance.teacher;

public class TeacherMyAttendanceItem {
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
    public TeacherMyAttendanceItem(String dateTime,String week,int attendanceStatus){
        this.dateTime= dateTime;
        this.week=week;
        this.attendanceStatus=attendanceStatus;
    }
    private String dateTime;
    private String week;
    private int attendanceStatus;
}
