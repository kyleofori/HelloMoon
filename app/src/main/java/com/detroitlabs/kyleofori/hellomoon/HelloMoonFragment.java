package com.detroitlabs.kyleofori.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by kyleofori on 1/12/15.
 */
public class HelloMoonFragment extends Fragment {

    public static HelloMoonFragment newInstance() {
        HelloMoonFragment helloMoonFragment = new HelloMoonFragment();
        Bundle args = new Bundle();
        args.putInt("key", 3);
        helloMoonFragment.setArguments(args);
        return helloMoonFragment;
    }
}
