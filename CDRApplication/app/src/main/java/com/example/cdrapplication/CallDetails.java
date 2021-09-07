package com.example.cdrapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cdrapplication.Adapters.CallAdapter;
import com.example.cdrapplication.Models.Call;

import java.util.ArrayList;

public class CallDetails extends AppCompatActivity {

    TextView header;
    RecyclerView recyclerView;
    String locationName;
    String callOrigin;
    String callDialed;
    ArrayList<Call> specificCalls=new ArrayList<>();
    DB_Managment databaseManager;
    private CallAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_detail);
        //Intent i = getIntent();
        recyclerView=findViewById(R.id.specificLocationRecyclerView);
        header=findViewById(R.id.locationName2);
        databaseManager=new DB_Managment(this);
        Bundle extras = getIntent().getExtras();
        int num=getIntent().getExtras().size();
        if(num==1){
            locationName=extras.getString("location");
            header.setText(locationName);
            getCallDetails();
        }
        else if(num==2){
            callOrigin=extras.getString("origin");
            callDialed=extras.getString("dialed");
            header.setText(callOrigin+"-->"+callDialed);
            getConversation();

        }


    }



    public void getCallDetails(){
        specificCalls = new ArrayList<>(databaseManager.getSpecificLocationDetails(locationName));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CallAdapter(getApplicationContext(),R.layout.call_detail_item, specificCalls);
        recyclerView.setAdapter(adapter);
    }

    public void getConversation(){
        specificCalls = new ArrayList<>(databaseManager.getDetailsOfConversation(callOrigin,callDialed));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CallAdapter(getApplicationContext(),R.layout.call_detail_item, specificCalls);
        recyclerView.setAdapter(adapter);
    }
}