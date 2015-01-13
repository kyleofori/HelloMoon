package com.detroitlabs.kyleofori.hellomoon;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by kyleofori on 1/12/15.
 */
public class HelloMoonFragment extends Fragment {

    private AudioPlayer mPlayer = new AudioPlayer();
    private VideoView vView;
//    private MediaController mediaController = new MediaController(getActivity());
    private Button mPlayButton;
    private Button mStopButton;
    private Uri resourceUri = Uri.parse("android.resource://" + "com.detroitlabs.kyleofori" +
            ".hellomoon/raw/apollo_17_strollin");

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setEnabled(false);
        vView = (VideoView) v.findViewById(R.id.video_view_apollo);
        vView.setVideoURI(resourceUri);
        vView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mPlayButton.setEnabled(true);
            }
        });
        vView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.i("HelloMoonFragment", "There was an error.");
                return false;
            }
        });
//        vView.setMediaController(mediaController);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mPlayer.isPlaying()) {
                    mPlayer.play(getActivity());
                    vView.start();
                } else {
                    mPlayer.pause();
                    vView.pause();
                }

            }
        });

        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.stop();
                vView.stopPlayback();
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        vView.stopPlayback();
    }
}
