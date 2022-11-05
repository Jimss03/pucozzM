package com.Destura.notesapp.lessonActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Showvideo1 extends AppCompatActivity {
    private static final int PERMISSION_STORAGE_CODE = 1000;
    DatabaseReference databaseReference;
    RecyclerView recyclerView1;
    FirebaseDatabase database;
    String downloadurl;
    ExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showvideo1);
        recyclerView1 = findViewById(R.id.recyclerview_ShowVideo1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("video1");

    }
    int counter =0;
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(databaseReference,Member.class)
                        .build();

        FirebaseRecyclerAdapter<Member, ViewHolder1> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Member, ViewHolder1>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ViewHolder1 holder, @SuppressLint("RecyclerView") int i, @NonNull Member model) {

                        holder.setExoplayer(getApplication(),model.getName(),model.getVideourl());


                        holder.downloadbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
                                    if (checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                                            PackageManager.PERMISSION_DENIED){
                                        String permission = (Manifest.permission.WRITE_EXTERNAL_STORAGE);

                                        requestPermissions(new String[]{permission}, PERMISSION_STORAGE_CODE);
                                    }else {
                                        downloadurl = getItem(i).getVideourl();
                                        startDownloading(downloadurl);
                                    }
                                }else {
                                    downloadurl = getItem(i).getVideourl();
                                    startDownloading(downloadurl);
                                }
                            }
                        });
                    }



                    @NonNull
                    @Override
                    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.item,parent,false);

                        return new ViewHolder1(view);
                    }
                };
        firebaseRecyclerAdapter.startListening();
        recyclerView1.setAdapter(firebaseRecyclerAdapter);
    }
    private void startDownloading(String downloadurl) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadurl));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI|
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Downlaod");
        request.setDescription("Downloading file.." );
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+System.currentTimeMillis());

        DownloadManager manager= (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

    }
    @Override
    public void onBackPressed() {
        counter++;
        if (counter == 1){
            exoPlayer.getPreviousWindowIndex();
        }





    }
}