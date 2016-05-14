package com.example.rebeckareitmaier.faceless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {
    private List<ForumMessage> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
       // actionBar.inflateMenu(R.menu.menu);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new MessageAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        ImageButton profilNav = (ImageButton) toolbar.findViewById(R.id.profileBtn);
        ImageButton homeBtn = (ImageButton) toolbar.findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(ForumActivity.this, MainActivity.class);
                startActivity(nextScreen);
            }
        });

        profilNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(ForumActivity.this, ProfileActivity.class);
                startActivity(nextScreen);

            }
        });

        prepareMovieData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    private void prepareMovieData() {
        ForumMessage movie = new ForumMessage("Jinna Z.", "Action & Adventure", "23:02");
        movieList.add(movie);

        movie = new ForumMessage("Margaery N.", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Sandra A.", "Action", "19:51");
        movieList.add(movie);

        movie = new ForumMessage("Rina V.", "Animation", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Martin M.", "Science Fiction & Fantasy", "17:45");
        movieList.add(movie);

        movie = new ForumMessage("Cassie H.", "Action", "16:23");
        movieList.add(movie);

        movie = new ForumMessage("Candy H.", "Action", "16:21");
        movieList.add(movie);

        movie = new ForumMessage("Sandra L.", "Science Fiction", "16:00");
        movieList.add(movie);

        movie = new ForumMessage("Gustav O.", "Animation", "2014");
        movieList.add(movie);

        movie = new ForumMessage("Rebecka R.", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new ForumMessage("Gina U.", "Science Fiction", "15:59");
        movieList.add(movie);

        movie = new ForumMessage("Sara R.", "Animation", "15:45");
        movieList.add(movie);

        movie = new ForumMessage("Leslie A.", "Science Fiction", "13:12");
        movieList.add(movie);

        movie = new ForumMessage("Katarina K.", "Action & Adventure", "13:12");
        movieList.add(movie);

        movie = new ForumMessage("Alex A.", "Action & Adventure", "13:00");
        movieList.add(movie);

        movie = new ForumMessage("Ryan T", "Science Fiction & Fantasy", "12:00");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}