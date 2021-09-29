package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.rusdevapp.epic.databinding.ActivityMainBinding;

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
        String date = bundle.getString("date");
        String name=bundle.getString("image")+".jpg?api_key=";
        String url = URI+date+"/jpg/"+name+API_KEY;
        Glide.with(this)
             .load(url)
             .placeholder(R.drawable.progress_animation)
             .error(R.drawable.ic_error)
             .into(binding.imgPhoto);
    }
}