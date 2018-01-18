package com.example.sam.burrito_builder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private burritoLocation myBurrito = new burritoLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button)findViewById(R.id.findBtn);
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                findBurrito(view);
            }
        };
        button.setOnClickListener(onclick);

    }

    public void makeBurrito (View view){
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


        //check boxes
        CheckBox guacCB = (CheckBox)findViewById(R.id.guacCheck);
        boolean guac = guacCB.isChecked();
        String guaxTxt = "";
        if(guac == true){
            guaxTxt = "Guacamole ";
        }

        CheckBox cheeseCB = (CheckBox)findViewById(R.id.cheeseCheck);
        boolean cheese = cheeseCB.isChecked();
        String cheeseTxt = "";
        if(cheese == true){
            cheeseTxt = "Cheese ";
        }

        CheckBox lettuceCB = (CheckBox)findViewById(R.id.lettuceCheck);
        boolean lettuce =  lettuceCB.isChecked();
        String lettuceTxt = "";
        if(lettuce ==  true){
            lettuceTxt = "Lettuce ";
        }

        CheckBox creamCB = (CheckBox)findViewById(R.id.creamCheck);
        boolean cream = creamCB.isChecked();
        String creamTxt = "";
        if(cream == true){
            creamTxt = "Sour Cream";
        }

        //img
        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        String out = "";

        if(burritoName == "" || foodSelected == -1){
            Context context = getApplicationContext();
            CharSequence txt = "Please select either Burrito or Tacos!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, txt, duration);
            toast.show();
        }else{

            if (foodSelected == R.id.burittoRadio){
                imageView.setImageResource(R.drawable.burrito);
                if(meatType == true){
                    out = "Meat Burrito";
                }else{
                    out = "Veggie burrito";
                }
            }
            if(foodSelected == R.id.tacoRadio){
                imageView.setImageResource(R.drawable.taco);
                if(meatType == true){
                    out = "Meat Taco";
                }
                else{
                    out = "Veggie Taco";
                }
            }
            textView.setText("The " + burritoName + " is a " + out + " made with " + guaxTxt + cheeseTxt + lettuceTxt + creamTxt);
        }
    }

    public void findBurrito(View view){

        //spinner
        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        Integer location = spinner.getSelectedItemPosition();


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
