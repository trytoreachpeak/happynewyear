package com.example.a.checkattendance.Admin;
public class Teacher {
    private String name;
    private  String attend;
    private  int imageId;

    public Teacher(String name, String attend,int imageId){
        this.name=name;
        this.attend=attend;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public String getAttend(){
        return attend;
    }
}