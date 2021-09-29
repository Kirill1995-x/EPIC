package com.rusdevapp.epic.Interface;

import com.rusdevapp.epic.Model.ModelNASA;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("natural?api_key=LwmzpbFYfehtgkUaH8qsLK3Qeai6qZtqtDq2Pvht")
    public Call<List<ModelNASA>> getEPIC();
}
