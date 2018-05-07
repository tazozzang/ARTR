package com.example.tazo.artr;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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

public class FragMy extends Fragment {

    View root;

    User_Info user_info;

    ArrayList<Ex> arrayList;
    ExAdapter exAdapter;
    Ex[] exes = new Ex[3];

    ListView listView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_my, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성
        arrayList = new ArrayList<Ex>();
        listView = (ListView)root.findViewById(R.id.listview);

        exes[0] = new Ex("요가",3,70);
        exes[1] = new Ex("필라테스",2,52);
        exes[2] = new Ex("PT",0,0);
        arrayList.add(exes[0]);
        arrayList.add(exes[1]);
        arrayList.add(exes[2]);


        exAdapter = new ExAdapter(root.getContext(),R.layout.friend_row,arrayList);
        listView.setAdapter(exAdapter);
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(getActivity() != null && getActivity() instanceof MainActivity){
            user_info = ((MainActivity)getActivity()).getData();
        }
    }
}
