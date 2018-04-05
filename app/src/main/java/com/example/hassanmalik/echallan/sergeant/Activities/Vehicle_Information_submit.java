package com.example.hassanmalik.echallan.sergeant.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hassanmalik.echallan.R;

public class Vehicle_Information_submit extends Fragment {
    Button btnNextt;

    //    btnNextt =(Button)findViewById(R.id.btn22);
    public Vehicle_Information_submit() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Generate Challan");
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


        btnNextt = (Button) view.findViewById(R.id.btn22);
        btnNextt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), ViolationInformationSelection.class);
                getActivity().startActivity(myIntent);
            }
        });
        return view;
    }

}



