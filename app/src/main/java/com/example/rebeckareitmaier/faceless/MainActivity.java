package com.example.rebeckareitmaier.faceless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;

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
       /* Button btnNext=(Button) findViewById(R.id.testButton); // get the reference of Button
        // set Click event on next button
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                // show the next view of ViewFlipper
                simpleAdapterViewFlipper.showNext();
            }
        });

        //TING och bäskis knappar - att ta bort.

        Button btnTing = (Button) findViewById(R.id.tingButton); // get the reference of Button
        btnTing.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity.this, ForumActivity.class);
                startActivity(nextScreen);
                //finish();
            }
        });
        Button btnBaesk = (Button) findViewById(R.id.bexiButton); // get the reference of Button
        btnBaesk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(nextScreen);
                //finish();
            }
        });

*/

    }
}
