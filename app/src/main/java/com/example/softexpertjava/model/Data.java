package com.example.softexpertjava.model;



public class Data
{
    private String imageUrl;

    private String id;

    private String constractionYear;

    private String brand;

    private String isUsed;

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getConstractionYear ()
    {
        return constractionYear;
    }

    public void setConstractionYear (String constractionYear)
    {
        this.constractionYear = constractionYear;
    }

    public String getBrand ()
    {
        return brand;
    }

    public void setBrand (String brand)
    {
        this.brand = brand;
    }

    public String getIsUsed ()
    {
        return isUsed;
    }

    public void setIsUsed (String isUsed)
    {
        this.isUsed = isUsed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [imageUrl = "+imageUrl+", id = "+id+", constractionYear = "+constractionYear+", brand = "+brand+", isUsed = "+isUsed+"]";
    }
}

