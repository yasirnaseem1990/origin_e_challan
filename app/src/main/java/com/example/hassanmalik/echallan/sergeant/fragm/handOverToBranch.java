package com.example.hassanmalik.echallan.sergeant.fragm;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.handOverTobAdapter;
import com.example.hassanmalik.echallan.sergeant.Model.handOverToBranchModel;

import java.util.ArrayList;
import java.util.List;


public class handOverToBranch extends Fragment {
    ListView list;
    List<handOverToBranchModel> users = new ArrayList<>();
    public handOverToBranch() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView =  inflater.inflate(R.layout.fragment_hand_over_to_branch, container, false);

       rootView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        list = (ListView) rootView.findViewById(R.id.list_handover_To_B);

        users.add(new handOverToBranchModel("200","100","Fahad","IVV"));

            final handOverTobAdapter adapter  = new handOverTobAdapter(getActivity(),users);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    handOverToBranchModel model = users.get(position);
                    users.set(position,model);
                    adapter.updateRecords(users);

                }
            });


            return  rootView;
    }

}
