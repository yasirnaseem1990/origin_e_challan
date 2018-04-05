package com.example.hassanmalik.echallan.sergeant.fragm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hassanmalik.echallan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class paymentVerification extends Fragment {

    public paymentVerification() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View rootView = inflater.inflate(R.layout.fragment_payment_verification, container, false);
      rootView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
      });


    return  rootView;
    }


}
