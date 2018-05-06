package com.example.tazo.artr;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Tazo on 2018-05-05.
 */

public class FragPlay extends Fragment {

    View root;

    ListView listView;

    ArrayList<Play> arrayList;
    PlayAdapter playAdapter;
    Play[] plays = new Play[2];

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_play, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성
        arrayList = new ArrayList<Play>();
        listView = (ListView)root.findViewById(R.id.play_list);

        plays[0] = new Play(R.drawable.game_a);
        plays[1] = new Play(R.drawable.game_b);

        arrayList.add(plays[0]);
        arrayList.add(plays[1]);

        playAdapter = new PlayAdapter(root.getContext(),R.layout.play_row,arrayList);
        listView.setAdapter(playAdapter);
    }

}
