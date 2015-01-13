package com.detroitlabs.kyleofori.hellomoon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;

/**
 * Created by kyleofori on 1/12/15.
 */
public class AudioPlayer extends Object {

    private MediaPlayer mPlayer = new MediaPlayer();
    private boolean hasEverStarted = false;

    public boolean hasEverStarted() {
        return hasEverStarted;
    }

    public void setHasEverStarted(boolean hasEverStarted) {
        this.hasEverStarted = hasEverStarted;
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            setHasEverStarted(false);
        }
        
    }

    public void play(Context c) {
        if (hasEverStarted()) {
            resume();
        } else {

            stop();

            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            setHasEverStarted(true);
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
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    public void resume() {
        mPlayer.start();
    }

    public boolean isPlaying() {
        if(mPlayer != null) {
            return mPlayer.isPlaying();
        } else {
            return false;
        }

    }


}
