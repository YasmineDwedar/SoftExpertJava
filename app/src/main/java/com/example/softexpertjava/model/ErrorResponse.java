package com.example.softexpertjava.model;


public class ErrorResponse
{
    private String status;

    private Erroe erroe;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Erroe getErroe ()
    {
        return erroe;
    }

    public void setErroe (Erroe erroe)
    {
        this.erroe = erroe;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", erroe = "+erroe+"]";
    }
}






