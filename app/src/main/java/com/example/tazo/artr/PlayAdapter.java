package com.example.tazo.artr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Tazo on 2018-05-06.
 */

public class PlayAdapter extends ArrayAdapter<Play> {
    ArrayList<Play> arrayList;
    Context context;
    public PlayAdapter(@NonNull Context context, int resource, ArrayList<Play> objects) {
        super(context, resource,objects);
        this.arrayList = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater vi = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.play_row, null);
        }
        Play play = arrayList.get(position);
        if(play != null){
            ImageView imageView = (ImageView)v.findViewById(R.id.game_image);
            if(imageView != null){imageView.setImageResource(play.getImage());}
        }
        return v;
    }
}
