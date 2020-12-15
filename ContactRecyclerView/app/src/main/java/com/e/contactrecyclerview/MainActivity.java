package com.e.contactrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mDataSource;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    
    private ArrayList<ContactModel> mContacts;
    private ArrayList<ContactModel> mHeadersAndContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataSource = new ArrayList<>();

        mDataSource.add("Ana");
        mDataSource.add("Anna");
        mDataSource.add("Anabella");
        mDataSource.add("Ana-Maria");
        mDataSource.add("Alexandra");
        mDataSource.add("Adda");
        mDataSource.add("Adelina");
        mDataSource.add("Anisoara");
        mDataSource.add("Beni");
        mDataSource.add("Bianca");
        mDataSource.add("Cosmin");
        mDataSource.add("Cosmina");
        mDataSource.add("Cristi");
        mDataSource.add("Cristiana");
        mDataSource.add("Danut");
        mDataSource.add("Daiana");
        mDataSource.add("Mari");
        mDataSource.add("Diana");
        mDataSource.add("Dan");
        mDataSource.add("Didi");
        mDataSource.add("Felicia");
        mDataSource.add("Feli");
        mDataSource.add("Fernando");
        mDataSource.add("Alina");
        mDataSource.add("Giov");
        mDataSource.add("Paul");
        mDataSource.add("Edgar");
        mDataSource.add("Tomi");
        mDataSource.add("Sara");
        mDataSource.add("Sorin");


        mContacts = new ArrayList<>();
        for (int i = 0; i< mDataSource.size(); i++){
            mContacts.add(new ContactModel(mDataSource.get(i), false));
        }

        mHeadersAndContacts = new ArrayList<>();
        sortContacts();
        
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView1);
        contactAdapter = new ContactAdapter(mHeadersAndContacts, this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(contactAdapter);

    }

    private void sortContacts() {
        Collections.sort(mContacts, (o1, o2) -> String.valueOf(o1.getContact().charAt(0)).toUpperCase().compareTo(String.valueOf(o2.getContact().charAt(0)).toUpperCase()));
        String lastHeader = "";

        for(int i = 0; i < mContacts.size(); i++){
            String contact = mContacts.get(i).getContact();
            String header = String.valueOf(contact.charAt(0)).toUpperCase();

            if (!lastHeader.equals(header)){
                lastHeader = header;
                mHeadersAndContacts.add(new ContactModel(lastHeader,true));
            }
            mHeadersAndContacts.add(new ContactModel(contact,false));
        }
    }
}