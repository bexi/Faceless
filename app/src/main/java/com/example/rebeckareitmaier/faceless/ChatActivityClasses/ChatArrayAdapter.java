package com.example.rebeckareitmaier.faceless.ChatActivityClasses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebeckareitmaier.faceless.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustav on 2016-05-14.
 */
public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private List<ChatMessage> messageList = new ArrayList<ChatMessage>();
    private LinearLayout layout;

    public ChatArrayAdapter(Context context, int textViewResourceId, List<ChatMessage> objects){
        super(context, textViewResourceId, objects);
    }

    public void add(ChatMessage object){
        messageList.add(object);
        super.add(object);
    }

    public int getCount(){
        return messageList.size();
    }

    public ChatMessage getItem(int index){
        return messageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.chat, parent, false);
        }

        layout = (LinearLayout)v.findViewById(R.id.Message1);
        ChatMessage messageobj = getItem(position);
        chatText = (TextView)v.findViewById(R.id.SingleMessage);

        chatText.setText(messageobj.message);

        chatText.setBackgroundResource(R.drawable.ic_action_name);

        layout.setGravity(messageobj.left ? Gravity.LEFT : Gravity.RIGHT);

        return v;
    }


    public Bitmap decodeToBitmap(byte[] decodedByte){
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }


}
