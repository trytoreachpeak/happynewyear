package com.example.a.checkattendance.gsonitem;

public class LoginTeacher {
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

    private int status;
    private Data data;
    public static class Data{
        public int getMsg() {
            return msg;
        }

        public void setMsg(int msg) {
            this.msg = msg;
        }

        public int getTecaherid() {
            return tecaherid;
        }

        public void setTecaherid(int tecaherid) {
            this.tecaherid = tecaherid;
        }

        public String getTecahername() {
            return tecahername;
        }

        public void setTecahername(String tecahername) {
            this.tecahername = tecahername;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        private int msg;
        private int tecaherid;
        private String tecahername;
        private String phone_number;
    }
}
