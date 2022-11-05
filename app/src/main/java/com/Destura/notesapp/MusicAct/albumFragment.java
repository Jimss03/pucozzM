package com.Destura.notesapp.MusicAct;


import static com.Destura.notesapp.MusicAct.MainActivity.albums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link albumFragment#} factory method to
 * create an instance of this fragment.
 */
public class albumFragment extends Fragment {

    RecyclerView recyclerView;
    AlbumAdapter albumAdapter;
    public albumFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        if (!(albums.size() <1))
        {
            albumAdapter = new AlbumAdapter(getContext(),albums);
            recyclerView.setAdapter(albumAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        return view;
    }
}