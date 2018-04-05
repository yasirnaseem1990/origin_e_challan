package com.example.hassanmalik.echallan.sergeant.Activities;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.todaySummaryAdapter;
import com.example.hassanmalik.echallan.sergeant.Model.todaySummarymodel;
import java.util.ArrayList;
import java.util.List;
public class todaysSummary extends Fragment {
    ListView list;
    List<todaySummarymodel> users = new ArrayList<>();
    public todaysSummary(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_todays_summary, container, false);
        list = (ListView) rootView.findViewById(R.id.listitem11);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        users.add(new todaySummarymodel("200","100","12","13",
                "10","20","5","50"));
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


