package com.example.rebeckareitmaier.faceless;

/**
 * Created by MichelleTL on 14/05/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private List<ForumMessage> messageList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, message, timeStamp;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTextView);
            message = (TextView) view.findViewById(R.id.messageTextView);
            timeStamp = (TextView) view.findViewById(R.id.timeStampTextView);
        }
    }


    public MessageAdapter(List<ForumMessage> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_forum_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ForumMessage movie = messageList.get(position);
        holder.name.setText(movie.getName());
        holder.message.setText(movie.getMessage());
        holder.timeStamp.setText(movie.getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}