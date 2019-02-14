package com.example.a.checkattendance;

public class Ziliao {
    private String name;
    private  int imageId;

    public Ziliao(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
