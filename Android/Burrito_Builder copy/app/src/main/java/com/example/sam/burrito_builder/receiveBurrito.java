package com.example.sam.burrito_builder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class receiveBurrito extends AppCompatActivity {
    private String location;
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_burrito);

        Intent intent = getIntent();
        location = intent.getStringExtra("location");
        website = intent.getStringExtra("locationSite");

        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText("You should try " + location);
    }
}
