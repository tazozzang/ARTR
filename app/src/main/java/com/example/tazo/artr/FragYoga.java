package com.example.tazo.artr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragYoga extends Fragment {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View root;

    ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_yoga, container, false);
        this.root = root;

        init();

        return root;
    }

    void init() {
        //여기다가 화면 구성

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        imageView = (ImageView) root.findViewById(R.id.tv);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FragChallenge fragChallenge = new FragChallenge();

                fragmentTransaction.replace(R.id.main_frame,fragChallenge)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .commit();
                return false;
            }
        });
    }
}
