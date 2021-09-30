package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.rusdevapp.epic.databinding.ActivityPhotoBinding;

public class PhotoActivity extends AppCompatActivity {

    private ActivityPhotoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        String date = bundle.getString("date");
        String name = bundle.getString("image")+".jpg?api_key=";
        String url = App.PHOTO_URL+date+"/jpg/"+name+App.API_KEY;
        Glide.with(this)
             .load(url)
             .placeholder(R.drawable.progress_animation)
             .error(R.drawable.ic_error)
             .into(binding.imgPhoto);
    }
}