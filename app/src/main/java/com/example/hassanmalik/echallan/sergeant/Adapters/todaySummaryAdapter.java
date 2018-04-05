package com.example.hassanmalik.echallan.sergeant.Adapters;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Model.todaySummarymodel;

import java.util.List;


/**
 * Created by Hassan Malik on 3/29/2018.
 */
public class todaySummaryAdapter extends BaseAdapter {
    Activity activity;
        List<todaySummarymodel> users;
    LayoutInflater inflater;
    //Constructor
    public todaySummaryAdapter(Activity activity){
        this.activity= activity;
    }
    //Constructor
    public todaySummaryAdapter(Activity activity,List<todaySummarymodel> users )
    {
        this.activity = activity;
        this.users = users;
        inflater =  activity.getLayoutInflater();
        }
        @Override
         public int getCount() {
        return users.size();
    }
        @Override
         public Object getItem(int position) {
        return position;
    }
        @Override
         public long getItemId(int position) {
        return position;
    }
         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.todaysummaryadapter,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.totalChallan = (TextView)convertView.findViewById(R.id.textView14);
            viewHolder.paidChallan= (TextView)convertView.findViewById(R.id.textView19);
            viewHolder.unpaidChallan= (TextView)convertView.findViewById(R.id.textView21);
            viewHolder.totalAmount= (TextView)convertView.findViewById(R.id.textView23);
            viewHolder.totalPaidAmount= (TextView)convertView.findViewById(R.id.textView27);
            viewHolder.Impounded= (TextView)convertView.findViewById(R.id.textView34);
            viewHolder.underAge= (TextView)convertView.findViewById(R.id.textView36);
            viewHolder.vipTickets= (TextView)convertView.findViewById(R.id.textView41);
            convertView.setTag(viewHolder);

            todaySummarymodel model  = users.get(position);
            viewHolder.totalChallan.setText(model.getTotalChallan());
            viewHolder.paidChallan.setText(model.getPaidChallan());
            viewHolder.unpaidChallan.setText(model.getUnpaidChallan());
            viewHolder.totalAmount.setText(model.getTotalAmount());
            viewHolder.totalPaidAmount.setText(model.getTotalPaidAmount());
            viewHolder.Impounded.setText(model.getImpounded());
            viewHolder.underAge.setText(model.getUnderAge());
            viewHolder.vipTickets.setText(model.getVipTickets());
                }

        return convertView;
    }
    public  void updateRecords(List<todaySummarymodel> users){
        this.users = users;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView totalChallan,paidChallan,unpaidChallan,totalAmount,totalPaidAmount,Impounded,underAge,vipTickets;
    }
}


