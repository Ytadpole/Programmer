package com.ytadpole.demo1.com.ytadpole.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ytadpole.demo1.R;
import com.ytadpole.demo1.WelcomeActivity;
import com.ytadpole.demo1.com.ytadpole.demo1.conf.GlobleConf;

public class LaucherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isFirstIn()) {
                    startActivity(new Intent(LaucherActivity.this, WelcomeActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(LaucherActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 1000);
    }

    private boolean isFirstIn() {
        SharedPreferences sp = getSharedPreferences(GlobleConf.sp_name, MODE_PRIVATE);
        if(sp.getBoolean(GlobleConf.isFirstIn, true)) {
            SharedPreferences.Editor ed = sp.edit();
            ed.putBoolean(GlobleConf.isFirstIn, false);
            ed.commit();
            return true;
        }
        else return false;
    }
}
