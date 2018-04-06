package com.example.hassanmalik.echallan.sergeant.fragm;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.challandetail_adapter;
import com.example.hassanmalik.echallan.sergeant.Adapters.reviewChallanAdapter;
import com.example.hassanmalik.echallan.sergeant.Model.challanDetailsModel;
import java.util.ArrayList;
import java.util.List;

public class challanDetails extends Fragment {

    ListView list;
    List<challanDetailsModel> users = new ArrayList<>();
    //Empty Constructor
    public challanDetails(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_challan_details, container, false);
        list = (ListView) rootView.findViewById(R.id.list_challan_details);

        //root view because fragments override

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        users.add(new challanDetailsModel("200","100","120","130",
                "100","200","500"));

        final challandetail_adapter adapter = new challandetail_adapter(getActivity(),users);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                challanDetailsModel model = users.get(position);
                users.set(position,model);
                adapter.updateRecords(users);


            }
        });


        return  rootView;
    }
}

