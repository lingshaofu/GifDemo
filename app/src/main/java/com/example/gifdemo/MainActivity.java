package com.example.gifdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gifdemo.gif.GifImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gifImageView = findViewById(R.id.gif_image);
        findViewById(R.id.tv_start_gif).setOnClickListener(v -> {
            gifImageView.setBytes(getBytes("demo.gif"));
            gifImageView.startAnimation();
        });
        findViewById(R.id.tv_stop_gif).setOnClickListener(v -> gifImageView.stopAnimation());
    }

    private byte[] getBytes(String fileName) {
        byte[] arr = null;
        try {
            InputStream is = getAssets().open(fileName);
            arr = new byte[is.available()];
            is.read(arr);

            return arr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}