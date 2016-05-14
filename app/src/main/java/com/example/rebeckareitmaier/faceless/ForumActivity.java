package com.example.rebeckareitmaier.faceless;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ForumMessage movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent nextScreen = new Intent(ForumActivity.this, ChattActivity.class);
                startActivity(nextScreen);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

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
        ForumMessage movie = new ForumMessage("Jinna Z.", "I cant", "23:02");
        movieList.add(movie);

        movie = new ForumMessage("Margaery N.", "Vacation mon - fri", "22:21");
        movieList.add(movie);

        movie = new ForumMessage("Sandra A.", "whatsup?", "19:51");
        movieList.add(movie);

        movie = new ForumMessage("Rina V.", "Yeah, sounds cool", "2015");
        movieList.add(movie);

        movie = new ForumMessage("Martin M.", "Asap", "17:45");
        movieList.add(movie);

        movie = new ForumMessage("Cassie H.", "Brb, gonna get food", "16:23");
        movieList.add(movie);

        movie = new ForumMessage("Candy H.", "What about today?", "16:21");
        movieList.add(movie);

        movie = new ForumMessage("Sandra L.", "I don't understand...", "16:00");
        movieList.add(movie);

        movie = new ForumMessage("Gustav O.", "I wanna meet them", "2014");
        movieList.add(movie);

        movie = new ForumMessage("Rebecka R.", "What about skiing?", "2008");
        movieList.add(movie);

        movie = new ForumMessage("Gina U.", "Naa, kinda tired", "15:59");
        movieList.add(movie);

        movie = new ForumMessage("Sara R.", "Have you seen it? Its on cinema", "15:45");
        movieList.add(movie);

        movie = new ForumMessage("Leslie A.", "I don't like sushi, grab burger?", "13:12");
        movieList.add(movie);

        movie = new ForumMessage("Katarina K.", "Hello nice to meet you", "13:12");
        movieList.add(movie);

        movie = new ForumMessage("Alex A.", "Im so tireeeedddddd", "13:00");
        movieList.add(movie);

        movie = new ForumMessage("Ryan T", "aawww, he's so cute", "12:00");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ForumActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ForumActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
