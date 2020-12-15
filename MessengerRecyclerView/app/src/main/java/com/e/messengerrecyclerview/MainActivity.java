package com.e.messengerrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ConversationModel> mDataSource;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ConversationAdapter conversationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataSource = new ArrayList<>();
        mDataSource.add(new ConversationModel("Hi", true));
        mDataSource.add(new ConversationModel("Hello", false));
        mDataSource.add(new ConversationModel("How are you?", true));
        mDataSource.add(new ConversationModel("I'm fine, thank you", false));
        mDataSource.add(new ConversationModel("What about you?", false));
        mDataSource.add(new ConversationModel("Great!", true));
        mDataSource.add(new ConversationModel("Do you wanna hang out?", true));
        mDataSource.add(new ConversationModel("Yes, when?", false));
        mDataSource.add(new ConversationModel("I was thinking about wednesday, if it is ok for you", true));
        mDataSource.add(new ConversationModel("Yeah, that's totally fine, I am free that day", false));
        mDataSource.add(new ConversationModel("S", true));
        mDataSource.add(new ConversationModel("P", true));
        mDataSource.add(new ConversationModel("A", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("M", true));
        mDataSource.add(new ConversationModel("STOP IT!", false));
        mDataSource.add(new ConversationModel("Bye!", false));
        mDataSource.add(new ConversationModel("Bye bye", true));

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.conversationRecyclerView);
        conversationAdapter = new ConversationAdapter(this, mDataSource);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(conversationAdapter);
    }
}