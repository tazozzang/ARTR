package com.example.tazo.artr;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tazo on 2018-05-07.
 */

public class FragHome  extends Fragment {
    View root;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_home, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성

    }
}
