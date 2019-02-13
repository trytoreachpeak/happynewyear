package com.example.a.checkattendance;

public class TeacherMessageItem {
    private String messageCategory;
    private int messageLeftImageId;
    private String messageClass;
    private String messageName;
    public TeacherMessageItem(String messageCategory,int messageLeftImageId,
                              String messageClass,String messageName){
        this.messageCategory=messageCategory;
        this.messageLeftImageId=messageLeftImageId;
        this.messageClass=messageClass;
        this.messageName=messageName;
    }
    public String getMessageCategory(){
        return messageCategory;
    }
    public String getMessageClass(){
        return messageClass;
    }
    public String getMessageName(){
        return messageName;
    }
    public int getMessageLeftImageId(){
        return messageLeftImageId;
    }
}
