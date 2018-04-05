package com.example.sam.netflix_find;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;

public class ShowCategoryActivity extends ListActivity {

    private String showtype;
    int myNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        showtype = i.getStringExtra("showtype");

        ListView listShows = getListView();
        ArrayAdapter<shows>listAdapter;

         switch (showtype){
             case "TV Shows":
                 listAdapter = new ArrayAdapter<shows>(this, android.R.layout.simple_list_item_1, shows.tvshows);
                 myNum = 1;
                 break;
             case "Movies":
                 listAdapter = new ArrayAdapter<shows>(this, android.R.layout.simple_list_item_1, shows.movies);
                 myNum = 2;
                 break;
             case "Documentaries":
                 listAdapter = new ArrayAdapter<shows>(this, android.R.layout.simple_list_item_1, shows.documentaries);
                 myNum = 3;
                 break;
             default:
                 listAdapter = new ArrayAdapter<shows>(this, android.R.layout.simple_list_item_1, shows.tvshows);
                 myNum = 1;
         }
         listShows.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(ShowCategoryActivity.this, ShowActivity.class);
        intent.putExtra("showID", (int)id);
        intent.putExtra("showNum", myNum);
        startActivity(intent);
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
