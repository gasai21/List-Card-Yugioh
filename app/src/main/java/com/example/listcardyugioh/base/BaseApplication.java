package com.example.listcardyugioh.base;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class BaseApplication extends MultiDexApplication {

    public static Context context;
    private static BaseApplication enableMultiDex;

    public BaseApplication() {
        enableMultiDex = this;
    }

    public static BaseApplication getEnableMultiDexApp() {
        return enableMultiDex;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        context = getApplicationContext();
    }
}
