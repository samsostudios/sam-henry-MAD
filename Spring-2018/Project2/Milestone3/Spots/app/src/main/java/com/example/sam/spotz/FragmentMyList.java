package com.example.sam.spotz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 5/1/18.
 */

public class FragmentMyList extends Fragment {

    private final static String TAG = "FragmentMyList";

    View v;
    private RecyclerView listrecylerview;
    private List<Location> listLocation;
    private String incomingName;

    public FragmentMyList() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mylist_fragment, container, false);
        listrecylerview = (RecyclerView) v.findViewById(R.id.mylist_recyclerview);
        RecyclerViewAdapter ListRecyclerAdapter = new RecyclerViewAdapter(getContext(), listLocation);
        listrecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        listrecylerview.setAdapter(ListRecyclerAdapter);
        setNewLocation(incomingName);


//        if(getArguments() != null){
//            incomingName = getArguments().getString("location");
//
//        }


        Log.d(TAG, "new Loc: "+incomingName);
        return v;
    }

    public void setNewLocation(String name){
        incomingName = name;
        Log.d(TAG, "new Loc: "+incomingName);

        listLocation = new ArrayList<>();
        listLocation.add(new Location("Loveland Pass", R.drawable.loveland));
        Log.d(TAG, "listlocation: "+listLocation.get(0));
        listrecylerview.invalidate();

//        if(incomingName == "Loveland Pass"){
//
//
//        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        listLocation = new ArrayList<>();
        listLocation.add(new Location("Chautauqua Park", R.drawable.flatironssm));


    }

    public void getIcomingIntent(){

    }
}
