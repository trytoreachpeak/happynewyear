package com.example.a.checkattendance.teacher;

public class TeacherTestItem {
    public String getTestName() {
        return testName;
    }

    public String getTestFormat() {
        return testFormat;
    }

    public String getTestReleaseTime() {
        return testReleaseTime;
    }

    public String getTestDeadline() {
        return testDeadline;
    }

    public int getHasCompleted() {
        return hasCompleted;
    }

    public int getNotCompleted() {
        return notCompleted;
    }

    private String testName;
    private String testFormat;
    private String testReleaseTime;
    private String testDeadline;
    private int hasCompleted;
    private int notCompleted;
    public TeacherTestItem(String testName,String testFormat,String testReleaseTime,
            String testDeadline, int hasCompleted,int notCompleted){
        this.testName = testName;
        this.testFormat = testFormat;
        this.testReleaseTime = testReleaseTime;
        this.testDeadline = testDeadline;
        this.hasCompleted = hasCompleted;
        this.notCompleted = notCompleted;
    }

}
