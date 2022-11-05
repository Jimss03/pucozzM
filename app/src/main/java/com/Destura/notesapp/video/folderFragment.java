package com.Destura.notesapp.video;

import static com.Destura.notesapp.video.Videoplaylistplayer.folderList;
import static com.Destura.notesapp.video.Videoplaylistplayer.videoFiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;


public class folderFragment extends Fragment {

    FolderAdapter folderAdapter;
    RecyclerView recyclerView;
    public folderFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_folder, container, false);
        recyclerView = view.findViewById(R.id.folderRV);
        if (folderList != null && folderList.size()>0 && videoFiles != null)
        {
            folderAdapter = new FolderAdapter(folderList,videoFiles, getContext());
            recyclerView.setAdapter(folderAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    RecyclerView.VERTICAL,false));
        }
        return view;
    }
}