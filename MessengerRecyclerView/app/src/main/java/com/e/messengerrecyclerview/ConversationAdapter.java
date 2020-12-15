package com.e.messengerrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int EMITTER = 0;
    private static final int RECEIVER = 1;

    private final ArrayList<ConversationModel> mDataSource;
    private final LayoutInflater mLayoutInflater;

    public ConversationAdapter(Context context, ArrayList<ConversationModel> mDataSource) {
        this.mDataSource = mDataSource;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == EMITTER) {
            View view = mLayoutInflater.inflate(R.layout.item_emitter_message, parent, false);
            return new EmitterViewHolder(view);
        }
        View view = mLayoutInflater.inflate(R.layout.item_receiver_message, parent, false);
        return new ReceiverViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSource.get(position).isEmitter()) {
            return EMITTER;
        } else {
            return RECEIVER;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String message = mDataSource.get(position).getMessage();
        if (EMITTER == getItemViewType(position)) {
            ((EmitterViewHolder) holder).update(message);
            return;
        }
        ((ReceiverViewHolder)holder).update(message);
    }


    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public static class EmitterViewHolder extends RecyclerView.ViewHolder {
        private final TextView emitterTextView;

        public EmitterViewHolder(@NonNull View itemView) {
            super(itemView);

            emitterTextView = itemView.findViewById(R.id.emitterTextView);
        }

        public void update(String message) {
            emitterTextView.setText(message);
        }
    }

    public static class ReceiverViewHolder extends RecyclerView.ViewHolder {
        private final TextView receiverTextView;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverTextView = itemView.findViewById(R.id.receiverTextView);
        }

        public void update(String message) {
            receiverTextView.setText(message);
        }
    }
}
