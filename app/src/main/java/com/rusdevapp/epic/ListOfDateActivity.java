package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOfDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvListOfDate.setLayoutManager(new LinearLayoutManager(this));
        binding.pbListOfDate.setVisibility(View.VISIBLE);
        getListOfDate();
    }

    private void getListOfDate()
    {
        RetrofitService retrofitService = new Retrofit.Builder()
                                .baseUrl(App.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(RetrofitService.class);
        retrofitService.getListOfDate(App.API_KEY).enqueue(new Callback<List<ModelListOfDate>>() {
            @Override
            public void onResponse(Call<List<ModelListOfDate>> call, Response<List<ModelListOfDate>> response) {
                binding.pbListOfDate.setVisibility(View.GONE);
                if(response.isSuccessful())
                {
                   List<ModelListOfDate> list = response.body();
                   binding.rvListOfDate.setAdapter(new AdapterListOfDate(list, ListOfDateActivity.this));
                }
                else
                {
                   String answer=(response.errorBody()!=null)?response.errorBody().toString():"";
                   Toast.makeText(ListOfDateActivity.this, answer, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelListOfDate>> call, Throwable t) {
                binding.pbListOfDate.setVisibility(View.GONE);
                Toast.makeText(ListOfDateActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}