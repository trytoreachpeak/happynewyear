package com.example.a.checkattendance.gsonitem;

import java.util.List;

public class GetLessonConditionUntilNow {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    private int status;
    private List<Data> data;
    public static class Data{
        public String getStudentid() {
            return studentid;
        }

        public void setStudentid(String studentid) {
            this.studentid = studentid;
        }

        public String getStudentname() {
            return studentname;
        }

        public void setStudentname(String studentname) {
            this.studentname = studentname;
        }

        public String getStudentclass() {
            return studentclass;
        }

        public void setStudentclass(String studentclass) {
            this.studentclass = studentclass;
        }

        public int getSignnum() {
            return signnum;
        }

        public void setSignnum(int signnum) {
            this.signnum = signnum;
        }

        public int getSigninnum() {
            return signinnum;
        }

        public void setSigninnum(int signinnum) {
            this.signinnum = signinnum;
        }

        public int getSignoutnum() {
            return signoutnum;
        }

        public void setSignoutnum(int signoutnum) {
            this.signoutnum = signoutnum;
        }

        public int getSeriousnum() {
            return seriousnum;
        }

        public void setSeriousnum(int seriousnum) {
            this.seriousnum = seriousnum;
        }

        public int getSleepnum() {
            return sleepnum;
        }

        public void setSleepnum(int sleepnum) {
            this.sleepnum = sleepnum;
        }

        public int getLazynum() {
            return lazynum;
        }

        public void setLazynum(int lazynum) {
            this.lazynum = lazynum;
        }

        private String studentid;
        private String studentname;
        private String studentclass;
        private int signnum;
        private int signinnum;
        private int signoutnum;
        private int seriousnum;
        private int sleepnum;
        private int lazynum;
    }
}
