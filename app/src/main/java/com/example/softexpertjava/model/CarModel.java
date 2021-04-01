package com.example.softexpertjava.model;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CarModel
{
    public CarModel() {
    }

    private ArrayList<Data> data;

    private String status;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}