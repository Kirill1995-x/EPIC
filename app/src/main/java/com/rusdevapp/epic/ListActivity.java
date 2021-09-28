package com.rusdevapp.epic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rusdevapp.epic.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}