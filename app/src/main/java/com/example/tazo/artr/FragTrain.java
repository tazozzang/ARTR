package com.example.tazo.artr;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tazo on 2018-05-06.
 */

public class FragTrain extends Fragment {

    View root;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.frag_train, container, false);
        this.root = root;

        init();

        return root;
    }

    void init(){
        //여기다가 화면 구성



        //get_train.setText(train);



    }

}
