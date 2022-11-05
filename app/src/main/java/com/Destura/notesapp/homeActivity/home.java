package com.Destura.notesapp.homeActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.Destura.notesapp.MusicAct.MainActivity;
import com.Destura.notesapp.QuizAvtivity.QuizActivity;
import com.Destura.notesapp.R;
import com.Destura.notesapp.lessonActivity.lessontopics;
import com.Destura.notesapp.loginregOut.loginActivity;
import com.Destura.notesapp.noteActivity.notePage;
import com.Destura.notesapp.notiblock.Status_Page;
import com.Destura.notesapp.video.Videoplaylistplayer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class home extends AppCompatActivity {

    private LinearLayout mtomusic, mtonote, mtolessontopics, mtoquiz,mtovideo;
    private ImageView mplay_Song, mlogout;
    private MediaPlayer mediaPlayer;
    Button tonoti;
    DatabaseReference databaseReference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mplay_Song = findViewById(R.id.play_Song);
        mtomusic = findViewById(R.id.tomusic);
        mlogout = findViewById(R.id.logout);
        mtonote = findViewById(R.id.tonote);
        mtovideo = findViewById(R.id.tovideo);
        mtolessontopics = findViewById(R.id.tolessontopics);
        mtoquiz = findViewById(R.id.toquiz);
        tonoti = findViewById(R.id.tonotiblocker);
        mediaPlayer = new MediaPlayer();
        database = FirebaseDatabase.getInstance();



        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(home.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tonoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, Status_Page.class);
                startActivity(intent);
            }
        });



        mtovideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Videoplaylistplayer.class);
                startActivity(intent);
            }
        });




mtomusic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(home.this, MainActivity.class);
        startActivity(intent);
    }
});

        mtonote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, notePage.class);
                startActivity(intent);
            }
        });
        mtolessontopics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, lessontopics.class);
                startActivity(intent);
            }
        });

        mtoquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, QuizActivity.class);
                startActivity(intent);
            }
        });




        //lofi music

        mplay_Song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });

        prepareMediaPlayer();


    }

    private void prepareMediaPlayer() {
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/phucosapp.appspot.com/o/fi-hip-hop-beats.mp3?alt=media&token=fa040c24-3aa4-4dc2-817b-f74fda57df11");
            mediaPlayer.prepare();
        } catch (Exception exception) {

        }
    }


}