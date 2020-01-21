package com.example.listcardyugioh.data;

import android.content.Context;

public class LocalDataUsers {
    // LogCat tag
    private static final String PREF_KEY   = "bulb_login_session";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_TOKEN = "userToken";


    private static void setSharedPreference(Context context, String mKey, String mValue){
        context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .edit()
                .putString(mKey, mValue)
                .apply();
    }

    private static void setSharedPreference(Context context, String mKey, boolean mValue){
        context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(mKey, mValue)
                .apply();
    }

    private static void setSharedPreference(Context context, String mKey, int mValue){
        context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .edit()
                .putInt(mKey, mValue)
                .apply();
    }

    private static String getSharedPreferenceString(Context context, String mKey){
        return context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .getString(mKey, null);
    }

    private static boolean getSharedPreferenceBoolean(Context context, String mKey){
        return context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .getBoolean(mKey, false);
    }

    private static int getSharedPreferenceInt(Context context, String mKey){
        return context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .getInt(mKey, 0);
    }

    //----- getter setter

    public String getKeyUserName(Context context){
        return getSharedPreferenceString(context, KEY_USER_NAME);
    }

    public void setKeyUserName(Context context, String mValue) {
        setSharedPreference(context, KEY_USER_NAME, mValue);
    }

    public String getKeyUserToken(Context context){
        return getSharedPreferenceString(context, KEY_USER_TOKEN);
    }

    public void setKeyUserToken(Context context, String mValue) {
        setSharedPreference(context, KEY_USER_TOKEN, mValue);
    }

    public void clearSession(Context context) {
        context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply();
    }
}
