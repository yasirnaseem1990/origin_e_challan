package com.example.hassanmalik.echallan.sergeant.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Activities.Violatorinformation;
import com.example.hassanmalik.echallan.sergeant.Utils.AppConstants;
import com.example.hassanmalik.echallan.sergeant.Utils.DataHandler;

public class HomeChallan extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    final Context context = this;
    ImageView Generate_challan, Violator_History, Todaysumary, payment_verification, Document_Handover;
    DrawerLayout drawer;
    Spinner spinnerZone;
    private String selectedZone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__c);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome to eChallan");
        showDailogue();
        String dbug = DebugDB.getAddressLog();
        Log.e("DebugLogs",dbug);
        Generate_challan = (ImageView) findViewById(R.id.imageView4);
        Generate_challan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), Violatorinformation.class);
//                startActivity(i);
                Violatorinformation fragment = new Violatorinformation();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame2, fragment);
                transaction.commit();
            }
        });

        Violator_History = (ImageView) findViewById(R.id.imageView5);
        Violator_History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Todaysumary = (ImageView) findViewById(R.id.imageView6);
        Todaysumary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                todaysSummary submit = new todaysSummary();
                fragmentTransaction.replace(R.id.frame2, submit);
                fragmentTransaction.commit();

// Intent i = new Intent(HomeChallan.this,todaysSummary.class);
//                startActivity(i);

            }
        });

        payment_verification = (ImageView) findViewById(R.id.imageView7);
        payment_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        Document_Handover = (ImageView) findViewById(R.id.imageView8);
        Document_Handover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home__challan, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Change Drawere stae change kro
            drawer.openDrawer(GravityCompat.END);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.generatechallan) {
            // Handle the camera action
        } else if (id == R.id.violatorhistory) {

        } else if (id == R.id.todaysummary) {

        } else if (id == R.id.doc_handover) {

        } else if (id == R.id.pay) {

        } else if (id == R.id.nav_changepassw) {
        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;

    }


    //Dailogue Box BeFORE lOGIN
    public void showDailogue() {
        final Dialog dialog = new Dialog(context);
        //tell the Dialog to use the dialog.xml as it's layout description
        dialog.setContentView(R.layout.adapter_spinnner);
        dialog.setCancelable(false);
        dialog.setTitle("Select Zone");

        final View update_layout = getLayoutInflater().inflate(R.layout.adapter_spinnner, null);


        final ImageView ImageView = (ImageView) update_layout.findViewById(R.id.image1);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkFields()){
                    DataHandler.updatePreferences(AppConstants.SELECTED_ZONE,selectedZone);
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
        //Spinner here
        spinnerZone = (Spinner) update_layout.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> professionAdapter = ArrayAdapter.createFromResource(HomeChallan.this,
                R.array.zoneList, android.R.layout.simple_spinner_item);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, items);*/

        professionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dialog.setContentView(update_layout);
        spinnerZone.setAdapter(professionAdapter);

        spinnerZone.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view;
        try {
            if (position == 0) {
                tv.setTextColor(Color.GRAY);
            } else {
                tv.setTextColor(Color.BLACK);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            if (position > 0) {
                switch (parent.getId()) {
                    case R.id.spinner1:
                        selectedZone = parent.getSelectedItem().toString();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //Todo Check Form Fields
    public boolean checkFields() {
        boolean cancel = false;
        View focusView = null;



        try {
            if (TextUtils.isEmpty(selectedZone)) {
                Toast toast = Toast.makeText(HomeChallan.this, "Please Select Zone", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
                focusView = spinnerZone;
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
}



