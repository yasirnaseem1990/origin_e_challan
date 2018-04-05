package com.example.hassanmalik.echallan.sergeant.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Hassan Malik on 3/17/2018.
 */
//public class SharedPrefrences {
//    private static final String USER_WARDEN = "user_warden";
//
//    SharedPreferences sharedPreferences;
//    // Editor for Shared preferences
//    SharedPreferences.Editor editor;
//    private Context context;
//
//    // Sharedpref file name
//    private static final String PREF_NAME = "AndroidHivePref";
//    // All Shared Preferences Keys
//    private static final String IS_LOGIN = "IsLoggedIn";
//    // User name (make variable public to access from outside)
//    public static final String KEY_NAME = "name";
//    // Email address (make variable public to access from outside)
//    public static final String KEY_EMAIL = "email";
//
//
//    public SharedPrefrences(Context context) {
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences("pref", MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//
//    }
//    /**
//     * Create login session
//     * */
//    public void createLoginSession(String name, String email){
//        // Storing login value as TRUE
//        editor.putBoolean(IS_LOGIN, true);
//        // Storing name in pref
//        editor.putString(KEY_NAME, name);
//        // Storing email in pref
//        editor.putString(KEY_EMAIL, email);
//        // commit changes
//        editor.commit();
//    }
//
//    /**
//     * Check login method wil check user login status
//     * If false it will redirect user to login page
//     * Else won't do anything
//     * */
//    public HashMap<String, String> checkLogin() {
//        // Check login status
//        if (!this.isLoggedIn()) {
//            // user is not logged in redirect him to Login Activity
//            Intent i = new Intent(context, EchallanLogin.class);
//            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            // Add new Flag to start new Activity
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            // Staring Login Activity
//            context.startActivity(i);
//        }
//
//        /**
//         * Get stored session data
//         * */
//        public HashMap<String, String> getUserDetails() {
//            HashMap<String, String> user = new HashMap<String, String>();
//            // user name
//            user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));
//
//            // user email id
//            user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));
//
//             return user;
////            return user;
//        }
//    }
//        /**
//         * Clear session details
//         * */
//    public void logoutUser(){
//        // Clearing all data from Shared Preferences
//        editor.clear();
//        editor.commit();
//
//        // After logout redirect user to Loing Activity
//        Intent i = new Intent(context, EchallanLogin.class);
//        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        // Staring Login Activity
//        context.startActivity(i);
//    }
//
//    /**
//     * Quick check for login
//     * **/
//    // Get Login State
//    public boolean isLoggedIn(){
//        return sharedPreferences.getBoolean(IS_LOGIN, false);
//    }
//}







