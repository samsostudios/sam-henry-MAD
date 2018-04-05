package com.example.sam.netflix_find;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NetflixMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix_main);

        AdapterView.OnItemClickListener itemClickeListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                String showtype = (String ) listView.getItemAtPosition(position);
                System.out.println(showtype);
                Intent intent = new Intent(NetflixMainActivity.this, ShowCategoryActivity.class);
                intent.putExtra("showtype", showtype);
                startActivity(intent);
            }

        };
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setOnItemClickListener(itemClickeListener);
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
