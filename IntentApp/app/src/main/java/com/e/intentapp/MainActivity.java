package com.e.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_SAMPLE_EXTRA = "com.example.intent.key.SAMPLE_EXTRA";
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNextButton = findViewById(R.id.actMain_btnStartAct);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "I pushed the button", Toast.LENGTH_SHORT).show();

                // explicit intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra(KEY_SAMPLE_EXTRA, "My Demo Text from MainActivity");
                // implicit intent
                //Intent intent = new Intent("android.intent.action.demoapp.SECOND_ACT");
                startActivity(intent);
            }
        });
    }
}