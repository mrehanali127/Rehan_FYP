package com.example.cdrapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cdrapplication.Models.Call;
import com.example.cdrapplication.Models.Contact;
import com.example.cdrapplication.Models.UserLocation;

import java.util.ArrayList;

public class DB_Managment extends SQLiteOpenHelper{

    public String name="CDRDatabase";
    public int version=1;
    public  static  String TABLE_NAME;

    public DB_Managment(Context context) {
        super(context, "CDRDatabase", null, 1);
       // TABLE_NAME=tableName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="CREATE TABLE Calls (Call_Orgin_Number varchar(255),Call_Dialed_Number varchar(255),IMSI varchar(255),IMEI varchar(255),Call_Start_DateTime varchar(255),Call_End_DateTime varchar(255),Inbound_Outbound varchar(255),Call_Network_Volume float(24),Cell_lac_Id float(24),Cell_site_Id float(24),Latitude float(24),Longitude float(24),Call_Type varchar(255),Location varchar(255));";
        Log.i("Rehan","CREATE QUERY : "+Query);
        db.execSQL(Query);
    }

    // Insert New Data
    public void addCall(Call call){
        String Query="insert into Calls values(" +
                "'"+call.getCallOriginNum()+"','"+call.getCallDialedNum()+"'," +
                "'"+call.getIMSI()+"','"+call.getIMEI()+"'," +
                "'"+call.getCallStartDateTime()+"','"+call.getCallEndDateTime() +"','"+call.getInboundOutbound()+"',"+call.getCallNetworkVolume()+"," +
                ""+call.getCellLacId()+","+call.getCellSiteId()+"," +
                ""+call.getLatitude()+","+call.getLongitude()+",'"+call.getCallType()+"','"+call.getLocation()+"')";
         //Log.i("Rehan"," INSERT Query :"+Query);
         SQLiteDatabase db=getWritableDatabase();
         db.execSQL(Query);
    }

    // Fetching All Data
    public ArrayList<Call> getAllCAlls(){
        ArrayList<Call> calls=new ArrayList<>();
        String Query="select * from Calls";
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(Query,null);
        int counter=0;
        if (cursor.moveToFirst()) {
           do{
                //Log.i("Rehan","getAll Calls: "+cursor.getString(2));
                String callOrigin = cursor.getString(0);
                String callDialed = cursor.getString(1);
                String IMSI = cursor.getString(2);
                String IMEI = cursor.getString(3);
                String callStart = cursor.getString(4);
                String callEnd = cursor.getString(5);
                String callInOut = cursor.getString(6);
                Double callVolume = cursor.getDouble(7);
                Double callLacId = cursor.getDouble(8);
                Double callSiteId = cursor.getDouble(9);
                Double Latitude = cursor.getDouble(10);
                Double Longitude = cursor.getDouble(11);
                String callType = cursor.getString(12);
                String location = cursor.getString(13);
                calls.add(new Call(callOrigin, callDialed, IMSI, IMEI, callStart, callEnd, callInOut, callVolume, callLacId,
                        callSiteId, Latitude, Longitude, callType, location));
                counter++;
            } while (cursor.moveToNext());
        }
        Log.i("Rehan","Total Entries "+counter);
        return calls;
    }

    public ArrayList<Integer> getCallSummary(){
        ArrayList<Integer> callsCounts=new ArrayList<>();
        String incoming="INCOMING";
        String outgoing="OUTGOING";
        String unknown="UNKNOWN";
        String allCalls="select * from Calls;";
        String incomingCalls="select * from Calls where Inbound_Outbound='INCOMING' and Call_Type='CALL';" ;
        String outgoingCalls="select * from Calls where Inbound_Outbound='OUTGOING' and Call_Type='CALL';" ;
        String incomingSMS="select * from Calls where Inbound_Outbound='INCOMING' and Call_Type='SMS';";
        String outgoingSMS="select * from Calls where Inbound_Outbound='OUTGOING' and Call_Type='SMS';";
        String incomingGSM="select * from Calls where Inbound_Outbound='INCOMING' and Call_Type='GSM';";
        String outgoinGSM="select * from Calls where Inbound_Outbound='OUTGOING' and Call_Type='GSM';";
        String unknownCalls="select * from Calls where Inbound_Outbound='UNKNOWN';" ;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery(allCalls,null);
        Cursor cursor1 = db.rawQuery(incomingCalls, null);
        Cursor cursor2=db.rawQuery(outgoingCalls,null);
        Cursor cursor3=db.rawQuery(incomingSMS,null);
        Cursor cursor4=db.rawQuery(outgoingSMS,null);
        Cursor cursor5=db.rawQuery(incomingGSM,null);
        Cursor cursor6=db.rawQuery(outgoinGSM,null);
        Cursor cursor7=db.rawQuery(unknownCalls,null);

        int count1 = cursor1.getCount();
        callsCounts.add(count1);
        Log.i("Rehan :","icoming :"+count1);
        int count2=cursor2.getCount();
        callsCounts.add(count2);
        Log.i("Rehan :","outgoing :"+count2);
        int count3=cursor3.getCount();
        callsCounts.add(count3);
        Log.i("Rehan :","In SMS :"+count3);
        int count4=cursor4.getCount();
        callsCounts.add(count4);
        int count5=cursor5.getCount();
        callsCounts.add(count5);
        int count6=cursor6.getCount();
        callsCounts.add(count6);
        int count7=cursor7.getCount();
        callsCounts.add(count7);
        int count=cursor.getCount();
        callsCounts.add(count);
        return callsCounts;
    }


    public ArrayList<Call> getSpecificCallBounds(String callBound,String CallType){
        String specificCall="select * from Calls where Inbound_Outbound='"+callBound+"' and Call_Type='"+CallType+"';" ;
        ArrayList<Call> calls=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(specificCall,null);
        if (cursor.moveToFirst()) {
            do{
                //Log.i("Rehan","getAll Calls: "+cursor.getString(2));
                String callOrigin = cursor.getString(0);
                String callDialed = cursor.getString(1);
                String IMSI = cursor.getString(2);
                String IMEI = cursor.getString(3);
                String callStart = cursor.getString(4);
                String callEnd = cursor.getString(5);
                String callInOut = cursor.getString(6);
                Double callVolume = cursor.getDouble(7);
                Double callLacId = cursor.getDouble(8);
                Double callSiteId = cursor.getDouble(9);
                Double Latitude = cursor.getDouble(10);
                Double Longitude = cursor.getDouble(11);
                String callType = cursor.getString(12);
                String location = cursor.getString(13);
                calls.add(new Call(callOrigin, callDialed, IMSI, IMEI, callStart, callEnd, callInOut, callVolume, callLacId,
                        callSiteId, Latitude, Longitude, callType, location));
            } while (cursor.moveToNext());
        }
        return calls;
    }


    public ArrayList<Call> getRecordofSpecificReciever(String callNum){
        String specificRecieverCalls="select * from Calls where Call_Dialed_Number='"+callNum+"';" ;
        ArrayList<Call> calls=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(specificRecieverCalls,null);
        if (cursor.moveToFirst()) {
            do{
                //Log.i("Rehan","getAll Calls: "+cursor.getString(2));
                String callOrigin = cursor.getString(0);
                String callDialed = cursor.getString(1);
                String IMSI = cursor.getString(2);
                String IMEI = cursor.getString(3);
                String callStart = cursor.getString(4);
                String callEnd = cursor.getString(5);
                String callInOut = cursor.getString(6);
                Double callVolume = cursor.getDouble(7);
                Double callLacId = cursor.getDouble(8);
                Double callSiteId = cursor.getDouble(9);
                Double Latitude = cursor.getDouble(10);
                Double Longitude = cursor.getDouble(11);
                String callType = cursor.getString(12);
                String location = cursor.getString(13);
                calls.add(new Call(callOrigin, callDialed, IMSI, IMEI, callStart, callEnd, callInOut, callVolume, callLacId,
                        callSiteId, Latitude, Longitude, callType, location));
            } while (cursor.moveToNext());
        }
        return calls;
    }









    public ArrayList<UserLocation> getLocations(){
        String locationsQuery="SELECT Location,COUNT(*) FROM Calls GROUP BY Location ORDER BY COUNT(*) DESC;" ;
        ArrayList<UserLocation> locations=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(locationsQuery,null);
        if (cursor.moveToFirst()) {
            do{
                String location = cursor.getString(0);
                Log.i("Rehan","Location :"+location);
                int frequency = cursor.getInt(1);
                Log.i("Rehan","Frequency :"+String.valueOf(frequency));
                locations.add(new UserLocation(location,frequency));
            } while (cursor.moveToNext());
        }
        return locations;

    }

    public ArrayList<Contact> mostProminentContacts(){
        String contactsQuery="SELECT Call_Orgin_Number,Call_Dialed_Number,COUNT(*) FROM Calls  GROUP BY Call_Orgin_Number,Call_Dialed_Number " +
                " ORDER BY COUNT(*) DESC;" ;
        ArrayList<Contact> contacts=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(contactsQuery,null);
        if (cursor.moveToFirst()) {
            do{
                String call_origin = cursor.getString(0);
                Log.i("Rehan","call_origing :"+call_origin);
                String call_dialed=cursor.getString(1);
                Log.i("Rehan","call Dialed :"+call_dialed);
                int frequency = cursor.getInt(2);
                Log.i("Rehan","Frequency :"+String.valueOf(frequency));
                contacts.add(new Contact(call_origin,call_dialed,frequency));
            } while (cursor.moveToNext());
        }
        return contacts;
    }


    public ArrayList<Call> getSpecificLocationDetails(String Location){
        String specificLocationDetails="select * from Calls where Location='"+Location+"';" ;
        ArrayList<Call> calls=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(specificLocationDetails,null);
        if (cursor.moveToFirst()) {
            do{
                //Log.i("Rehan","getAll Calls: "+cursor.getString(2));
                String callOrigin = cursor.getString(0);
                String callDialed = cursor.getString(1);
                String IMSI = cursor.getString(2);
                String IMEI = cursor.getString(3);
                String callStart = cursor.getString(4);
                String callEnd = cursor.getString(5);
                String callInOut = cursor.getString(6);
                Double callVolume = cursor.getDouble(7);
                Double callLacId = cursor.getDouble(8);
                Double callSiteId = cursor.getDouble(9);
                Double Latitude = cursor.getDouble(10);
                Double Longitude = cursor.getDouble(11);
                String callType = cursor.getString(12);
                String location = cursor.getString(13);
                calls.add(new Call(callOrigin, callDialed, IMSI, IMEI, callStart, callEnd, callInOut, callVolume, callLacId,
                        callSiteId, Latitude, Longitude, callType, location));
            } while (cursor.moveToNext());
        }
        return calls;
    }


    public ArrayList<Call> getDetailsOfConversation(String origin_num,String dialed_num){
        String conversationDetails="select * from Calls where Call_Orgin_Number='"+origin_num+"' and Call_Dialed_Number='"+dialed_num+"';" ;
        ArrayList<Call> calls=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(conversationDetails,null);
        if (cursor.moveToFirst()) {
            do{
                //Log.i("Rehan","getAll Calls: "+cursor.getString(2));
                String callOrigin = cursor.getString(0);
                String callDialed = cursor.getString(1);
                String IMSI = cursor.getString(2);
                String IMEI = cursor.getString(3);
                String callStart = cursor.getString(4);
                String callEnd = cursor.getString(5);
                String callInOut = cursor.getString(6);
                Double callVolume = cursor.getDouble(7);
                Double callLacId = cursor.getDouble(8);
                Double callSiteId = cursor.getDouble(9);
                Double Latitude = cursor.getDouble(10);
                Double Longitude = cursor.getDouble(11);
                String callType = cursor.getString(12);
                String location = cursor.getString(13);
                calls.add(new Call(callOrigin, callDialed, IMSI, IMEI, callStart, callEnd, callInOut, callVolume, callLacId,
                        callSiteId, Latitude, Longitude, callType, location));
            } while (cursor.moveToNext());
        }
        return calls;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Delete Previous Data
    public void deletePrevious(){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS Calls");
        onCreate(db);
    }


}
