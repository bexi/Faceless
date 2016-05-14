package com.example.rebeckareitmaier.faceless;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rebeckareitmaier.faceless.MainActivityClasses.CardAdapter;
import com.example.rebeckareitmaier.faceless.data.User;
import com.example.rebeckareitmaier.faceless.data.UserData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        UserData userData = new UserData();
        List<User> userList = userData.getUsers();
        setAdapterViewFlipper(userList);

        ImageButton profilNav = (ImageButton) toolbar.findViewById(R.id.profileBtn);
        ImageButton forumBtn = (ImageButton) toolbar.findViewById(R.id.forumBtn);

        forumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity.this, ForumActivity.class);
                startActivity(nextScreen);
            }
        });

        profilNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(nextScreen);

            }
        });

    }

    //Inits the adapter used for paging
    private void setAdapterViewFlipper(List<User> users){

        //Create CardAdapter
        CardAdapter<User> cardAdapter = new CardAdapter<>(this,
                R.layout.view_main, users);
        // Create and set the flipper
        final AdapterViewFlipper simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.mainAdapterViewFlipper); // get the reference of AdapterViewFlipper
        simpleAdapterViewFlipper.setAdapter(cardAdapter); // set adapter for AdapterViewFlipper

        //yesBtn
        ImageView yesImg = (ImageView) findViewById(R.id.yesImg);
        ImageView noImg = (ImageView) findViewById(R.id.noImg);

        yesImg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                simpleAdapterViewFlipper.showNext();
                Context context = getApplicationContext();
                CharSequence text = "Yeeey!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        noImg.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                simpleAdapterViewFlipper.showNext();
                Context context = getApplicationContext();
                CharSequence text = "Not this one...";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }
    public void yesClick(){

    }
}
