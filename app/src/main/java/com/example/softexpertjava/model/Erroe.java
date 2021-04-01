package com.example.softexpertjava.model;


public class Erroe {
    private String msg;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+"]";
    }
}
