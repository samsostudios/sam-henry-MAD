package com.example.sam.bdgt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    String foodResult;

    //rent
    EditText rentAmount;
    String rentValue;
    TextView remainingRentValue;
    String rentResult;

    //transit
    EditText transAmount;
    String transValue;
    TextView remainingTransitValue;
    String transResult;

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
        foodAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remainingFoodValue.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rentAmount = (EditText) findViewById(R.id.rentBudget);
        remainingRentValue = (TextView) findViewById(R.id.remainingRent);
        rentAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remainingRentValue.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        transAmount = (EditText) findViewById(R.id.transBudget);
        remainingTransitValue = (TextView) findViewById(R.id.remainingTransit);
        transAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remainingTransitValue.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //circle
        ImageView bgCircle = (ImageView)findViewById(R.id.imageView);

        itemAmount = (EditText) findViewById(R.id.enterItemAmount);
        itemValue = itemAmount.getText().toString();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);

        bgCircle.setImageDrawable(roundedBitmapDrawable);
    }


    public void updateValues(View view){
        incomeValue = incomeAmount.getText().toString();
        //spinner
        Spinner category = (Spinner) findViewById(R.id.spinner);
        Integer location = category.getSelectedItemPosition();

        int result;

        if (TextUtils.isEmpty(incomeValue)) {
            Context context = getApplicationContext();
            CharSequence icomeToast = "Please Enter Income!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, icomeToast, duration);
            toast.show();
        }else{
            int foodInt;
            foodValue = foodAmount.getText().toString();
            if(TextUtils.isEmpty(foodValue)){
                foodInt = 0;
            }else{
                foodInt = Integer.parseInt(foodValue);
            }

            int rentInt;
            rentValue = rentAmount.getText().toString();
            if(TextUtils.isEmpty(rentValue)){
                rentInt = 0;
            }else{
                rentInt = Integer.parseInt(rentValue);
            }

            int transInt;
            transValue = transAmount.getText().toString();
            if(TextUtils.isEmpty(transValue)){
                transInt = 0;
            }else{
                transInt = Integer.parseInt(transValue);
            }

            itemValue = itemAmount.getText().toString();
            int itemInt;
            if(TextUtils.isEmpty(itemValue)){
                itemInt = 0;
            }else{
                itemInt = Integer.parseInt(itemValue);
            }

            switch (location){
                case 0:
                    result = foodInt - itemInt;
                    foodResult = String.valueOf(result);
                    remainingFoodValue.setText(foodResult);
                    break;
                case 1:
                    result = rentInt - itemInt;
                    rentResult = String.valueOf(result);
                    remainingRentValue.setText(rentResult);
                    break;
                case 2:
                    result = transInt - itemInt;
                    transResult = String.valueOf(result);
                    remainingTransitValue.setText(transResult);
                    break;
                    default:
                        remainingFoodValue.setText(foodResult);
                        remainingRentValue.setText(rentResult);
                        remainingTransitValue.setText(transResult);

            }
        }
    }
}
