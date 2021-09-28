package com.rusdevapp.epic.Model;

public class ModelNASA
{
    private String date;
    private String name;

    ModelNASA(String date, String name)
    {
        this.date = date;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getConvertDate()
    {
        String[] array_date=date.split("-");
        return array_date[2]+"."+array_date[1]+"."+array_date[0];
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
