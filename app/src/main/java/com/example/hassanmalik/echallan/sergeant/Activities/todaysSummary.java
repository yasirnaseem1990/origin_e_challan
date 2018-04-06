package com.example.hassanmalik.echallan.sergeant.Activities;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.todaySummaryAdapter;
import com.example.hassanmalik.echallan.sergeant.Model.todaySummarymodel;
import com.example.hassanmalik.echallan.sergeant.fragm.challanDetails;
import com.example.hassanmalik.echallan.sergeant.fragm.reviewChallanInfo;
import java.util.ArrayList;
import java.util.List;
public class todaysSummary extends android.support.v4.app.Fragment {
    ListView list;
    List<todaySummarymodel> users = new ArrayList<>();
    ImageView btn;
    public todaysSummary(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_todays_summary, container, false);
        list = (ListView) rootView.findViewById(R.id.list_today_summary);
        btn = (ImageView) rootView.findViewById(R.id.btnNxt_today_sum) ;
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                reviewChallanInfo submit = new reviewChallanInfo();
                fragmentTransaction.replace(R.id.frame2, submit);
                fragmentTransaction.commit();
            }
        });

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        users.add(new todaySummarymodel("200","100","120","130",
                "100","200","500","500"));
        //Adapter of Second
        final todaySummaryAdapter sumaryadapter = new todaySummaryAdapter(getActivity(),users);
        list.setAdapter(sumaryadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                todaySummarymodel todaySummarymodel = users.get(position);
                users.set(position,todaySummarymodel);
                sumaryadapter.updateRecords(users);
            }

        });
        return rootView;
    }
}


