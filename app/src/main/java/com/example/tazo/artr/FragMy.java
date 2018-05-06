package com.example.tazo.artr;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Tazo on 2018-05-05.
 */

public class FragMy extends Fragment {

    View root;

    User_Info user_info;

    TextView myName;
    TextView myBirth;
    TextView myTall;
    TextView myKg;
    TextView myCheck_Lev;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_my, container, false);
        this.root = root;

        init();

        return root;
    }
    void init(){
        //여기다가 화면 구성
        myName = (TextView)root.findViewById(R.id.MyName);
        myBirth = (TextView)root.findViewById(R.id.MyBirth);
        myTall = (TextView)root.findViewById(R.id.MyTall);
        myKg = (TextView)root.findViewById(R.id.MyKg);
        myCheck_Lev = (TextView)root.findViewById(R.id.MyCheck);

        myName.setText(user_info.getMe_Name());
        myBirth.setText(user_info.getMe_year() + "/" + user_info.getMe_month()+"/" + user_info.getMe_day());
        myTall.setText(user_info.getMe_tall() + "cm");
        myKg.setText(user_info.getMe_kg()+"kg");
        myCheck_Lev.setText(user_info.getMe_check() + " Level " + user_info.getMe_level());
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
