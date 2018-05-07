package com.example.tazo.artr;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private User_Info user_info;
    Button login_bt;
    TextView join_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent getIntent = getIntent();
        user_info = (User_Info) getIntent.getSerializableExtra("reg_info");

        login_bt = (Button)findViewById(R.id.login_bt);
        join_bt = (TextView)findViewById(R.id.join_bt);

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                if(user_info == null) user_info = new User_Info();
                i.putExtra("user_info",user_info);
                finish();
                startActivity(i);
            }
        });

        join_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegActivity.class);
                finish();
                startActivity(i);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
