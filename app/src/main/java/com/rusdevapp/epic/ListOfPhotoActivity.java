package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rusdevapp.epic.Adapter.AdapterListOfDate;
import com.rusdevapp.epic.Adapter.AdapterListOfPhoto;
import com.rusdevapp.epic.Interface.RetrofitService;
import com.rusdevapp.epic.Model.ModelListOfDate;
import com.rusdevapp.epic.Model.ModelListOfPhoto;
import com.rusdevapp.epic.databinding.ActivityListOfPhotoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListOfPhotoActivity extends AppCompatActivity {

    private ActivityListOfPhotoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String date = getIntent().getExtras().getString("date");

        binding.rvListOfPhoto.setLayoutManager(new LinearLayoutManager(this));
        binding.pbListOfPhoto.setVisibility(View.VISIBLE);
        getListOfPhoto(date);
    }

    private void getListOfPhoto(String date) {
        RetrofitService retrofitService = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);
        retrofitService.getListOfPhoto(date, App.API_KEY).enqueue(new Callback<List<ModelListOfPhoto>>() {
            @Override
            public void onResponse(Call<List<ModelListOfPhoto>> call, Response<List<ModelListOfPhoto>> response) {
                binding.pbListOfPhoto.setVisibility(View.GONE);
                if(response.isSuccessful())
                {
                    List<ModelListOfPhoto> list = response.body();
                    binding.rvListOfPhoto.setAdapter(new AdapterListOfPhoto(list, ListOfPhotoActivity.this));
                }
                else
                {
                    String answer=(response.errorBody()!=null)?response.errorBody().toString():"";
                    Toast.makeText(ListOfPhotoActivity.this, answer, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelListOfPhoto>> call, Throwable t) {
                binding.pbListOfPhoto.setVisibility(View.GONE);
                Toast.makeText(ListOfPhotoActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}