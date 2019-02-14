package com.example.a.checkattendance.student;

public class Zuoye {
    private String name;
    private  int imageId;

    public Zuoye(String name, int imageId){
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
