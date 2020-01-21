package com.example.listcardyugioh.ui.dialog;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listcardyugioh.ui.connection.CNListCardActivity;

public class DialogListCardActivity extends AppCompatActivity  {

    protected void doToast(){
        new CNListCardActivity().textToast(getApplicationContext());
    }
}
