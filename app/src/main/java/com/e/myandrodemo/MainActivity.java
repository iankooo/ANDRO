package com.e.myandrodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WebView mMyWebview;
    private final static String MY_WEB_ADDRESS = "https://www.cnn.com";
    private ArrayList<String> mDataSource;
    private LinearLayoutManager mListLayoutManager;
    private RecyclerView mList;
    private MyDemoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        mDataSource = new ArrayList<>();

        for(int i=0;i<10; i++) {
            mDataSource.add("Peanut" + i);
            mDataSource.add("Butter" + i);
            mDataSource.add("Jelly" + i);
            mDataSource.add("Donut" + i);
            mDataSource.add("Eclair" + i);
            mDataSource.add("Strawberry" + i);
        }
        mListLayoutManager = new LinearLayoutManager(this);
        mList = findViewById(R.id.actMain_listDemoRecycler);
        mAdapter = new MyDemoAdapter(this, mDataSource);

        mList.setLayoutManager(mListLayoutManager);
        mList.setAdapter(mAdapter);

//        mMyWebview =  findViewById(R.id.my_webview);
//
//        WebSettings web_settings = mMyWebview.getSettings();
//        web_settings.setJavaScriptEnabled(true);
//
//        mMyWebview.setWebViewClient(new MyClient());
//
//        mMyWebview.loadUrl(MY_WEB_ADDRESS);
    }

    private class MyClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}