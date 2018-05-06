package com.example.tazo.artr;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tazo on 2018-05-06.
 */

public class Play implements Parcelable {
    int image;
    Play(){}
    Play(int image){this.image = image;}

    int getImage(){return image;}

    protected Play(Parcel in) {
        this.image = in.readInt();
    }

    public static final Creator<Play> CREATOR = new Creator<Play>() {
        @Override
        public Play createFromParcel(Parcel in) {
            return new Play(in);
        }

        @Override
        public Play[] newArray(int size) {
            return new Play[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
    }
}
