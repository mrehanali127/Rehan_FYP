package com.example.cdrapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.R;

import java.util.ArrayList;

public class CallsCountsFragments extends Fragment {

    ArrayList<Integer> callsCounts=new ArrayList<>();
    DB_Managment databaseManager;
    TextView inCall,outCall,inSMS,outSMS,inGSM,outGSM,other,total;

    public CallsCountsFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calls_counts_fragments, container, false);
        inCall=view.findViewById(R.id.icomingCalls);
        outCall=view.findViewById(R.id.outgoingCalls);
        inSMS=view.findViewById(R.id.incomingSMS);
        outSMS=view.findViewById(R.id.outgoingSMS);
        inGSM=view.findViewById(R.id.incomingGSM);
        outGSM=view.findViewById(R.id.outgoingGSM);
        other=view.findViewById(R.id.others);
        total=view.findViewById(R.id.total);
        databaseManager=new DB_Managment(getContext());
        callsCounts=databaseManager.getCallSummary();


        Log.i("Rehan","What's here");
        inCall.setText(String.valueOf(callsCounts.get(0)));
        outCall.setText(String.valueOf(callsCounts.get(1)));
        inSMS.setText(String.valueOf(callsCounts.get(2)));
        outSMS.setText(String.valueOf(callsCounts.get(3)));
        inGSM.setText(String.valueOf(callsCounts.get(4)));
        outGSM.setText(String.valueOf(callsCounts.get(5)));
        other.setText(String.valueOf(callsCounts.get(6)));
        total.setText(String.valueOf(callsCounts.get(7)));
        return view;
    }
}