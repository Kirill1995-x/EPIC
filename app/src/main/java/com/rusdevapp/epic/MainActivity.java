package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rusdevapp.epic.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String URI="https://api.nasa.gov/EPIC/archive/natural/";
    private final String API_KEY="LwmzpbFYfehtgkUaH8qsLK3Qeai6qZtqtDq2Pvht";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        String[]date = bundle.getString("date").split("-");
        String convert_date=date[2]+"/"+date[1]+"/"+date[0]+"/jpg/";
        String name=bundle.getString("name")+".jpg?api_key=";
        String url = URI+convert_date+name+API_KEY;
        Picasso.get().load(url).into(binding.imgPhoto);
    }
}