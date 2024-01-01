package com.example.hutchsoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.widget.Button;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button randBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randBtn = findViewById(R.id.randBtn);
    }

    @Override
    protected void onResume() {
        super.onResume();

        randBtn.setOnClickListener(v -> {
            Field[] f = getRawList();

            Random rand = new Random();

            int val = rand.nextInt(f.length - 1);
            try {
                MediaPlayer mp = MediaPlayer.create(this, f[val].getInt(f[val]));
                mp.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private Field[] getRawList() {
        return R.raw.class.getFields();
    }
}