package com.example.hassanmalik.echallan.sergeant.Api_Network_calls;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Activities.HomeChallan;
import com.example.hassanmalik.echallan.sergeant.Utils.AppConstants;
import com.example.hassanmalik.echallan.sergeant.Utils.DataHandler;
import com.example.hassanmalik.echallan.sergeant.Utils.WebServiceConstants;
import com.example.hassanmalik.echallan.sergeant.dialogs.ProgressBarDialog;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 1/3/2018.
 */

public class LoginAsyncTask extends BaseAsyncTask {
    public static ProgressBarDialog progressBarDialogRegister;
    private String authKey = "";
    private String userId = "";
    Activity mActivity;
    public LoginAsyncTask(Context context, String route, List<NameValuePair> pp, Activity  activity) {
        super(context, route, pp);
        this.mActivity = activity;
        progressBarDialogRegister = new ProgressBarDialog(context);
        progressBarDialogRegister.setTitle(context.getString(R.string.title_progress_dialog));
        progressBarDialogRegister.setMessage(context.getString(R.string.body_progress_dialog));
        progressBarDialogRegister.show();
    }



    /**
     * AsyncTask method basic calls during a request, calls the parent's method.
     */
    protected String doInBackground(String... params) {

        return "";
    }
    /**
     * AsyncTask method basic calls after a request.
     */
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s != null) {
            int intResponse = Integer.parseInt(s);
            Log.e("ResponseCode", "" + intResponse);
            Log.e("response", "" + response);
            Log.e("resultat", "" + resultat);
            try{
                progressBarDialogRegister.dismiss();
                progressBarDialogRegister = null;
            }catch (Exception exception){
                exception.printStackTrace();
            }

            switch (intResponse) {
                case 200 :
                    try{

                        if(resultat !=null && !resultat.isEmpty()){
                            JSONObject objProfile = new JSONObject(resultat);
                            if(objProfile!=null){

                                userId = objProfile.getString("Id");
                                authKey = objProfile.getString("auth_key");
                                DataHandler.updatePreferences(AppConstants.PROFILE_DATA,objProfile.toString());

                                mParams = new ArrayList<NameValuePair>();
                                mParams.add(new BasicNameValuePair("Id", userId));
                                mParams.add(new BasicNameValuePair("key", authKey));

                                Log.e("PARAMS>", "" + mParams);

                                CitizenListAsyncTask citizenListAsyncTask = new CitizenListAsyncTask(context, WebServiceConstants.END_POINT_LIST_CITIZENS,mParams);
                                citizenListAsyncTask.execute();
                            }

                            Intent intent = new Intent(context, HomeChallan.class);
                            context.startActivity(intent);
                            this.mActivity.finish();

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 403:
                    try{
                        AlertDialog.Builder error_403 = new AlertDialog.Builder(context);
                        error_403.setMessage(context.getResources().getString(R.string.error_login_403)).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        error_403.show();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }

                    break;
                case 500:
                    try{
                        AlertDialog.Builder error_500 = new AlertDialog.Builder(context);
                        error_500.setMessage(context.getResources().getString(R.string.error_rate_500)).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        error_500.show();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }

                    break;
                // ecuador phone number exception,it has to surpass
                case 593:

                    break;
                //thanks now code is merged complete
            }
        }else {
            try{
                progressBarDialogRegister.dismiss();
                progressBarDialogRegister = null;
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
