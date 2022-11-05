package com.Destura.notesapp.lessonActivity;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;


public class ViewHolder extends RecyclerView.ViewHolder {

    SimpleExoPlayer exoPlayer;
    ImageView downloadbtn;
    PlayerView playerView;






    public ViewHolder(@NonNull View itemView) {
        super(itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v,getAdapterPosition());
            }
        });



    }
    public void setExoplayer(Application application ,String name,String Videourl,String iduser){

        TextView textView = itemView.findViewById(R.id.tv_item_name);
        playerView = itemView.findViewById(R.id.exoplplayer_item);
        downloadbtn = itemView.findViewById(R.id.download_button_viewholder);

        textView.setText(name);

        try {
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(application).build();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = (SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(application);
            Uri video = Uri.parse(Videourl);

            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("video");

            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory,null,null);



            playerView.setPlayer(exoPlayer);


            exoPlayer.prepare(mediaSource);

            exoPlayer.setPlayWhenReady(false);
        }catch (Exception e){
            Log.e("ViewHolder","exoplayer Error"+e.toString());
        }

    }
    private ViewHolder.Clicklistener mClickListener;
    public interface Clicklistener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    public void  setOnclicklistener(ViewHolder.Clicklistener clicklistener){
        mClickListener = clicklistener;
    }

}



