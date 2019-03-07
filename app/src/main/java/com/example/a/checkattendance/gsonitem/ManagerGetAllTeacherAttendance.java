package com.example.a.checkattendance.gsonitem;

import java.util.List;

public class ManagerGetAllTeacherAttendance {
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
        public String getCourseid() {
            return courseid;
        }

        public void setCourseid(String courseid) {
            this.courseid = courseid;
        }

        public String getCoursename() {
            return coursename;
        }

        public void setCoursename(String coursename) {
            this.coursename = coursename;
        }

        public String getTeacherid() {
            return teacherid;
        }

        public void setTeacherid(String teacherid) {
            this.teacherid = teacherid;
        }

        public String getTeachername() {
            return teachername;
        }

        public void setTeachername(String teachername) {
            this.teachername = teachername;
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

        private String courseid;
        private String coursename;
        private String teacherid;
        private String teachername;
        private int signnum;
        private int signinnum;
        private int signoutnum;
    }
}
