package com.example.hassanmalik.echallan.sergeant.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Model.handOverToBranchModel;

import java.util.List;

/**
 * Created by Hassan Malik on 4/2/2018.
 */
public class handOverTobAdapter extends BaseAdapter {
    Activity activity;
    List<handOverToBranchModel> users;
    LayoutInflater inflater;

    public handOverTobAdapter(Activity activity){
        this.activity = activity;
    }
    public handOverTobAdapter(Activity activity, List<handOverToBranchModel> users){
        this.activity = activity;
        this.users = users;
        inflater = activity.getLayoutInflater();
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
    public View getView(int position, View convertView, ViewGroup parent){
    ViewHolder viewHolder =null;
            if (convertView == null){
        convertView = inflater.inflate(R.layout.handovertobranchadapter,parent,false);
        viewHolder = new ViewHolder();
        viewHolder.Challan_date = (TextView)convertView.findViewById(R.id.textView57);
        viewHolder.eTicketid= (TextView)convertView.findViewById(R.id.textView58);
        viewHolder.Violatorname = (TextView)convertView.findViewById(R.id.textView59);
        viewHolder.Zone= (TextView)convertView.findViewById(R.id.textView60);
        convertView.setTag(viewHolder);
        handOverToBranchModel model = users.get(position);
        viewHolder.Challan_date.setText(model.getChallan_date());
        viewHolder.eTicketid.setText(model.geteTicketid());
        viewHolder.Violatorname.setText(model.getViolatorname());
        viewHolder.Zone.setText(model.getZone());

    }
            return convertView;
}
    public  void updateRecords(List<handOverToBranchModel> users){
        this.users = users;
        notifyDataSetChanged();
    }
class ViewHolder{
    TextView Challan_date,eTicketid,Violatorname,Zone;
}
}
