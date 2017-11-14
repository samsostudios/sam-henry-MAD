package com.example.sam.lab5;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findCamera(View view){
        //spinner
        Spinner typeSpinner = (Spinner)findViewById(R.id.spinner);
        String cameraType = String.valueOf(typeSpinner.getSelectedItem());

        //radio buttons
        RadioGroup brand = (RadioGroup)findViewById(R.id.radioGroup);
        int brandId = brand.getCheckedRadioButtonId();

        //check boxes
        CheckBox entryLevelCheckBox = (CheckBox)findViewById(R.id.checkBox);
        Boolean entryLevel = entryLevelCheckBox.isChecked();

        CheckBox midRangeCheckBox = (CheckBox)findViewById(R.id.checkBox2);
        Boolean midRange = midRangeCheckBox.isChecked();

        CheckBox professionalCheckBox = (CheckBox)findViewById(R.id.checkBox3);
        Boolean professional = professionalCheckBox.isChecked();

        //image view
        ImageView imgView = (ImageView)findViewById(R.id.imageView);


        //resultTxt
        String resultTxt = "";


        //toast
        if(brandId == -1){
            Context context =getApplicationContext();
            CharSequence text = "Please Select Brand!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{
            if(cameraType.equals("DSLR")){
                switch (brandId){
                    case R.id.radioButton3:
                        if(entryLevelCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.canon6ti);
                            resultTxt = "Canon T6i";
                        }

                        if(midRangeCheckBox.isChecked() && entryLevelCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.canon80d);
                            resultTxt = "Canon 80d";
                        }
                        if(professionalCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && entryLevelCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.canon5d);
                            resultTxt = "Canon 5D mk. IV";
                        }
                        break;
                    case R.id.radioButton4:
                        if(entryLevelCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.nikond3300);
                            resultTxt = "Nikon D3300";
                        }
                        if(midRangeCheckBox.isChecked() && entryLevelCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.nikond7500);
                            resultTxt = "Nikon D7500";
                        }
                        if(professionalCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && entryLevelCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.nikon850);
                            resultTxt = "Nikon D850";
                        }
                        break;
                    case R.id.radioButton5:
                        resultTxt = "Please Choose Mirrorless!";
                        break;

                    default:
                        resultTxt = "Choose price level!";
                }
            }else{
                switch (brandId){
                    case R.id.radioButton3:
                        if(midRangeCheckBox.isChecked() && entryLevelCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.canonm5);
                            resultTxt = "Canon M5";
                        }
                        break;
                    case R.id.radioButton5:
                        if(entryLevelCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.sonya35);
                            resultTxt = "Sony A35";
                        }
                        if(midRangeCheckBox.isChecked() && entryLevelCheckBox.isChecked() ==  false && professionalCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.sonya6500);
                            resultTxt = "Sony A6500";
                        }
                        if(professionalCheckBox.isChecked() && midRangeCheckBox.isChecked() ==  false && entryLevelCheckBox.isChecked() == false){
                            imgView.setImageResource(R.drawable.sony7rii);
                            resultTxt = "Sony A7rii";
                        }
                        break;
                    default:
                        resultTxt = "Choose price level!";
                }
            }

            TextView result = (TextView)findViewById(R.id.textView2);
            result.setText(resultTxt);
        }
    }
}
