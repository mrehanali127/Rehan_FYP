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
import com.example.cdrapplication.Models.Contact;
import com.example.cdrapplication.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
    private int template;
    Context context;
    private ArrayList<Contact> contacts;
    DB_Managment database_manager;

    public ContactAdapter(Context context, int template, ArrayList<Contact> contacts) {
        this.context=context;
        this.template = template;
        this.contacts = contacts;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(template,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact=contacts.get(position);
        holder.call_origin.setText(contact.getCallOrigin());
        holder.call_dialed.setText(contact.getCallDialed());
        holder.frequency.setText(String.valueOf(contact.getFrequency()));
        database_manager = new DB_Managment(context);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), CallDetails.class);
                intent.putExtra("origin", contacts.get(position).getCallOrigin());
                intent.putExtra("dialed",contacts.get(position).getCallDialed());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView call_origin,call_dialed,frequency;
        CardView card;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            call_origin=itemView.findViewById(R.id.call_origin_num);
            call_dialed=itemView.findViewById(R.id.calls_dialed_num);
            frequency=itemView.findViewById(R.id.calls_contact_frequency);
            card=itemView.findViewById(R.id.contactContainer);
            view=itemView;
        }
    }

}
