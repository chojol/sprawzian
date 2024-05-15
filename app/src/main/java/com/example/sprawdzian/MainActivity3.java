package com.example.sprawdzian;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    private static ArrayList zdjecie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        zdjecie.add(R.drawable.zdj1);
        zdjecie.add(R.drawable.zdj2);
        zdjecie.add(R.drawable.zdj3);
        zdjecie.add(R.drawable.zdj4);
        zdjecie.add(R.drawable.zdj5);
        zdjecie.add(R.drawable.zdj6);
        zdjecie.add(R.drawable.zdj7);

        Random randomowo = new Random();
        ImageView imageView = findViewById(R.id.zdjecia);
        imageView.setImageResource((Integer) zdjecie.get(randomowo.nextInt(zdjecie.size()-1)));

        Bundle bundle = getIntent().getExtras();
        String info = bundle.getString("info");

        TextView infoView = findViewById(R.id.info);
        infoView.setText(info);
    }
}