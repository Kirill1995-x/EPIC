package com.rusdevapp.epic.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelListOfDate implements Parcelable
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
        return "Дата: "+array_date[2]+"."+array_date[1]+"."+array_date[0];
    }

    protected ModelListOfDate(Parcel in) {
        date = in.readString();
    }

    public static final Creator<ModelListOfDate> CREATOR = new Creator<ModelListOfDate>() {
        @Override
        public ModelListOfDate createFromParcel(Parcel in) {
            return new ModelListOfDate(in);
        }

        @Override
        public ModelListOfDate[] newArray(int size) {
            return new ModelListOfDate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
    }
}
