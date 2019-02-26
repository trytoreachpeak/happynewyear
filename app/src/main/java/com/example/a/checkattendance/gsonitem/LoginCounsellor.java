package com.example.a.checkattendance.gsonitem;

public class LoginCounsellor {
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
    public static class Data {
        public int getMsg() {
            return msg;
        }

        public void setMsg(int msg) {
            this.msg = msg;
        }

        public int getCounserllorid() {
            return counserllorid;
        }

        public void setCounserllorid(int counserllorid) {
            this.counserllorid = counserllorid;
        }

        public String getCounserllorname() {
            return counserllorname;
        }

        public void setCounserllorname(String counserllorname) {
            this.counserllorname = counserllorname;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        private int msg;
        private int counserllorid;
        private String counserllorname;
        private String phone_number;
    }
}
