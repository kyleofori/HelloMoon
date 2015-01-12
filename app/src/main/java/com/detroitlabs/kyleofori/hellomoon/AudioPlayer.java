package com.detroitlabs.kyleofori.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by kyleofori on 1/12/15.
 */
public class AudioPlayer extends Object {

    private MediaPlayer mPlayer = new MediaPlayer();

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mPlayer) {
                stop();
            }
        });

        mPlayer.start();
    }




}
