package com.example.hassanmalik.echallan.sergeant.fragm;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hassanmalik.echallan.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class welcomeToEchallan extends Fragment {
    public welcomeToEchallan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_welcome_to_echallan, container, false);
        ImageView violator = (ImageView) view.findViewById(R.id.dim);
        ImageView tobranch = (ImageView) view.findViewById(R.id.imageView9);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        violator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handOverToViolator fragment = new handOverToViolator();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame2, fragment);
                transaction.commit();
            }
        });
        tobranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handOverToBranch fragment = new handOverToBranch();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame2, fragment);
                transaction.commit();

            }
        });
        return  view;
    }
}
