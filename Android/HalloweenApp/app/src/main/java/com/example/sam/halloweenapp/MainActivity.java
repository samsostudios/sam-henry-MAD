package com.example.sam.halloweenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayBoo(View view) {
        //text view change
        TextView booText = (TextView)findViewById(R.id.message);

        //edit text
        EditText name = (EditText)findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        //image
        ImageView jacko = (ImageView)findViewById(R.id.imageView);
        jacko.setImageResource(R.drawable.jacko);

        //set text field to string from text change and name from edit text
        booText.setText("Happy Halloween " + nameValue + "!");
    }
}
