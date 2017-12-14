package com.example.sam.bdgt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //income
    EditText incomeAmount;
    String incomeValue;

    //food
    EditText foodAmount;
    String foodValue;
    TextView remainingFoodValue;

    //rent
    EditText rentAmount;
    String rentValue;
    TextView remainingRentValue;

    //transit
    EditText transAmount;
    String transValue;
    TextView remainingTransitValue;

    //add item
    EditText itemAmount;
    String itemValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeAmount = (EditText) findViewById(R.id.incomeEnter);

        foodAmount = (EditText) findViewById(R.id.foodBudget);
        remainingFoodValue = (TextView) findViewById(R.id.remainingFood);

//        foodAmount.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                remainingFoodValue.setText(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        rentAmount = (EditText) findViewById(R.id.rentBudget);
        remainingRentValue = (TextView) findViewById(R.id.remainingRent);

        transAmount = (EditText) findViewById(R.id.transBudget);
        remainingTransitValue = (TextView) findViewById(R.id.remainingTransit);

        ImageView bgCircle = (ImageView)findViewById(R.id.imageView);

        itemAmount = (EditText) findViewById(R.id.enterItemAmount);
        itemValue = itemAmount.getText().toString();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);

        bgCircle.setImageDrawable(roundedBitmapDrawable);
    }

    public void getValues(View view){
        //income amount
        incomeValue = incomeAmount.getText().toString();

        if(TextUtils.isEmpty(incomeValue)){
            Context context =  getApplicationContext();
            CharSequence icomeToast = "Please Enter Income!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, icomeToast, duration);
            toast.show();
        }else{
            updateValues(view);
            //foodBudget
//            foodValue = foodAmount.getText().toString();

            //rent Budget
//            rentValue = rentAmount.getText().toString();

            //transit budget
//            transValue = transAmount.getText().toString();

            //remaining food
            //remainingFoodValue.setText(foodValue);

            //remaining rent
            remainingRentValue.setText(rentValue);

            //remainingTransit
            remainingTransitValue.setText(transValue);
        }
    }

    public void updateValues(View view){
        //spinner
        Spinner category = (Spinner) findViewById(R.id.spinner);
        Integer location = category.getSelectedItemPosition();

        switch (location){
            case 1:
                int n1 = Integer.parseInt(foodValue);
                int n2 = Integer.parseInt(itemValue);

                int n3 = n1 - n2;

                foodValue = String.valueOf(n3);

                remainingFoodValue.setText(foodValue);
        }
    }
}
