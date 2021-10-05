package com.rusdevapp.epic.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelListOfPhoto implements Parcelable
{
    private String date;
    private String image;

    public ModelListOfPhoto(String date, String image) {
        this.date = date;
        this.image = image;
    }

    protected ModelListOfPhoto(Parcel in) {
        date = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelListOfPhoto> CREATOR = new Creator<ModelListOfPhoto>() {
        @Override
        public ModelListOfPhoto createFromParcel(Parcel in) {
            return new ModelListOfPhoto(in);
        }

        @Override
        public ModelListOfPhoto[] newArray(int size) {
            return new ModelListOfPhoto[size];
        }
    };

    public String getDate() {
        return date;
    }

    public String getTime()
    {
        String[] array_time = date.split(" ");
        return "Время: "+array_time[1];
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
