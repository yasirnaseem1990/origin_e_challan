package com.example.hassanmalik.echallan.sergeant.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Api_Network_calls.LoginAsyncTask;
import com.example.hassanmalik.echallan.sergeant.Utils.AppConstants;
import com.example.hassanmalik.echallan.sergeant.Utils.AppUtils;
import com.example.hassanmalik.echallan.sergeant.Utils.DataHandler;
import com.example.hassanmalik.echallan.sergeant.Utils.WebServiceConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EchallanLogin extends AppCompatActivity {

    Button sigin;
    // Email, password edittext
    EditText txtUsername, txtPassword;
    //    SharedPrefrences session;
    // Alert Dialog Manager
    AlertDialog alertDialog;
    public List<NameValuePair> mParams;
    private String userName = "";
    private String password = "";
    public static Context mAppcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppcontext = getApplicationContext();
        new DataHandler(mAppcontext);
        sigin = (Button) findViewById(R.id.button);
        // Shared prefrences
//        session = new SharedPrefrences(getApplicationContext());
        // Email, Password input text
        txtUsername = (EditText) findViewById(R.id.editText);
        txtPassword = (EditText) findViewById(R.id.editText2);

        //TODO local commit for testintg lkjlkjklj
        //Hassan is commit the code for the first time please ho jao

//        Toast.makeText(getApplicationContext(), "Sergeant Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkFields()){
                    Login();
                }
//
    }
});
    }



    private void Login() {
        try{
            if(isNetworkAvailable()){
                mParams = new ArrayList<NameValuePair>();
                mParams.add(new BasicNameValuePair("UserName", txtUsername.getText().toString().trim().toLowerCase()));
                mParams.add(new BasicNameValuePair("Password", txtPassword.getText().toString().trim()));
                JSONObject jsonObject = new JSONObject();
                if (jsonObject != null) {

                    try {
                        jsonObject.put("email", txtUsername.getText().toString().trim().toLowerCase());
                        jsonObject.put("last_name", txtPassword.getText().toString().trim());

                        //DataHandler.updatePreferences(AppConstants.LOGIN_KEY, jsonObject.toString());

                        Log.e("PARAMS>", "" + mParams);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Log.e("PARAMS>", "" + mParams);
                LoginAsyncTask registerAsyncTask = new LoginAsyncTask(EchallanLogin.this, WebServiceConstants.END_POINT_LOGIN, mParams,EchallanLogin.this);
                registerAsyncTask.execute();

            }else {
                /*Intent intent =  new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);*/
                android.app.AlertDialog.Builder error_No_Internet = new android.app.AlertDialog.Builder(this);
                error_No_Internet.setMessage(this.getResources().getString(R.string.error_No_Internet)).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                error_No_Internet.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    // for the checking the field of the register forms
    public boolean checkFields() {
        txtUsername.setError(null);
        txtPassword.setError(null);

        boolean cancel = false;
        View focusView = null;
        userName = txtUsername.getText().toString().toLowerCase().trim().replaceAll("\\s+$", "");
        password = txtPassword.getText().toString().trim().replaceAll("\\s+$", "");

        if (TextUtils.isEmpty(userName)) {

            txtUsername.setError(getString(R.string.error_field_required));
            focusView = txtUsername;
            cancel = true;
        } else if (!AppUtils.emailValidator(userName)) {

            txtUsername.setError(getString(R.string.valid_email));
            focusView = txtUsername;
            cancel = true;
        } else if (TextUtils.isEmpty(password)){
            txtPassword.setError(getString(R.string.error_field_required));
            focusView = txtPassword;
            cancel = true;
        }
        if (cancel) {

            focusView.requestFocus();

        }
        return cancel;
    }
}


