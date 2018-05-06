package com.example.tazo.artr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegActivity extends AppCompatActivity {
    User_Info user_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }
    public void showCal(View view){
        //popup으로 달력 / 스피터 띄우기
    }
    public void check(View view){
        //중복이 아닙니다 해주기 ㅋ
    }
    public void regist(View view){
        //데이터 user_info에 넣어주기
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        user_info = new User_Info();
        i.putExtra("user_info",user_info);
        finish();

        startActivity(i);
    }
}
