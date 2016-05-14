package com.example.rebeckareitmaier.faceless.MainActivityClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rebeckareitmaier.faceless.R;
import com.example.rebeckareitmaier.faceless.data.User;

import java.util.List;

/**
 * Created by Lovre on 2016-05-14.
 */
public class CardAdapter<T> extends ArrayAdapter {
    Context context;
    List<T> users;
    public CardAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        this.context = context;
        users = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);

        if( convertView == null ){
            //We must create a View:
            convertView = inflater.inflate(R.layout.view_main, parent, false);
        }
        User currentUser = (User) users.get(position);

        //Getting all fields
        TextView quoteTextView = (TextView) convertView.findViewById(R.id.quoteTV);
        TextView tagTextView = (TextView) convertView.findViewById(R.id.tagTV);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.nameTV);

        //Converting tags to string
        List<String> tagList = currentUser.getTags();
        String tags = "";
        for(String s: tagList){
            tags.concat(" #" + s);
        }
        //Setting all fields
        quoteTextView.setText(currentUser.getQuote());
        tagTextView.setText(tags);
        nameTextView.setText(currentUser.getName());

        return convertView;
    }
}
