package com.example.tazo.artr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * Created by Tazo on 2018-05-07.
 */

public class FragChallenge extends Fragment implements CompoundButton.OnCheckedChangeListener {

    ToggleButton tb1;
    ToggleButton tb2;
    ToggleButton tb3;
    ToggleButton tb4;
    ToggleButton tb5;
    ToggleButton tb6;
    ToggleButton tb7;
    ToggleButton tb8;


    Button button;


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    View root;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_chall, container, false);
        this.root = root;

        init();

        return root;
    }

    void init() {
        //여기다가 화면 구성

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        tb1 = (ToggleButton)root.findViewById(R.id.tb1);
        tb2 = (ToggleButton)root.findViewById(R.id.tb2);
        tb3 = (ToggleButton)root.findViewById(R.id.tb3);
        tb4 = (ToggleButton)root.findViewById(R.id.tb4);
        tb5 = (ToggleButton)root.findViewById(R.id.tb5);
        tb6 = (ToggleButton)root.findViewById(R.id.tb6);
        tb7 = (ToggleButton)root.findViewById(R.id.tb7);
        tb8 = (ToggleButton)root.findViewById(R.id.tb8);

        tb1.setOnCheckedChangeListener(this);
        tb2.setOnCheckedChangeListener(this);
        tb3.setOnCheckedChangeListener(this);
        tb4.setOnCheckedChangeListener(this);
        tb5.setOnCheckedChangeListener(this);
        tb6.setOnCheckedChangeListener(this);
        tb7.setOnCheckedChangeListener(this);
        tb8.setOnCheckedChangeListener(this);




        button = (Button) root.findViewById(R.id.buttonPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragTrain fragTrain = new FragTrain();

                fragmentTransaction.replace(R.id.main_frame, fragTrain)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .commit();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
        if(check){
            compoundButton.setBackgroundResource(R.drawable.toggle_b);
        }else{
            compoundButton.setBackgroundResource(R.drawable.toggle_a);
        }
    }
}
