package com.example.a.checkattendance.gsonitem;

import java.util.List;

public class GetTeacherAttendance {
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
        public String getCoursename() {
            return coursename;
        }

        public void setCoursename(String coursename) {
            this.coursename = coursename;
        }

        public int getCoursenum() {
            return coursenum;
        }

        public void setCoursenum(int coursenum) {
            this.coursenum = coursenum;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getIssignin() {
            return issignin;
        }

        public void setIssignin(int issignin) {
            this.issignin = issignin;
        }

        public int getIssignout() {
            return issignout;
        }

        public void setIssignout(int issignout) {
            this.issignout = issignout;
        }

        public String getSignintime() {
            return signintime;
        }

        public void setSignintime(String signintime) {
            this.signintime = signintime;
        }

        public String getSignouttime() {
            return signouttime;
        }

        public void setSignouttime(String signouttime) {
            this.signouttime = signouttime;
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

        private String coursename;
        private int coursenum;
        private String date;
        private int issignin;
        private int issignout;
        private String signintime;
        private String signouttime;
        private String teacherid;
        private String teachername;

        @Override
        public String toString() {
            return signintime;
        }
    }
}
