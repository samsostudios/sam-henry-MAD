package com.example.sam.lab6;

import android.net.Uri;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class receiveDestination extends AppCompatActivity {
    private String location;
    private String locationPics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_destination);

        Intent intent = getIntent();
        location = intent.getStringExtra("destinationName");
        locationPics = intent.getStringExtra("destinationURL");

        TextView messageView = (TextView)findViewById(R.id.textView3);
        messageView.setText("You should look in to " + location);

        final ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton3);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                loadURL(view);
            }
        };

        imageButton.setOnClickListener(onclick);
    }

    public void loadURL(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(locationPics));
        startActivity(intent);
    }
}
