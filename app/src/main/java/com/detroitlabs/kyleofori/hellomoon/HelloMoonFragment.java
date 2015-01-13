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
import android.widget.VideoView;

/**
 * Created by kyleofori on 1/12/15.
 */
public class HelloMoonFragment extends Fragment implements View.OnClickListener {

    private AudioPlayer mPlayer = new AudioPlayer();
    private VideoView vView;
//    private MediaController mediaController = new MediaController(getActivity());
    private Button mPlayVideoButton;
    private Button mStopVideoButton;
    private Button mPlayAudioButton;
    private Button mStopAudioButton;
    private Uri resourceUri = Uri.parse("android.resource://" + "com.detroitlabs.kyleofori" +
            ".hellomoon/raw/apollo_17_strollin");

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayVideoButton = (Button) v.findViewById(R.id.hellomoon_playVideoButton);
        mPlayVideoButton.setOnClickListener(this);
        mPlayVideoButton.setEnabled(false);

        mPlayAudioButton = (Button) v.findViewById(R.id.hellomoon_playSoundButton);
        mPlayAudioButton.setOnClickListener(this);

        mStopVideoButton = (Button) v.findViewById(R.id.hellomoon_stopVideoButton);
        mStopVideoButton.setOnClickListener(this);

        mStopAudioButton = (Button) v.findViewById(R.id.hellomoon_stopSoundButton);
        mStopAudioButton.setOnClickListener(this);

        vView = (VideoView) v.findViewById(R.id.video_view_apollo);
        vView.setVideoURI(resourceUri);
        vView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mPlayVideoButton.setEnabled(true);
            }
        });

//        vView.setMediaController(mediaController);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        vView.stopPlayback();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.hellomoon_playVideoButton:
                if (!vView.isPlaying()) {
                    vView.start();
                } else {
                    vView.pause();
                }
                break;
            case R.id.hellomoon_stopVideoButton:
                vView.stopPlayback();
                break;
            case R.id.hellomoon_playSoundButton:
                if(!mPlayer.isPlaying()) {
                    mPlayer.play(getActivity());
                } else {
                    mPlayer.pause();
                }
                break;
            case R.id.hellomoon_stopSoundButton:
                mPlayer.stop();
                break;
        }
    }
}
