package com.e.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private String mDemoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mDemoText = getIntent().getStringExtra(MainActivity.KEY_SAMPLE_EXTRA);

    }

    public void doGoBack(View view) {
        Toast.makeText(this,mDemoText,Toast.LENGTH_SHORT).show();
        finish();
    }
}