package com.rusdevapp.epic.Model;

public class ModelNASA
{
    private String date;
    private String image;

    ModelNASA(String date, String image)
    {
        this.date = date;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public String getConvertDate()
    {
        String[] array_date_and_time = date.split(" ");
        String[] array_date=array_date_and_time[0].split("-");
        return "Date: "+array_date[2]+"."+array_date[1]+"."+array_date[0]+
                " Time: "+array_date_and_time[1];
    }

    public String getDateForURL()
    {
        String[] array_date_and_time = date.split(" ");
        String[] array_date = array_date_and_time[0].split("-");
        return array_date[0]+"/"+array_date[1]+"/"+array_date[2]+"/";
    }

    public String getImage() {
        return image;
    }

}
