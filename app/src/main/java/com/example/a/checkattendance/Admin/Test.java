package com.example.a.checkattendance.Admin;

public class Test {
    private String subject;
    private  String time;

    public Test(String subject, String time){
        this.subject=subject;
        this.time=time;
    }

    public String getSubject(){
        return subject;
    }

    public String getTime(){
        return time;
    }
}