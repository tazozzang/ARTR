package com.example.tazo.artr;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tazo on 2018-05-07.
 */

public class Ex implements Parcelable {
    String name;
    int time;
    int progress;

    Ex(){}
    Ex(String name, int time, int progress){
        this.name = name;
        this.time = time;
        this.progress = progress;
    }

    protected Ex(Parcel in) {
        name = in.readString();
        time = in.readInt();
        progress = in.readInt();
    }

    public String getName(){return  name;}
    public int getTime(){return time;}
    public int getProgress(){return progress;}

    public static final Creator<Ex> CREATOR = new Creator<Ex>() {
        @Override
        public Ex createFromParcel(Parcel in) {
            return new Ex(in);
        }

        @Override
        public Ex[] newArray(int size) {
            return new Ex[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeInt(time);
        parcel.writeInt(progress);
    }
}
