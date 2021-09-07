package com.example.cdrapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cdrapplication.Adapters.LocationAdapter;
import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.Models.UserLocation;
import com.example.cdrapplication.R;

import java.util.ArrayList;


public class LocationsFragment extends Fragment {

    ArrayList<UserLocation> locations=new ArrayList<>();
    DB_Managment databaseManager;
    RecyclerView recyclerView;
    LocationAdapter adapter;

    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_locations, container, false);
        recyclerView=view.findViewById(R.id.locationsRecyclerView);
        databaseManager=new DB_Managment(getContext());
        getLocations();
        return view;
    }

    public void getLocations(){
        locations = new ArrayList<>(databaseManager.getLocations());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new LocationAdapter(getContext(), R.layout.location_item, locations);
        recyclerView.setAdapter(adapter);
    }
}