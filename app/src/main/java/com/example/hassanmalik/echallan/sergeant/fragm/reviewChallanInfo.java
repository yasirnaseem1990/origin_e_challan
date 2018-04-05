package com.example.hassanmalik.echallan.sergeant.fragm;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Adapters.reviewChallanAdapter;
import com.example.hassanmalik.echallan.sergeant.Model.challanDetailsModel;
import com.example.hassanmalik.echallan.sergeant.Model.todaySummarymodel;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class reviewChallanInfo extends Fragment {
    ListView list;
    ImageView btnSubmit;
    List<challanDetailsModel> users = new ArrayList<>();
    public reviewChallanInfo() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btnSubmit = (ImageView) rootView.findViewById(R.id.btnSubmit_review_chlan_info) ;
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                challanDetails submit = new challanDetails();
                fragmentTransaction.replace(R.id.frame2, submit);
                fragmentTransaction.commit();
            }
        });
        list = (ListView) rootView.findViewById(R.id.list_review_challan_info);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        users.add(new challanDetailsModel("200","100","120","130",
                "100","200","500"));
        final reviewChallanAdapter sumaryadapter = new reviewChallanAdapter(getActivity(),users);
        list.setAdapter(sumaryadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                challanDetailsModel model = users.get(position);
                users.set(position,model);
                sumaryadapter.updateRecords(users);
            }
        });

        return  rootView;
    }

        }
