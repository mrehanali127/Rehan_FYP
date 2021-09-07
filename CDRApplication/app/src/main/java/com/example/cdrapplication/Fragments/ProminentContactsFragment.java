package com.example.cdrapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cdrapplication.Adapters.ContactAdapter;
import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.Models.Contact;
import com.example.cdrapplication.R;

import java.util.ArrayList;


public class ProminentContactsFragment extends Fragment {

    ArrayList<Contact> contacts=new ArrayList<>();
    DB_Managment databaseManager;
    String userContact;
    RecyclerView recyclerView;
    ContactAdapter adapter;
    public ProminentContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_prominent_contacts, container, false);
        recyclerView=view.findViewById(R.id.contactsRecyclerView);
        databaseManager=new DB_Managment(getContext());
        getContacts();
        return view;
    }

    public void getContacts(){
        contacts = new ArrayList<>(databaseManager.mostProminentContacts());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ContactAdapter(getContext(), R.layout.contact_item, contacts);
        recyclerView.setAdapter(adapter);
    }
}