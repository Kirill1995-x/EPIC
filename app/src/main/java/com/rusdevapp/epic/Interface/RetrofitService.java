package com.rusdevapp.epic.Interface;

import com.rusdevapp.epic.Model.ModelListOfDate;
import com.rusdevapp.epic.Model.ModelListOfPhoto;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("all?")
    Call<ArrayList<ModelListOfDate>> getListOfDate(@Query("api_key") String API);

    @GET("date/{date}?")
    Call<ArrayList<ModelListOfPhoto>> getListOfPhoto(@Path("date") String date, @Query("api_key") String API);

}
