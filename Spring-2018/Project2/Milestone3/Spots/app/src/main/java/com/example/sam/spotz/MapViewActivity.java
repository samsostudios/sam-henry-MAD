package com.example.sam.spotz;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Sam on 5/2/18.
 */

public class MapViewActivity extends Activity {

    public static final String TAG = "MapViewActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("location")){

            String locationName = getIntent().getStringExtra("location");
//            Log.d(TAG, "Location Name: "+locationName);


            setTextField(locationName);
        }
    }

    public void setTextField(String string){
        TextView textView = (TextView) findViewById(R.id.location_textview);
        textView.setText(string);
    }
}
