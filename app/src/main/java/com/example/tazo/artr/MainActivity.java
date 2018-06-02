package com.example.tazo.artr;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    User_Info user_info;

    TextView username;
    ImageView userava;
    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //splash 이미지 넣기
        //login 넘어가기
        init(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View nav_header = navigationView.getHeaderView(0);

        home = (ImageView)nav_header.findViewById(R.id.home);
        username = (TextView)nav_header.findViewById(R.id.user_name);
        userava = (ImageView)nav_header.findViewById(R.id.imageView);

        home.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(user_info != null) {
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();

                    FragHome fragHome = new FragHome();
                    fragmentTransaction.replace(R.id.main_frame, fragHome).commit();

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                else{
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();

                    FragYoga fragYoga = new FragYoga();
                    fragmentTransaction.replace(R.id.main_frame, fragYoga).commit();

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

        if(user_info != null) {
            userava.setImageResource(R.drawable.jy);
            username.setText(user_info.getMe_Name());
        }else{
            userava.setImageResource(R.drawable.login);
            userava.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Intent i = new Intent(getApplication(),LoginActivity.class);
                    finish();
                    startActivity(i);
                    return false;
                }
            });
            username.setText("로그인을 해주세요.");
        }
    }

    void init(Bundle savedInstanceState){

        if(findViewById(R.id.main_frame) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager = getFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();

            Intent getIntent = getIntent();
            if(getIntent != null) {
                user_info = (User_Info) getIntent.getSerializableExtra("user_info");
            }

            if(user_info!=null) {
                FragHome fragHome = new FragHome();
                fragmentTransaction.replace(R.id.main_frame, fragHome).commit();
            }else{
                FragYoga fragYoga = new FragYoga();
                fragmentTransaction.replace(R.id.main_frame, fragYoga).commit();
            }

        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            //환경 설정
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.nav_yoga) {
            FragYoga fragYoga = new FragYoga();
            fragmentTransaction.replace(R.id.main_frame,fragYoga).commit();

        } else if (id == R.id.nav_play) {
            FragPlay fragPlay = new FragPlay();
            fragmentTransaction.replace(R.id.main_frame,fragPlay).commit();

        } else if (id == R.id.nav_menu) {
            if(user_info != null) {
                FragMy fragMy = new FragMy();
                fragmentTransaction.replace(R.id.main_frame, fragMy).commit();
            }
            else {
                Toast.makeText(getApplicationContext(),"로그인 해주세요.",Toast.LENGTH_LONG).show();
            }

        }  else if (id == R.id.nav_share) {
            if(user_info != null) {
                FragFriend fragFriend = new FragFriend();
                fragmentTransaction.replace(R.id.main_frame, fragFriend).commit();
            }
            else {
                Toast.makeText(getApplicationContext(),"로그인 해주세요.",Toast.LENGTH_LONG).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public User_Info getData(){return  user_info;}
}
