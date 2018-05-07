package com.example.tazo.artr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000);

    }
    private class splashhandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), LoginActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
            Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }

}
