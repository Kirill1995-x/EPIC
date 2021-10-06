package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.app.WallpaperManager;

import com.bumptech.glide.Glide;
import com.rusdevapp.epic.databinding.ActivityPhotoBinding;

import java.io.IOException;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPhotoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
            Bundle bundle = getIntent().getExtras();
            String date = bundle.getString("date");
            String name = bundle.getString("image") + ".jpg?api_key=";
            String url = App.PHOTO_URL + date + "/jpg/" + name + App.API_KEY;
            Glide.with(this)
                    .load(url)
                    .placeholder(R.drawable.progress_animation)
                    .error(R.drawable.ic_error)
                    .into(binding.imgPhoto);
            binding.tvPhoto.setText(bundle.getString("image"));
        binding.btnSetPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSetPhoto:
                setPhoto();
                break;
            default:
                break;
        }
    }

    private void setPhoto() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) binding.imgPhoto.getDrawable();
            wallpaperManager.setBitmap(bitmapDrawable.getBitmap());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}