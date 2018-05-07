package com.example.tazo.artr;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tazo on 2018-05-06.
 */

public class Friend implements Parcelable{
    int FAvatar;
    String FName;
    int FCheck ;
    int FLevel;

    Friend(){}
    Friend(int avatar, String name, int check, int level){
        this.FAvatar = avatar;
        this.FName = name;
        this.FCheck = check;
        this.FLevel = level;
    }
    protected Friend(Parcel in) {
        FAvatar = in.readInt();
        FName = in.readString();
        FCheck = in.readInt();
        FLevel = in.readInt();

    }
    public int getFAvatar(){return FAvatar;}
    public String getFName(){return FName;}
    public String getFCheck(){
        String answer = "목표";
        switch (FCheck){
            case 0:
                answer =  "필라테스";
                break;
            case 1:
                answer =  "요가";
                break;
            case 2:
                answer =   "PT";
                break;
        }
        return answer;
    }
    public int getFLevel(){return FLevel;}

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(FAvatar);
        parcel.writeString(FName);
        parcel.writeInt(FCheck);
        parcel.writeInt(FLevel);
    }
}
