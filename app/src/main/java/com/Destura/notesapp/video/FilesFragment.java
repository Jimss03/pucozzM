package com.Destura.notesapp.video;

import static com.Destura.notesapp.video.Videoplaylistplayer.videoFiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;


public class FilesFragment extends Fragment {

RecyclerView recyclerView;
View view;
VideoAdapter videoAdapter;
    public FilesFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_files,container,false);
        recyclerView= view.findViewById(R.id.filesRV);
        if (videoFiles!= null && videoFiles.size()>0)
        {
            videoAdapter = new VideoAdapter(getContext(),videoFiles);
            recyclerView.setAdapter(videoAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    RecyclerView.VERTICAL,false));
        }
        return view;
    }
}