package com.rusdevapp.epic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rusdevapp.epic.Adapter.AdapterListOfDate;
import com.rusdevapp.epic.Interface.RetrofitService;
import com.rusdevapp.epic.Model.ModelListOfDate;
import com.rusdevapp.epic.databinding.ActivityListOfDateBinding;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListOfDateActivity extends AppCompatActivity {

    private ActivityListOfDateBinding binding;
    private ArrayList<ModelListOfDate> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            binding.rvListOfDate.setLayoutManager(new LinearLayoutManager(this));
        else
            binding.rvListOfDate.setLayoutManager(new GridLayoutManager(this,2));
        //---
        if(savedInstanceState==null) {
            binding.pbListOfDate.setVisibility(View.VISIBLE);
            getListOfDate();
        }
        else
        {
            arrayList = savedInstanceState.getParcelableArrayList("list_of_dates");
            binding.rvListOfDate.setAdapter(new AdapterListOfDate(arrayList,
                    ListOfDateActivity.this));
        }
    }

    private void getListOfDate()
    {
        RetrofitService retrofitService = new Retrofit.Builder()
                                .baseUrl(App.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(RetrofitService.class);
        retrofitService.getListOfDate(App.API_KEY)
                       .enqueue(new Callback<ArrayList<ModelListOfDate>>()
        {
            @Override
            public void onResponse(Call<ArrayList<ModelListOfDate>> call,
                                   Response<ArrayList<ModelListOfDate>> response)
            {
                binding.pbListOfDate.setVisibility(View.GONE);
                if(response.isSuccessful())
                {
                   arrayList = response.body();
                   binding.rvListOfDate.setAdapter(new AdapterListOfDate(arrayList,
                                                  ListOfDateActivity.this));
                }
                else
                {
                   String answer=(response.errorBody()!=null)?response.errorBody().toString():"";
                   Toast.makeText(ListOfDateActivity.this, answer, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ModelListOfDate>> call, Throwable t) {
                binding.pbListOfDate.setVisibility(View.GONE);
                Toast.makeText(ListOfDateActivity.this, t.getMessage(), Toast.LENGTH_LONG)
                     .show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list_of_dates", arrayList);
    }
}