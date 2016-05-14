package com.example.rebeckareitmaier.faceless;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.rebeckareitmaier.faceless.ChatActivityClasses.ChatArrayAdapter;
import com.example.rebeckareitmaier.faceless.ChatActivityClasses.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class ChattActivity extends AppCompatActivity {

    private ChatArrayAdapter adp;
    private ListView list;
    private EditText chatText;
    private Button send;
    Intent in;
    private boolean side = false;
    private List<ChatMessage> messages = new ArrayList<ChatMessage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatt);

        Intent i = getIntent();

        send = (Button) findViewById(R.id.btn);

        list = (ListView) findViewById(R.id.Listview);

        adp = new ChatArrayAdapter(getApplicationContext(), R.layout.chat, messages);

        chatText = (EditText) findViewById(R.id.chat);

        chatText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    return sendChatMessage();
                }
                return false;
            }


        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendChatMessage();
            }
        });

        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);

        adp.registerDataSetObserver(new DataSetObserver() {
            public void onChanged(){
                super.onChanged();
                list.setSelection(adp.getCount() - 1);
            }
        });
    }

    private boolean sendChatMessage() {
        adp.add(new ChatMessage(side, chatText.getText().toString()));
        chatText.setText("");

        side = !side;

        return true;
    }
}
