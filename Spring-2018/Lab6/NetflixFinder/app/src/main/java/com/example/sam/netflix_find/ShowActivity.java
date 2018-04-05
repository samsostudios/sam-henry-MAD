package com.example.sam.netflix_find;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;

public class ShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        setContentView(R.layout.activity_show);


        shows show;

        int showID = (Integer)getIntent().getExtras().get("showID");
        int showNum = (Integer)getIntent().getExtras().get("showNum");

        if (showNum == 1){
            show = shows.tvshows[showID];
        }
        else if (showNum == 2){
            show = shows.movies[showID];
        }
        else{
            show = shows.documentaries[showID];
        }


        ImageView showImage = (ImageView) findViewById(R.id.showImageView);
        showImage.setImageResource(show.getImageID());

        TextView showName = (TextView)findViewById(R.id.tshow_name);
        showName.setText(show.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.watch_now:
                //start order activity
                Intent intent = new Intent(this, WatchActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
