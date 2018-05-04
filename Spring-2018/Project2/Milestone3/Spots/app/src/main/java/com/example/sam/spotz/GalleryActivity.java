package com.example.sam.spotz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sam on 5/2/18.
 */

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    private Button webViewButton;
    private Button addlocation;
    private String incomingLocation;
    public ArrayList<String> newLocationList = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: Started");
        getIncomingIntent();
        Log.d(TAG, "add location: "+ incomingLocation);

        webViewButton = (Button) findViewById(R.id.galleryLocationButton);
        webViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "button pressed");
                Intent mapViewIntent = new Intent(GalleryActivity.this, MapViewActivity.class);
                mapViewIntent.putExtra("location", incomingLocation.toString());
                startActivity(mapViewIntent);
            }
        });

        addlocation = (Button) findViewById(R.id.addLocationButton);
        addlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "add button pressed");
                Log.d(TAG, "incoming location"+incomingLocation);

                updateNewLocList(incomingLocation);

//                RecyclerViewAdapter updateAdapter = new RecyclerViewAdapter();
//                updateAdapter.update();

           }
        });



    }

    public void updateNewLocList(String loc){
        String dummyLocaiton;

        switch (incomingLocation){
            case "Chautauqua Park":
                dummyLocaiton = "Chautauqua Park";
                newLocationList.add(loc);
                break;
            case "Loveland Pass":
                dummyLocaiton = "Loveland Pass";
                newLocationList.add(loc);
                break;
        }
        Log.d(TAG, "new location list "+ String.valueOf(newLocationList));
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("locationName")){

            String locationName = getIntent().getStringExtra("locationName");
            incomingLocation = locationName;
//            Log.d(TAG, "Location Name: "+locationName);


            setLocation(locationName);
        }
    }

    private void setLocation(String LocationName){
        Log.d(TAG, "Set Location Name: "+LocationName);

        TextView imgLocationDescription = (TextView) findViewById(R.id.galleryLocationDescription);

        ImageView imgLocationPhoto = (ImageView) findViewById(R.id.galleryImg);

        switch (LocationName){
            case "Chautauqua Park":
                imgLocationPhoto.setImageResource(R.drawable.flatironssm);
                imgLocationDescription.setText("Chautauqua Park is one of Boulder's best Attractions. Enjoy a nice " +
                        "hike under the beautiful Colorado sky!");
                break;
            case "Loveland Pass":
                imgLocationPhoto.setImageResource(R.drawable.loveland);
                imgLocationDescription.setText("Loveland Pass sits on the Continental Devide in the Colorado Rocky Mountains "+
                        "and has beautiful 360 degree views.");
                break;
            case "Kenosha Pass":
                imgLocationPhoto.setImageResource(R.drawable.kenosha);
                imgLocationDescription.setText("Kenosha Pass is located in Southern Colorado and has millions of Aspen Trees " +
                        "making it a sight to be seen in the Fall Season.");
                break;
            case "Boulder":
                imgLocationPhoto.setImageResource(R.drawable.boulder);
                imgLocationDescription.setText("Boulder Colorado is one of the most vibrant cities in the Colorado Metro Area. " +
                        "It is home to the University of Colorado, Boulder as well as some of best sights in the state.");
                break;
            case "Golden Gate Bridge":
                imgLocationPhoto.setImageResource(R.drawable.goldengate);
                imgLocationDescription.setText("The iconic Golden Gate Bridge should be on the top of everyone's bucketlist. The size is something " +
                        "no ones understand until they see it with their own eyes.");
                break;
            case "Bay Bridge":
                imgLocationPhoto.setImageResource(R.drawable.baybridge);
                imgLocationDescription.setText("Much like the Golden Gate Bridge the Bay Bridge is a spectacle itself. Be sure to view the views " +
                        "from Treasure Island.");
                break;
            case "Antelope Canyon":
                imgLocationPhoto.setImageResource(R.drawable.antelope);
                imgLocationDescription.setText("One of the most fascinating natural monuments in the world, Antelope Canyon is must for all photographers. " +
                        "Located in Northern Arizona this monument is not something to overlook.");
                break;
        }

        TextView imgLocationName = (TextView) findViewById(R.id.galleryLocationName);
        imgLocationName.setText(LocationName);

    }

}
