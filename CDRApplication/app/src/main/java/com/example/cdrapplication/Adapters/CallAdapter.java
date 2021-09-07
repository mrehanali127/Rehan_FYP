package com.example.cdrapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cdrapplication.DB_Managment;
import com.example.cdrapplication.Models.Call;
import com.example.cdrapplication.R;

import java.util.ArrayList;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.MyViewHolder>{
    Context context;
    int template;
    private ArrayList<Call> calls;
    DB_Managment database_manager;
    String tableName;

    public CallAdapter(Context context,int template, ArrayList<Call> calls) {
        this.context=context;
        this.template=template;
        this.calls = calls;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(template,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Call call=calls.get(position);
        holder.call_origin.setText(call.getCallOriginNum());
        holder.call_dialed.setText(call.getCallDialedNum());
        holder.IMEI.setText(call.getIMEI());
        holder.startDateTime.setText(call.getCallStartDateTime());
        holder.endDateTime.setText(call.getCallEndDateTime());
        holder.CallType.setText(call.getCallType());
        holder.InOut.setText(call.getInboundOutbound());
        holder.Location.setText(call.getLocation());
        database_manager = new DB_Managment(context);

        /*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),QuestionActivity.class);
                intent.putExtra("DATE", quizzes.get(position).title);
                v.getContext().startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return calls.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView call_origin;
        TextView call_dialed,IMEI,startDateTime,endDateTime,CallType,InOut,Location;
        CardView card;
        View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            call_origin=itemView.findViewById(R.id.callOrigin);
            call_dialed=itemView.findViewById(R.id.callDialed);
            IMEI=itemView.findViewById(R.id.IMEI);
            startDateTime=itemView.findViewById(R.id.startTime);
            endDateTime=itemView.findViewById(R.id.endTime);
            CallType=itemView.findViewById(R.id.callType);
            InOut=itemView.findViewById(R.id.inboundOutbound);
            Location=itemView.findViewById(R.id.location);
            card=itemView.findViewById(R.id.callRecordContainer);
            view=itemView;
        }
    }

}
