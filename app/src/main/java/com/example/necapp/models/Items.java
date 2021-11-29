package com.example.necapp.models;

public class Items {
    private String name;
    private String img;
    private String badgeColor;
    private String section;

    public Items(String name, String img,String badgeColor, String section)
    {
        this.name = name;
        this.img = img;
        this.badgeColor = badgeColor;
        this.section = section;
    }

    public String getName()
    {
        return this.name;
    }

    public String getImg()
    {
        return this.img;
    }

    public String getBadgeColor() { return this.badgeColor; }

    public String getSection() { return this.section; }
}
