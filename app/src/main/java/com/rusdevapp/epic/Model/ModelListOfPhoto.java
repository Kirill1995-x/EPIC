package com.rusdevapp.epic.Model;

public class ModelListOfPhoto
{
    private String date;
    private String image;

    public ModelListOfPhoto(String date, String image) {
        this.date = date;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public String getConvertDate()
    {
        String[] array_date_and_time = date.split(" ");
        String[] date = array_date_and_time[0].split("-");
        return "Дата: "+date[2]+"."+date[1]+"."+date[0]+
               "Время: "+array_date_and_time[1];
    }

    public String getUrlDate()
    {
        String[] array_date_and_time = date.split(" ");
        String[] date = array_date_and_time[0].split("-");
        return date[0]+"/"+date[1]+"/"+date[2];
    }

    public String getImage() {
        return image;
    }
}
