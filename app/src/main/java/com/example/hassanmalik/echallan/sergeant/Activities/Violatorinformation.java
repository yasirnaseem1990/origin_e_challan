package com.example.hassanmalik.echallan.sergeant.Activities;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hassanmalik.echallan.R;

public class Violatorinformation extends Fragment implements AdapterView.OnItemSelectedListener{
    ImageView btnNextVehicleInfo;
    private View view;
    EditText et_violatorcnicNo,et_violatorName,et_violatormobileNo;
    Spinner spinnerCitizen;
    private String violatorcnicNo,violatorName,violatormobileNo;
    private CharSequence selectedCitizen;

    //        btnNextVehicleInfo = (Button)findViewById(R.id.button2);
//            Intent i = new Intent(Violatorinformation.this,Vehicle_Information_submit.class);
//            startActivity(i);
    public Violatorinformation() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Generate Challan");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.activity_generate_challan, container, false);
        et_violatorcnicNo = (EditText) view.findViewById(R.id.edittextCnic);
        et_violatorName = (EditText) view.findViewById(R.id.edittxtName);
        et_violatormobileNo = (EditText) view.findViewById(R.id.modileNo);
        btnNextVehicleInfo = (ImageView) view.findViewById(R.id.btnNext);
        spinnerCitizen = (Spinner) view.findViewById(R.id.spinnercitizentype);
        btnNextVehicleInfo.setOnClickListener(
                new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Vehicle_Information_submit submit = new Vehicle_Information_submit();
                fragmentTransaction.replace(R.id.frame2, submit);
                fragmentTransaction.commit();
            }
        });

        /*try {
            //SMS Alerts Spinner
            ArrayAdapter<CharSequence> nextofkinAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.courtesyTitle, android.R.layout.simple_spinner_item);
            nextofkinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCitizen.setAdapter(nextofkinAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        spinnerCitizen.setOnItemSelectedListener(this);

        return view;


    }


    //Todo Check Form Fields
    public boolean checkFields() {

        et_violatorcnicNo.setError(null);
        et_violatorName.setError(null);
        et_violatormobileNo.setError(null);

        boolean cancel = false;
        View focusView = null;

        violatorcnicNo = et_violatorcnicNo.getText().toString().trim();
        violatorName = et_violatorName.getText().toString().trim();
        violatormobileNo = et_violatormobileNo.getText().toString().trim();


        try {

             if (TextUtils.isEmpty(violatorcnicNo)) {

                 et_violatorcnicNo.setError(getString(R.string.error_field_required));
                focusView = et_violatorcnicNo;
                cancel = true;
            } else if (TextUtils.isEmpty(violatorName)) {
                 et_violatorName.setError(getString(R.string.error_field_required));
                focusView = et_violatorName;
                cancel = true;
            } else if (TextUtils.isEmpty(violatormobileNo)) {
                 et_violatormobileNo.setError(getString(R.string.error_field_required));
                focusView = et_violatormobileNo;
                cancel = true;
            } else if (TextUtils.isEmpty(selectedCitizen)) {
                 Toast toast = Toast.makeText(getActivity(), "Please select citizen ", Toast.LENGTH_SHORT);
                 toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                 toast.show();
                 focusView = spinnerCitizen;
                 cancel = true;
             }

            if (cancel) {

                focusView.requestFocus();

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return cancel;
    }

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Impelmenters can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
