package com.example.rebeckareitmaier.faceless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MyAndroidAppActivity.this,
                        "ImageButton is clicked!", Toast.LENGTH_SHORT).show();

            }

        });
}
