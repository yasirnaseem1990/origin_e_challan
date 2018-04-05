package com.example.hassanmalik.echallan.sergeant.Adapters;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Model.challanDetailsModel;

import java.util.List;
/**
 * Created by Hassan Malik on 4/2/2018.
 */
public class reviewChallanAdapter extends BaseAdapter {
    Activity activity;
    List<challanDetailsModel> users;
    LayoutInflater inflater;
    //Deafault constructor
    public  reviewChallanAdapter(Activity activity){
        this.activity = activity;
    }
    //Constructor
    public reviewChallanAdapter(Activity activity, List<challanDetailsModel> users){
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder =null;

            if (convertView == null){
                convertView = inflater.inflate(R.layout.reviewchallanadapter,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.ViolatorName = (TextView)convertView.findViewById(R.id.textView38);
                viewHolder.ViolatorCnic= (TextView)convertView.findViewById(R.id.textView31);
                viewHolder.Documenttype = (TextView)convertView.findViewById(R.id.textView29);
                viewHolder.Totalpayable= (TextView)convertView.findViewById(R.id.textView25);
                viewHolder.offensecode = (TextView)convertView.findViewById(R.id.textView61);
                viewHolder.violation= (TextView)convertView.findViewById(R.id.textView63);
                viewHolder.fine= (TextView)convertView.findViewById(R.id.textView69);

                convertView.setTag(viewHolder);

                challanDetailsModel model = users.get(position);
                viewHolder.ViolatorName.setText(model.getViolatorName());
                viewHolder.ViolatorCnic.setText(model.getViolatorCnic());
                viewHolder.Documenttype.setText(model.getDocumenttype());
                viewHolder.Totalpayable.setText(model.getTotalpayable());
                viewHolder.offensecode.setText(model.getOffensecode());
                viewHolder.violation.setText(model.getViolation());
                viewHolder.fine.setText(model.getFine());
            }
            return convertView;
        }
    public  void updateRecords(List<challanDetailsModel> users){
        this.users = users;
        notifyDataSetChanged();
    }
    class ViewHolder{
        TextView ViolatorName,ViolatorCnic,Documenttype,Totalpayable,offensecode,violation,fine;
    }
}