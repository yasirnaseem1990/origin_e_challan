package com.example.hassanmalik.echallan.sergeant.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Model.ListViewModel;

import java.util.List;

public class customListAdapterSel extends BaseAdapter {

    Activity activity;
    List<ListViewModel> users;
    LayoutInflater inflater;

    public customListAdapterSel(Activity activity){
        this.activity=activity;
    }
    public customListAdapterSel(Activity activity,List<ListViewModel> users){
        this.activity=activity;
        this.users = users;
        inflater= activity.getLayoutInflater();
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
                convertView = inflater.inflate(R.layout.listview_adapter,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.violatorType = (TextView)convertView.findViewById(R.id.textView13);
                viewHolder.challanAmount= (TextView)convertView.findViewById(R.id.textView15);
                viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.checkBoxlist);
                convertView.setTag(viewHolder);

                ListViewModel model = users.get(position);
                viewHolder.violatorType.setText(model.getViolationType());
                viewHolder.challanAmount.setText(model.getChallanAmount());
                }
                else {
                viewHolder =(ViewHolder)convertView.getTag();
                ListViewModel model = users.get(position);
                viewHolder.violatorType.setText(model.getViolationType());
                viewHolder.challanAmount.setText(model.getChallanAmount());

                }
                return convertView;
                }
            public  void updateRecords(List<ListViewModel> users){
            this.users = users;
                notifyDataSetChanged();
                    }
             class ViewHolder{
            TextView violatorType,challanAmount;
            CheckBox checkBox;
            }
            }
