package com.openclassrooms.entrevoisins.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    public static SharedPreferences getSharedPref(Context mContext) {
        SharedPreferences pref = mContext.getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        return pref;
    }

    public static void setBooleanPrefVal(Context mContext, String key, boolean value) {
        if(key!=null){
            SharedPreferences.Editor edit = getSharedPref(mContext).edit();
            edit.putBoolean(key, value);
            edit.apply();
        }
    }

    public static boolean getBooleanPrefVal(Context mContext, String key) {
        SharedPreferences pref = getSharedPref(mContext);
        boolean val = false;
        try{
            if(pref.contains(key)) val = pref.getBoolean(key, false);

        }catch (Exception e){
            e.printStackTrace();
        }
        return val;
    }


    public static boolean containkey(Context mContext,String key)
    {
        SharedPreferences pref = getSharedPref(mContext);
        return pref.contains(key);
    }

}
