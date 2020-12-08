package com.e.myandrodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDemoAdapter extends RecyclerView.Adapter<MyDemoAdapter.DemoViewHolder> {

    private ArrayList<String> mDataSet;
    private LayoutInflater mLayoutInflater;

    public MyDemoAdapter(Context context, ArrayList<String> mDataSet){
        this.mDataSet = mDataSet;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_recyclerdemo, parent, false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        String title = mDataSet.get(position);
        holder.update(title, "Subtitle: " + title);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mSubTitle;

        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.itemList_tvTitle);
            mSubTitle = itemView.findViewById(R.id.itemList_tvSubTitle);
        }

        public void update(String title, String subTitle){
            mTitle.setText(title);
            mSubTitle.setText(subTitle);
        }
    }
}
