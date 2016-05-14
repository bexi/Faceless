package com.example.rebeckareitmaier.faceless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new MessageAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        ForumMessage movie = new ForumMessage("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new ForumMessage("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new ForumMessage("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new ForumMessage("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new ForumMessage("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new ForumMessage("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new ForumMessage("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new ForumMessage("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new ForumMessage("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new ForumMessage("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new ForumMessage("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}