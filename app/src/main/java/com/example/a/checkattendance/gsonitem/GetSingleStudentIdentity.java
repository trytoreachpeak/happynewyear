package com.example.a.checkattendance.gsonitem;

public class GetSingleStudentIdentity {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private Data data;
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

        public String getStudentsex() {
            return studentsex;
        }

        public void setStudentsex(String studentsex) {
            this.studentsex = studentsex;
        }

        public int getStudentage() {
            return studentage;
        }

        public void setStudentage(int studentage) {
            this.studentage = studentage;
        }

        public String getStudentclass() {
            return studentclass;
        }

        public void setStudentclass(String studentclass) {
            this.studentclass = studentclass;
        }

        public String getStudentsdept() {
            return studentsdept;
        }

        public void setStudentsdept(String studentsdept) {
            this.studentsdept = studentsdept;
        }

        public String getStudentcollege() {
            return studentcollege;
        }

        public void setStudentcollege(String studentcollege) {
            this.studentcollege = studentcollege;
        }

        public int getStudentgrade() {
            return studentgrade;
        }

        public void setStudentgrade(int studentgrade) {
            this.studentgrade = studentgrade;
        }

        public String getTellphone() {
            return tellphone;
        }

        public void setTellphone(String tellphone) {
            this.tellphone = tellphone;
        }

        private String studentid;
        private String studentname;
        private String studentsex;
        private int studentage;
        private String studentclass;
        private String studentsdept;
        private String studentcollege;
        private int studentgrade;
        private String tellphone;
    }
}
