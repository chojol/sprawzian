package com.example.sprawdzian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<String> Ksiazki = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Ksiazki.add("Tytul: tytul, Autor: autor");

        ListView listView = findViewById(R.id.ksiazki);
        ArrayAdapter adaptiro = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,Ksiazki);
        listView.setAdapter(adaptiro);

        EditText editText = findViewById(R.id.tytul);
        EditText editText1 = findViewById(R.id.autor);

        Button button = findViewById(R.id.dodaj);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tytul = editText.getText().toString();
                String autor = editText1.getText().toString();

                Ksiazki.add(String.format("tytul: %s, autor: %s", tytul, autor));
                listView.invalidateViews();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), MainActivity3.class);
                intent.putExtra("info", ((TextView) view).getText().toString());
                startActivity(intent);
            }
        });
    }
}