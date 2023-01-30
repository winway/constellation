package com.example.constellation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int MSG_COUNTER = 1;

    private TextView mCounterTV;

    private int count = 5;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPreferences = getSharedPreferences("is_first", MODE_PRIVATE);

        mCounterTV = findViewById(R.id.splash_counter_tv);

        mHandler.sendEmptyMessageDelayed(MSG_COUNTER, 500);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == MSG_COUNTER) {
                count -= 1;
                if (count == 0) {
                    boolean isFirst = mPreferences.getBoolean("is_first", true);
                    Intent intent = new Intent();
                    if (isFirst) {
                        intent.setClass(SplashActivity.this, GuideActivity.class);
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.putBoolean("is_first", false);
                        editor.apply();
                    } else {
                        intent.setClass(SplashActivity.this, MainActivity.class);
                    }
                    startActivity(intent);
                    finish();
                } else {
                    mCounterTV.setText(String.valueOf(count));
                    mHandler.sendEmptyMessageDelayed(MSG_COUNTER, 500);
                }
            }
        }
    };


}