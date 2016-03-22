package com.example.bishal.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbPrint;
    private TextView result;
    private Runnable mRunnable;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        moodResults = new String[] {
                "Someone is cranky!",
                "You are my sunshine!",
                "No comments...",
                "You're stressed out!",
                "Happy camper :)",
                "Not your day :(",
                "Smile - it's good for you.",
                "In the clouds...",
                "Pensive!",
                "Sad!",
                "Excited!",
                "Someone is happy today :)",
                "Take a break..",
                "Wow you are on fire :)"

        };

        thumbPrint = (ImageView) findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable) thumbPrint.getBackground();

        result = (TextView) findViewById(R.id.resultText);


        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                thumbAnimation.start();

                showResult();
                // Toast.makeText(getApplicationContext(), "Hellooo there", Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }

    public void showResult(){

        mRunnable = new Runnable() {
            @Override
            public void run() {

                int rand = (int) (Math.random() * moodResults.length);
                result.setText(moodResults[rand]);

                //stop animation
                thumbAnimation.stop();


            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 5000); // 5 seconds

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
