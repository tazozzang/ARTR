package com.example.tazo.artr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tazo on 2018-05-07.
 */

public class ExAdapter extends ArrayAdapter<Ex> {
    ArrayList<Ex> arrayList;
    Context context;
    public ExAdapter(@NonNull Context context,int resource , ArrayList<Ex> objects) {
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
            v = vi.inflate(R.layout.ex_row, null);
        }
        Ex ex = arrayList.get(position);
        if(ex != null){
            TextView Name = (TextView)v.findViewById(R.id.ename);
            TextView time = (TextView)v.findViewById(R.id.etime);
            ProgressBar progress = (ProgressBar) v.findViewById(R.id.eprogress);

            if(Name != null){Name.setText(ex.getName());}
            if(time != null){time.setText("총 "+String.valueOf(ex.getTime()) + "시간");}
            if(progress != null){progress.setProgress(ex.getProgress());}
        }
        return v;
    }
}
