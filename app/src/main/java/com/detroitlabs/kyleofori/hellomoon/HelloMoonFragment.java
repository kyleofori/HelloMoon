package com.detroitlabs.kyleofori.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kyleofori on 1/12/15.
 */
public class HelloMoonFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;
    public static HelloMoonFragment newInstance() {
        HelloMoonFragment helloMoonFragment = new HelloMoonFragment();
        Bundle args = new Bundle();
        args.putInt("key", 3);
        helloMoonFragment.setArguments(args);
        return helloMoonFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
        return v;
    }
}
