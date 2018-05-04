package com.example.sam.spotz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 5/1/18.
 */

public class FragmentLocations extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Location> listLocation;

    public FragmentLocations() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.locations_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.location_recyclerview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), listLocation);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listLocation = new ArrayList<>();
        listLocation.add(new Location("Chautauqua Park", R.drawable.flatironssm));
        //Log.d("Location Frag" , "list locaton:"+listLocation);
        listLocation.add(new Location("Loveland Pass", R.drawable.loveland));
        listLocation.add(new Location("Kenosha Pass", R.drawable.kenosha));
        listLocation.add(new Location("Boulder", R.drawable.boulder));
        listLocation.add(new Location("Golden Gate Bridge", R.drawable.goldengate));
        listLocation.add(new Location("Bay Bridge", R.drawable.baybridge));
        listLocation.add(new Location("Antelope Canyon", R.drawable.antelope));
    }
}
