package com.example.a.checkattendance.Admin;

import android.graphics.Bitmap;

public class ChildInfo
{
    String childName;
    Bitmap childPic;

    public ChildInfo(String childName, Bitmap childPic)
    {
        super();
        this.childName = childName;
        this.childPic = childPic;
    }

    public String getChildName()
    {
        return childName;
    }

    public void setChildName(String childName)
    {
        this.childName = childName;
    }

    public Bitmap getChildPic()
    {
        return childPic;
    }

    public void setChildPic(Bitmap childPic)
    {
        this.childPic = childPic;
    }

}
