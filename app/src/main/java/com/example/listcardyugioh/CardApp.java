package com.example.listcardyugioh;

import com.example.listcardyugioh.base.BaseApplication;

public class CardApp extends BaseApplication {
    private static CardComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = CardComponent.initializer.init(this);
    }

    public static CardComponent getmComponent() {
        return mComponent;
    }
}
