package com.example.listcardyugioh;

import com.example.listcardyugioh.dagger.PerApp;
import com.example.listcardyugioh.network.NetworkModule;
import com.example.listcardyugioh.ui.activity.ListCardActivity;
import com.example.listcardyugioh.ui.activity.MainActivity;
import com.example.listcardyugioh.ui.connection.CNListCardActivity;

import dagger.Component;

@PerApp
@Component(modules = {
        NetworkModule.class
})
public interface CardComponent {

    void inject(MainActivity mainActivity);
    void inject(CNListCardActivity cnListCardActivity);
    void inject(ListCardActivity listCardActivity);

    final class initializer {
        public static CardComponent init(CardApp card) {
            return DaggerCardComponent.builder().networkModule(new NetworkModule()).build();
        }
    }
}
