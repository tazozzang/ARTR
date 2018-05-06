package com.example.tazo.artr;

import java.io.Serializable;

/**
 * Created by Tazo on 2018-05-06.
 */

public class User_Info implements Serializable{
    private String me_Name;
    private int me_year;
    private int me_month;
    private int me_day;
    private int me_tall;
    private int me_kg;
    private int me_check;
    private int me_level;
    private String me_id;
    private String me_pw;


    public User_Info(){
        this.me_Name = "이지연";
        this.me_year = 1995;
        this.me_month = 7;
        this.me_day = 18;
        this.me_tall = 165;
        this.me_kg = 53;
        this.me_check = 1;
        this.me_level = 1; // 내 레벨은 하
        this.me_id = "dlwldus718";
        this.me_pw = "dlwldus718";
    }

    public User_Info(int me_tall, int me_kg){
        this.me_Name = "이지연";
        this.me_year = 1995;
        this.me_month = 7;
        this.me_day = 18;
        this.me_tall = me_tall;
        this.me_kg = me_kg;
        this.me_check = 0;
        this.me_level = 0;
        this.me_id = "dlwldus718";
        this.me_pw = "dlwldus718";
    }

    public User_Info(String me_Name, int me_year, int me_month, int me_day,
                     int me_tall,int me_kg, int me_check, int me_level
    , String me_id, String me_pw){
        this.me_Name = me_Name;
        this.me_year = me_year;
        this.me_month = me_month;
        this.me_day = me_day;
        this.me_tall = me_tall;
        this.me_kg = me_kg;
        this.me_check = me_check;
        this.me_level = me_level;
        this.me_id = me_id;
        this.me_pw = me_pw;
    }

    public void setMe_Name(String name){this.me_Name = name;}
    public void setMe_year(int year){this.me_year = year;}
    public void setMe_month(int month){this.me_month = month;}
    public void setMe_day(int day){this.me_day = day;}
    public void setMe_tall(int tall){this.me_tall = tall;}
    public void setMe_kg(int kg){this.me_kg = kg;}
    public void setMe_check(int check){this.me_check = check;}
    public void setMe_level(int level){this.me_level = level;}
    public void setMe_id(String iden){this.me_id = iden;}
    public void setMe_pw(String pw){this.me_pw = pw;}


    public String getMe_Name(){return me_Name;}
    public int getMe_year(){return me_year;}
    public int getMe_month(){return me_month;}
    public int getMe_day(){return me_day;}
    public int getMe_tall(){return me_tall;}
    public int getMe_kg(){return me_kg;}
    public String getMe_check(){
        String answer = "목표";
        switch (me_check){
            case 0:
                answer =  "다이어트";
                break;
            case 1:
                answer =  "스트레칭";
                break;
            case 2:
                answer =   "명상";
                break;
        }
        return answer;
    }
    public int getMe_level(){return me_level;}
    public String getMe_id(){return  me_id;}
    public String getMe_pw(){return me_pw;}

}
