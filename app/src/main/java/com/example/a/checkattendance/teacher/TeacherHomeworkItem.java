package com.example.a.checkattendance.teacher;

public class TeacherHomeworkItem {
    public String getHomeworkName() {
        return homeworkName;
    }

    public String getFormat() {
        return format;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getHasCommitted() {
        return hasCommitted;
    }

    public int getNotCommitted() {
        return notCommitted;
    }

    public int getHasCheck() {
        return hasCheck;
    }

    public int getNoCheck() {
        return noCheck;
    }

    private String homeworkName;
    private String format;
    private String deadline;
    private int hasCommitted;
    private int notCommitted;
    private int hasCheck;
    private int noCheck;
    public TeacherHomeworkItem(String homeworkName,String format,
                               String deadline,int hasCommitted,
                               int notCommitted,int hasCheck,int noCheck){
        this.homeworkName=homeworkName;
        this.format = format;
        this.deadline = deadline;
        this.hasCommitted = hasCommitted;
        this.notCommitted = notCommitted;
        this.hasCheck = hasCheck;
        this.noCheck = noCheck;
    }
}
