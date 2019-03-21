package com.example.a.checkattendance.gsonitem;

import java.util.List;

public class GetSingleLessonCondtion {
    private int status;

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

        public int getIssignin() {
            return issignin;
        }

        public void setIssignin(int issignin) {
            this.issignin = issignin;
        }

        public String getSignintime() {
            return signintime;
        }

        public void setSignintime(String signintime) {
            this.signintime = signintime;
        }

        public int getIssignout() {
            return issignout;
        }

        public void setIssignout(int issignout) {
            this.issignout = issignout;
        }

        public String getSignouttime() {
            return signouttime;
        }

        public void setSignouttime(String signouttime) {
            this.signouttime = signouttime;
        }

        public int getSseriousnum() {
            return sseriousnum;
        }

        public void setSseriousnum(int sseriousnum) {
            this.sseriousnum = sseriousnum;
        }

        public int getSsleepnum() {
            return ssleepnum;
        }

        public void setSsleepnum(int ssleepnum) {
            this.ssleepnum = ssleepnum;
        }

        public int getSlazynum() {
            return slazynum;
        }

        public void setSlazynum(int slazynum) {
            this.slazynum = slazynum;
        }

        public int getIsserious() {
            return isserious;
        }

        public void setIsserious(int isserious) {
            this.isserious = isserious;
        }

        public int getIssleep() {
            return issleep;
        }

        public void setIssleep(int issleep) {
            this.issleep = issleep;
        }

        public int getIslazy() {
            return islazy;
        }

        public void setIslazy(int islazy) {
            this.islazy = islazy;
        }

        public int getSstate() {
            return sstate;
        }

        public void setSstate(int sstate) {
            this.sstate = sstate;
        }

        private String studentid;
        private String studentname;
        private String studentclass;
        private int issignin;
        private String signintime;
        private int issignout;
        private String signouttime;
        private int sseriousnum;
        private int ssleepnum;
        private int slazynum;
        private int isserious;
        private int issleep;
        private int islazy;
        private int sstate;
        private void merge(GetSingleLessonCondtion.Data data){
            sseriousnum+=data.sseriousnum;
            ssleepnum+=data.ssleepnum;
            slazynum+=data.slazynum;
        }
    }
}
