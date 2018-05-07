package com.example.sam.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutCategoryActivity extends ListActivity {

    private String worktype;
    int myNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        worktype = i.getStringExtra("worktype");

        ListView listWork = getListView();
        ArrayAdapter<Workout>listAdapter;

        switch (worktype){
            case "Cardio":
                listAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, Workout.Cardio);
                myNum = 1;
                break;
            case "Strength":
                listAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, Workout.Strength);
                myNum = 2;
                break;
            case "Flexibility":
                listAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, Workout.Flexibility);
                myNum = 3;
                break;
            default:
                listAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, Workout.Cardio);
                myNum = 1;

        }
        listWork.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String exercise = (String) l.getItemAtPosition(position).toString();
        Intent intent = new Intent(WorkoutCategoryActivity.this, WebViewActivity.class);
        intent.putExtra("workOut", exercise);
        startActivity(intent);
    }
}
