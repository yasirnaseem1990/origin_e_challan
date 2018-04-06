package com.example.hassanmalik.echallan.sergeant.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hassanmalik.echallan.R;

public class Vehicle_Information_submit extends Fragment {
    ImageView btnNextt;
    //    btnNextt =(Button)findViewById(R.id.btn22);
    public Vehicle_Information_submit() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_vehicle, container, false);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });


        btnNextt =(ImageView) view.findViewById(R.id.btn_vehicle_information_submit);
        btnNextt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ViolationInformationSelection submit = new ViolationInformationSelection();
                fragmentTransaction.replace(R.id.frame2, submit);
                fragmentTransaction.commit();


//                Intent myIntent = new Intent(getActivity(), ViolationInformationSelection.class);
//                getActivity().startActivity(myIntent);
            }
        });
        return  view;
    }

}



