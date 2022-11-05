package com.Destura.notesapp.QuizAvtivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.Destura.notesapp.R;

public class QuizActivity extends AppCompatActivity {
    private LinearLayout mtoquiz1;
    private LinearLayout mtojavaquiz1,mtocss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mtoquiz1 = findViewById(R.id.toquiz1);
        mtojavaquiz1 = findViewById(R.id.tojavaquiz1);
        mtocss = findViewById(R.id.css);

        mtoquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, QuestionActivity1.class);
                startActivity(intent);
            }

        });

        mtojavaquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, javaquestion1.class);
                startActivity(intent);
            }
        });
        mtocss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this,cssquiz.class);
                startActivity(intent);
            }
        });
    }
}