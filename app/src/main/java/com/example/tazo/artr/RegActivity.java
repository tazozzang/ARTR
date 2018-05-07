package com.example.tazo.artr;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    String year;
    String month;
    String day;
    EditText my_name;
    EditText my_year;
    EditText my_month;
    EditText my_day;
    EditText my_tall;
    EditText my_kg;
    EditText my_id;
    EditText my_pw;

    RadioGroup radioGroup;

    int check = 0;

    private PopupWindow Calendarpop;
    DatePicker datePicker;
    User_Info user_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        my_name = (EditText)findViewById(R.id.me_name);
        my_year = (EditText)findViewById(R.id.me_year);
        my_month = (EditText)findViewById(R.id.me_month);
        my_day = (EditText)findViewById(R.id.me_day);
        my_tall = (EditText)findViewById(R.id.me_tall);
        my_kg = (EditText)findViewById(R.id.me_kg);
        my_id = (EditText)findViewById(R.id.me_id);
        my_pw = (EditText)findViewById(R.id.me_pw);

        radioGroup = (RadioGroup)findViewById(R.id.radio_check);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.me_check_pila){check = 0;}
                else if(i == R.id.me_check_yoga){check = 1;}
                else if(i == R.id.me_check_pt){check = 2;}
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showCal(View view){
        View popUp = getLayoutInflater().inflate(R.layout.popup,null);
        Calendarpop = new PopupWindow(popUp, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        Calendarpop.setFocusable(true);
        Calendarpop.showAtLocation(popUp, Gravity.CENTER,0,0);

        datePicker = (DatePicker) popUp.findViewById(R.id.calendar);
        datePicker.updateDate(1995,6,18);

        Button cancel = (Button)popUp.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendarpop.dismiss();
            }
        });
        Button ok = (Button)popUp.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_year.setText(Integer.toString(datePicker.getYear()));
                my_month.setText(Integer.toString(datePicker.getMonth()+1));
                my_day.setText(Integer.toString(datePicker.getDayOfMonth()));
                Calendarpop.dismiss();
            }
        });
        //popup으로 달력 / 스피터 띄우기
    }
    public void check(View view){
        //중복이 아닙니다 해주기 ㅋ
        Toast.makeText(getApplicationContext(),"사용 가능한 아이디입니다.",Toast.LENGTH_LONG).show();
    }
    public void regist(View view){
        //데이터 user_info에 넣어주기
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);

        if(my_name.getText().toString().length() > 0 && my_year.getText().length() > 0 &&
                my_month.getText().toString().length() > 0 &&
                my_day.getText().toString().length() > 0 &&
                my_tall.getText().toString().length() > 0 &&
                my_kg.getText().toString().length() > 0 &&
                my_id.getText().toString().length() > 0 &&
                my_pw.getText().toString().length() > 0){
            user_info = new User_Info(my_name.getText().toString(),
                    Integer.parseInt(my_year.getText().toString()),
                    Integer.parseInt(my_month.getText().toString()),
                    Integer.parseInt(my_day.getText().toString()),
                    Integer.parseInt(my_tall.getText().toString()),
                    Integer.parseInt(my_kg.getText().toString()),
                    check,
                    my_id.getText().toString(), my_pw.getText().toString());

        }
        else user_info = new User_Info();

        i.putExtra("reg_info",user_info);
        finish();

        startActivity(i);
    }
}
