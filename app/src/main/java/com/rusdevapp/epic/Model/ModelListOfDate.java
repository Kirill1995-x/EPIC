package com.rusdevapp.epic.Model;

public class ModelListOfDate
{
    private String date;

    public ModelListOfDate(String date)
    {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getConvertDate()
    {
        String[] array_date=date.split("-");
        return "Date: "+array_date[2]+"."+array_date[1]+"."+array_date[0];
    }
}
