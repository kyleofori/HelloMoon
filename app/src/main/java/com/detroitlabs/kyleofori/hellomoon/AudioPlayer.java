package com.detroitlabs.kyleofori.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by kyleofori on 1/12/15.
 */
public class AudioPlayer extends Object {

    private MediaPlayer mPlayer = new MediaPlayer();
    private boolean isPaused = false;

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        if(isPaused) {
            mPlayer.start();
            setPaused(false);
        } else {
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

    public void pause() {
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
            setPaused(true);
        }
    }




}
