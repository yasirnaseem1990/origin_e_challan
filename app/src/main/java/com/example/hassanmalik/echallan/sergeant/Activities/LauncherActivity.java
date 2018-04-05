package com.example.hassanmalik.echallan.sergeant.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.hassanmalik.echallan.R;
import com.example.hassanmalik.echallan.sergeant.Utils.AppConstants;
import com.example.hassanmalik.echallan.sergeant.Utils.DataHandler;

public class LauncherActivity extends AppCompatActivity {

    private ImageView splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        splashScreen = (ImageView) findViewById(R.id.img_splashScreen);
        splashScreen.setVisibility(View.VISIBLE);
        new DataHandler(LauncherActivity.this);
        Message msg = new Message();
        msg.what = -1;
        guiHandler.sendMessageDelayed(msg, 1000);
    }

    // Handler sets the navigation of which activity to show at which time
    private Handler guiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == -1) {

                String jsonobprofileData = DataHandler.getStringPreferences(AppConstants.PROFILE_DATA);
                Log.e("jsonobprofileData :", jsonobprofileData);
                if (jsonobprofileData != null && !jsonobprofileData.isEmpty()) {
                    Intent intent = new Intent(LauncherActivity.this, HomeChallan.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(LauncherActivity.this,EchallanLogin.class);
                    startActivity(intent);
                    finish();
                }
            }

        }
    };
}
