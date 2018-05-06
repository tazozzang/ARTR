package com.example.tazo.artr;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tazo on 2018-05-05.
 */

public class FragPlay extends Fragment {

    View root;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_play, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == getActivity().RESULT_OK){
                //당장은 필요 없는 부분
            }
        }
    }
}
