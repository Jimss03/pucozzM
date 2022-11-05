package com.Destura.notesapp.lessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.Destura.notesapp.R;

public class lessontopics extends AppCompatActivity {
    private LinearLayout mtolesson1;
    private LinearLayout mtolesson2,mtovideotopics;
  private TextView mtouplaod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessontopics);

        mtolesson1=findViewById(R.id.tolesson1);
        mtolesson2=findViewById(R.id.tolesson2);


        mtolesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessontopics.this, Showvideo.class);
                startActivity(intent);
            }
        });

        mtolesson2=findViewById(R.id.tolesson2);

        mtolesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(lessontopics.this, Showvideo1.class);
                startActivity(intent);
            }
        });




    }
}