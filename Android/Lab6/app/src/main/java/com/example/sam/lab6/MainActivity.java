package com.example.sam.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private TripLocation myDestination = new TripLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button)findViewById(R.id.button);
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                findDestination(view);
            }
        };
        button.setOnClickListener(onclick);
    }

    public void findDestination(View view){
        //get spinner
        Spinner locationSpinner = (Spinner)findViewById(R.id.spinner2);
        Integer location = locationSpinner.getSelectedItemPosition();

        //get radio buttons
        RadioGroup priceLevel = (RadioGroup)findViewById(R.id.radioGroup);
        int price = priceLevel.getCheckedRadioButtonId();

        String suggestedDestenation = "";

        switch (price){
            case R.id.radioButton3:
                //set location
                myDestination.setDestination(location);
                suggestedDestenation = myDestination.getDestenation();
                break;
            case R.id.radioButton4:
                //set location
                myDestination.setDestination(location + 5);
                suggestedDestenation = myDestination.getDestenation();
        }

        //set URL
        String suggestedDestinationURL = myDestination.getURL();

        //log results
        Log.i("location: ", suggestedDestenation);
        Log.i("URL: ", suggestedDestinationURL);

        Intent intent = new Intent(this, receiveDestination.class);

        intent.putExtra("destinationName", suggestedDestenation);
        intent.putExtra("destinationURL", suggestedDestinationURL);

        startActivity(intent);
    }

}
