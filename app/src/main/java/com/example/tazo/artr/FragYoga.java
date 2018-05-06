package com.example.tazo.artr;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragYoga extends Fragment implements View.OnClickListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View root;
    Button yoga_train;
    Button diet_train;
    Button medi_train;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_yoga, container, false);
        this.root = root;

        init();

        return root;
    }

    void init(){
    //여기다가 화면 구성
        yoga_train = (Button)root.findViewById(R.id.yoga_train);
        diet_train = (Button)root.findViewById(R.id.diet_train);
        medi_train = (Button)root.findViewById(R.id.medi_train);

        yoga_train.setOnClickListener(this);
        diet_train.setOnClickListener(this);
        medi_train.setOnClickListener(this);
        // 뭐 누르면 FragTrain 으로 바뀔것
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
    public void onClick(View view) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        FragTrain fragTrain = new FragTrain();
        Bundle bundle = new Bundle();

        switch (view.getId()){
            case R.id.diet_train:
                bundle.putString("Train","Diet");
                fragTrain.setArguments(bundle);
                break;
            case R.id.yoga_train:
                bundle.putString("Train","Yoga");
                fragTrain.setArguments(bundle);
                break;
            case R.id.medi_train:
                bundle.putString("Train","Medi");
                fragTrain.setArguments(bundle);
                break;
        }
        fragmentTransaction.replace(R.id.main_frame,fragTrain)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .commit();
    }
}
