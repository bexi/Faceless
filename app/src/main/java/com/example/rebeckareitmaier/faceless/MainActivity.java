package com.example.rebeckareitmaier.faceless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAdapterViewFlipper();

    }
    private void setAdapterViewFlipper(){
        List<String> testList;
        testList = new LinkedList<>();
        testList.add("ett");
        testList.add("två");
        testList.add("tre");
        ArrayAdapter<String> testAdapt = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, testList);

        final AdapterViewFlipper simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.mainAdapterViewFlipper); // get the reference of AdapterViewFlipper
        simpleAdapterViewFlipper.setAdapter(testAdapt); // set adapter for AdapterViewFlipper. Here adapter is object of custom adapter
        Button btnNext=(Button) findViewById(R.id.testButton); // get the reference of Button
        // set Click event on next button
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                // show the next view of ViewFlipper
                simpleAdapterViewFlipper.showNext();
            }
        });

        //TING och bäskis knappar

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



    }
}
