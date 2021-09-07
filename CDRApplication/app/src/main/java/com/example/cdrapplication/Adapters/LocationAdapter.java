package com.example.cdrapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cdrapplication.CallDetails;
import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.Models.UserLocation;
import com.example.cdrapplication.R;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder>{
    private int template;
    Context context;
    private ArrayList<UserLocation> locations;
    DB_Managment database_manager;

    public LocationAdapter(Context context, int template, ArrayList<UserLocation> locations) {
        this.context=context;
        this.template = template;
        this.locations = locations;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(template,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UserLocation location=locations.get(position);
        holder.locationName.setText(location.getLocationName());
        holder.frequency.setText(String.valueOf(location.getFrequency()));
        database_manager = new DB_Managment(context);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), CallDetails.class);
                intent.putExtra("location", locations.get(position).getLocationName());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView locationName,frequency;
        CardView card;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            locationName=itemView.findViewById(R.id.locationName);
            frequency=itemView.findViewById(R.id.callsFrequency);
            card=itemView.findViewById(R.id.callRecordContainer);
            view=itemView;
        }
    }

}
