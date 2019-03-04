package com.example.a.checkattendance.gsonitem;

public class Logout {
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
        public int getLogout() {
            return logout;
        }

        public void setLogout(int logout) {
            this.logout = logout;
        }

        private int logout;
    }
}
