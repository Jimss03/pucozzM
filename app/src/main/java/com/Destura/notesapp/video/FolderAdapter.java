package com.Destura.notesapp.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.MyHolder> {

    private ArrayList<String> folderName;
    private ArrayList<VideoFiles>videoFiles;
    private Context mContext;

    public FolderAdapter(ArrayList<String> folderName, ArrayList<VideoFiles> videoFiles, Context mContext) {
        this.folderName = folderName;
        this.videoFiles = videoFiles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.folder_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
    holder.folder.setText(folderName.get(position));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, VideoFolderActivity3.class);
            intent.putExtra("folderName",folderName.get(position));
            mContext.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {
        return folderName.size();
    }

    static public class MyHolder extends RecyclerView.ViewHolder {
        TextView folder;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            folder =itemView.findViewById(R.id.folderName);
        }
    }
}
