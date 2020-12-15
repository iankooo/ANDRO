package com.e.contactrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW = 0;
    private static final int CONTACT_VIEW = 1;

    private ArrayList<ContactModel> mDataSource;
    WeakReference<Context> mContextWeakReference;

    public ContactAdapter(ArrayList<ContactModel> contacts, Context context){
        mDataSource = contacts;
        this.mContextWeakReference = new WeakReference<>(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = mContextWeakReference.get();
         if (viewType == HEADER_VIEW) {
             return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false));
         }
         return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false), context);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSource.get(position).isHeader()){
            return HEADER_VIEW;
        } else {
            return CONTACT_VIEW;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        Context context = mContextWeakReference.get();
        if (context == null) {
            return;
        }
        if (HEADER_VIEW == getItemViewType(position)){
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            ContactModel contactModel = mDataSource.get(position);
            headerViewHolder.headerTextView.setText(contactModel.getContact());
            return;
        }
        ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
        ContactModel contactModel = mDataSource.get(position);
        contactViewHolder.contactTextView.setText(contactModel.getContact());
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }
    
    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView contactTextView;

        public ContactViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            contactTextView = itemView.findViewById(R.id.contactTextView);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.headerTextView);
        }
    }
}
