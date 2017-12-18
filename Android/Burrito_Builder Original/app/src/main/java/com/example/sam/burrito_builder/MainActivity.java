package com.example.sam.burrito_builder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private burritoLocation myBurrito = new burritoLocation();
    //check boxes
    CheckBox guacCheckBox;
    String guacTxt;

    CheckBox cheeseCheckBox;
    String cheeseTxt;

    CheckBox lettuceCheckBox;
    String lettuceTxt;

    CheckBox creamCheckBox;
    String creamTxt;


;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guacCheckBox = (CheckBox)findViewById(R.id.guacCheck);
        guacCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(guacCheckBox.isChecked()){
                    guacTxt = " Guacamole ";
                }else{
                    guacTxt = "";
                }

            }
        });

        cheeseCheckBox = (CheckBox)findViewById(R.id.cheeseCheck);
        cheeseCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cheeseTxt = " Cheese ";
            }
        });

        lettuceCheckBox = (CheckBox)findViewById(R.id.lettuceCheck);
        lettuceCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                lettuceTxt = " Lettuce ";
            }
        });

        creamCheckBox = (CheckBox)findViewById(R.id.creamCheck);
        creamCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                creamTxt = " Sour Cream ";
            }
        });

        final Button sendButton = (Button)findViewById(R.id.button2);
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                findBurrito(view);
            }
        };
        sendButton.setOnClickListener(onclick);
    }

    public void findBurrito(View view){
        //text input
        EditText burrito = (EditText)findViewById(R.id.editText2);
        String burritoName = burrito.getText().toString();

        //text View
        TextView textView = (TextView)findViewById(R.id.textView3);

        //toggle
        ToggleButton typeToggle = (ToggleButton)findViewById(R.id.toggleButton);
        boolean meatType = typeToggle.isChecked();

        //radio buttons
        RadioGroup foodtype = (RadioGroup)findViewById(R.id.radioGroup);
        int foodSelected = foodtype.getCheckedRadioButtonId();

        //img
        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        CheckBox creamCheckBox = (CheckBox)findViewById(R.id.creamCheck);
        boolean cream = creamCheckBox.isChecked();

        //spinner
        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        Integer location = spinner.getSelectedItemPosition();

        String bt = "";

        if(foodSelected == -1){
            Context context = getApplicationContext();
            CharSequence txt = "Please select either Burrito or Tacos!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, txt, duration);
            toast.show();
        }else{
            switch (foodSelected){
                case 0:
                    imageView.setImageResource(R.drawable.burrito);
                    if(meatType == true){
                        bt = "Meat Burrito";
                    }else{
                        bt = "Meat Taco";
                    }
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.taco);
                    if(meatType == false){
                        bt = "Veggie Burrito";
                    }else{
                        bt = "Veggie Taco";
                    }
                    break;
            }
        }

        textView.setText("The " + burritoName + " is a " + bt + "with " + guacTxt + cheeseTxt + lettuceTxt + creamTxt);

        //set location
        myBurrito.setLocation(location);
        String suggestedBurritoLoaction = myBurrito.getLocation();
        //set url
        String suggestedBurritoWebsite = myBurrito.getWebsite();


        Intent intent = new Intent(this, receiveBurrito.class);

        intent.putExtra("location", suggestedBurritoLoaction);
        intent.putExtra("locationSite", suggestedBurritoWebsite);

        startActivity(intent);
    }

}
