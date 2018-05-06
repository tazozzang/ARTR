package com.example.tazo.artr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tazo on 2018-05-06.
 */

public class FriendAdapter extends ArrayAdapter<Friend>{
    ArrayList<Friend> arrayList;
    Context context;
    public FriendAdapter(@NonNull Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.arrayList = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater vi = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.friend_row, null);
        }
        Friend friend = arrayList.get(position);
        if(friend != null){
            ImageView FAva = (ImageView)v.findViewById(R.id.fri_ava);
            TextView FName = (TextView)v.findViewById(R.id.fri_name);
            TextView FCheck = (TextView)v.findViewById(R.id.fri_check);
            TextView FLevel = (TextView)v.findViewById(R.id.fri_level);
            if(FAva != null){}
            if(FName != null){FName.setText(friend.getFName());}
            if(FCheck != null){FCheck.setText(Integer.toString(friend.getFCheck()));}
            if(FLevel != null){FLevel.setText(Integer.toString(friend.getFLevel()));}
        }
        return v;
    }
}
