package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rusdevapp.epic.Adapter.EPICAdapter;
import com.rusdevapp.epic.Interface.RetrofitService;
import com.rusdevapp.epic.Model.ModelNASA;
import com.rusdevapp.epic.databinding.ActivityListBinding;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private final String BASE_URL="https://api.nasa.gov/EPIC/api/natural/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvListOfEPIC.setLayoutManager(new LinearLayoutManager(this));
        binding.progressBar.setVisibility(View.VISIBLE);
        getEPIC();
    }

    private void getEPIC()
    {
        RetrofitService retrofitService = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(RetrofitService.class);
        retrofitService.getEPIC().enqueue(new Callback<List<ModelNASA>>() {
            @Override
            public void onResponse(Call<List<ModelNASA>> call, Response<List<ModelNASA>> response) {
                binding.progressBar.setVisibility(View.GONE);
                if(response.isSuccessful())
                {
                   List<ModelNASA> list = response.body();
                   binding.rvListOfEPIC.setAdapter(new EPICAdapter(list, ListActivity.this));
                }
                else
                {
                   String answer=(response.errorBody()!=null)?response.errorBody().toString():"";
                   Toast.makeText(ListActivity.this, answer, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelNASA>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(ListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}