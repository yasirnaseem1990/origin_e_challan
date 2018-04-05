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
public class handOverToViolator extends Fragment {

    public handOverToViolator() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View rootv = inflater.inflate(R.layout.fragment_hand_over_to_violator, container, false);

      rootv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

      return rootv;
    }

}
