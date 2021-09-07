package com.example.cdrapplication.Fragments;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cdrapplication.Adapters.CallAdapter;
import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.Models.Call;
import com.example.cdrapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    Button uploadBtn;
    public static int myRequestCode = 1;
    public static int REQUEST_PERMISSION = 100;
    public static String userContact="dummy";
    DB_Managment databaseManager;
    ArrayList<Call> calls = new ArrayList<>();
    RecyclerView recyclerView;
    private CallAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.callsRecyclerView);
        uploadBtn=view.findViewById(R.id.uploadbtn);
        databaseManager = new DB_Managment(getContext());
        getCallRecord();
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.deletePrevious();
                filePicker();

            }
        });



        return view;
    }

    public void getCallRecord() {
        calls = new ArrayList<>(databaseManager.getAllCAlls());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CallAdapter(getContext(),R.layout.call_detail_item, calls);
        recyclerView.setAdapter(adapter);
    }

    public void filePicker() {
        Intent fileIntent = new Intent(getContext(),FilePickerActivity.class);
        fileIntent.putExtra(FilePickerActivity.CONFIGS,
                new Configurations.Builder()
                        .setCheckPermission(true)
                        .setShowFiles(true)
                        .setShowImages(false)
                        .setShowVideos(false)
                        .setMaxSelection(1)
                        .setSuffixes("txt", "csv", "pdf", "docx")
                        .setSkipZeroSizeFiles(true)
                        .build()
        );
        startActivityForResult(fileIntent, myRequestCode);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {

            ArrayList<MediaFile> mediaFiles = data.getParcelableArrayListExtra(
                    FilePickerActivity.MEDIA_FILES
            );
            String filePath = mediaFiles.get(0).getPath();
            switch (requestCode) {
                case 1:
                    //msg.setText(filePath);
                    Toast.makeText(getContext(), "File Path :" + filePath, Toast.LENGTH_LONG).show();
                    try {
                        FileReader file = new FileReader(filePath);
                        BufferedReader buffer = new BufferedReader(file);
                        ContentValues contentValues = new ContentValues();

                        String line = "";
                        int skipper = 0;
                        String[] str;
                        String callOrigin,callDialNum,IMSI,IMEI,callStart,callEnd,inboundOutbound;
                        Double callNetworkVolume,cellLacId,cellSiteId,Latitude,Longitude;
                        String callType;
                        String location;
                        while ((line = buffer.readLine()) != null) {
                            //Log.i("Row", line);
                            if (skipper == 0) {
                                skipper++;
                                continue;
                            }

                            if(skipper==1){
                                String[] line1 = line.split(",", 15);
                                userContact=line1[0].toString();
                                //databaseManager=new DB_Managment(this,tableName);
                                skipper++;
                            }
                            str = line.split(",", 15);
                            callOrigin = str[1];
                            callDialNum = str[2];
                            IMSI = str[3];
                            IMEI = str[4];
                            callStart = str[5];
                            callEnd = str[6];
                            inboundOutbound = str[7];
                            callNetworkVolume = parseStringToDouble(str[8],0);
                            cellLacId = parseStringToDouble(str[9],0);
                            cellSiteId = parseStringToDouble(str[10],0);
                            Latitude = parseStringToDouble(str[11], 0);
                            Longitude = parseStringToDouble(str[12], 0);
                            callType = str[13];
                            location = str[14];

                            Call newCall = new Call(callOrigin, callDialNum, IMSI, IMEI,
                                    callStart, callEnd, inboundOutbound, callNetworkVolume,
                                    cellLacId, cellSiteId, Latitude, Longitude, callType, location);
                            databaseManager.addCall(newCall);
                        }
                        getCallRecord();

                    } catch (IOException e) {
                        Log.e("IOExcepyion,", e.getMessage().toString());
                    }

            }
        }
    }


    private static double parseStringToDouble(String value, double defaultValue) {
        return value == null || value.isEmpty() ? defaultValue : Double.parseDouble(value);
    }


}