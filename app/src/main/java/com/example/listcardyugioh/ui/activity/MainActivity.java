package com.example.listcardyugioh.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.listcardyugioh.R;
import com.example.listcardyugioh.data.LocalDataUsers;
import com.example.listcardyugioh.ui.connection.CNListCardActivity;
import com.example.listcardyugioh.ui.dialog.DialogMainActivity;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends DialogMainActivity {
    //----- set variable view
    @BindView(R.id.txtNama) TextView txtNama;

    //-----set action button
    @OnClick(R.id.cardSpell)
    void onActionClickSpell(){
        Intent i = new Intent(MainActivity.this, CNListCardActivity.class);
        i.putExtra("title", "Spell Card");
        startActivity(i);
    }
    @OnClick(R.id.logout)
    void onActionLogout(){
        showDialogLogout();
    }
    @OnClick(R.id.cardTrap)
    void onActionTrap(){
        Intent i = new Intent(MainActivity.this, CNListCardActivity.class);
        i.putExtra("title", "Trap Card");
        startActivity(i);
    }
    @OnClick(R.id.cardMonster)
    void onActionMonster(){
        Intent i = new Intent(MainActivity.this, CNListCardActivity.class);
        i.putExtra("title", "Normal Monster");
        startActivity(i);
    }

    //----- function android
    @Override
    protected void onResume() {
        super.onResume();
        if(new LocalDataUsers().getKeyUserName(MainActivity.this) == null){
            showDialogChangeName();
        }else{
            txtNama.setText("Hello "+new LocalDataUsers().getKeyUserName(MainActivity.this));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //StatusBarUtil.setTranslucentForImageView(MainActivity.this, 10, null);
    }
}
