package com.example.a.checkattendance;

public class Class {
    private String name;
    private  int imageId;

    public Class(String name, int imageId){
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
