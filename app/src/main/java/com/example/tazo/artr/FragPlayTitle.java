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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tazo on 2018-05-07.
 */

public class FragPlayTitle extends Fragment {
    View root;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageView imageView;
    TextView textView;
    Button button;

    int game_image[] = new int[2];
    String game_info[] = new String[2];

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_play_title, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성
        int position = getArguments().getInt("position");
        imageView = (ImageView)root.findViewById(R.id.game_image);
        textView = (TextView)root.findViewById(R.id.game_info);
        button = (Button)root.findViewById(R.id.start_btn);
        if(position == 1){button.setClickable(false);
        button.setBackgroundColor(getResources().getColor(R.color.Gray));}
        else{button.setClickable(true);
            button.setBackgroundColor(getResources().getColor(R.color.colorPastelDark));}

        game_image[0] = R.drawable.game_a;
        game_image[1] = R.drawable.game_b;

        game_info[0] = " 다가오는 벽에 난 구멍에 맞는 포즈를 취해 벽을 통과하는 게임입니다.";
        game_info[1] = " 게임을 준비 중입니다.";

        imageView.setImageResource(game_image[position]);
        textView.setText(game_info[position]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                FragTrain fragTrain = new FragTrain();

                fragmentTransaction.replace(R.id.main_frame, fragTrain)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .commit();

            }
        });


    }
}
