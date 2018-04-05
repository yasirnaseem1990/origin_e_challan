package com.example.hassanmalik.echallan.sergeant.fragm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hassanmalik.echallan.R;


public class challanDetails extends Fragment {
    //Empty Constructor
    public challanDetails(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challan_details, container, false);

    }
    }

