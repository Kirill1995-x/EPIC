package com.rusdevapp.epic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.app.WallpaperManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e,
                                                Object model, Target<Drawable> target,
                                                boolean isFirstResource)
                    {
                        binding.pbPhoto.setVisibility(View.GONE);
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(Drawable resource,
                                                   Object model,
                                                   Target<Drawable> target,
                                                   DataSource dataSource,
                                                   boolean isFirstResource)
                    {
                        binding.pbPhoto.setVisibility(View.GONE);
                        binding.tvPhoto.setVisibility(View.VISIBLE);
                        binding.btnSetPhoto.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .error(R.drawable.nophoto)
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