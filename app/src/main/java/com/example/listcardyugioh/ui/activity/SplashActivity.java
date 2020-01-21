package com.example.listcardyugioh.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.listcardyugioh.R;
import com.example.listcardyugioh.data.LocalDataUsers;

public class SplashActivity extends AppCompatActivity {

    //------ function android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getDataActivity();
    }

    //----- set views
    private void getDataActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(new LocalDataUsers().getKeyUserToken(SplashActivity.this) == null){
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 2000);
    }
}
