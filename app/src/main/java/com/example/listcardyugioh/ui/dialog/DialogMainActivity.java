package com.example.listcardyugioh.ui.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listcardyugioh.R;
import com.example.listcardyugioh.data.LocalDataUsers;
import com.example.listcardyugioh.ui.activity.LoginActivity;
import com.example.listcardyugioh.ui.activity.MainActivity;

public class DialogMainActivity extends AppCompatActivity {

    protected void showDialogChangeName(){
        Dialog statusMessageDialog = new Dialog(DialogMainActivity.this);
        statusMessageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        statusMessageDialog.setContentView(R.layout.dialog_change_name);
        statusMessageDialog.setCancelable(false);
        statusMessageDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(statusMessageDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        statusMessageDialog.show();
        statusMessageDialog.getWindow().setAttributes(lp);

        EditText nama__ = statusMessageDialog.findViewById(R.id.input_nama);
        Button btnEdit = statusMessageDialog.findViewById(R.id.btn_action_edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama__.getText().length() < 1){
                    Toast.makeText(DialogMainActivity.this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else{
                    new LocalDataUsers().setKeyUserName(DialogMainActivity.this, nama__.getText().toString());
                    statusMessageDialog.dismiss();
                }
            }
        });
        statusMessageDialog.show();
    }

    protected void showDialogLogout(){
        Dialog statusMessageDialog = new Dialog(DialogMainActivity.this);
        statusMessageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        statusMessageDialog.setContentView(R.layout.dialog_logout);
        statusMessageDialog.setCancelable(false);
        statusMessageDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(statusMessageDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        statusMessageDialog.show();
        statusMessageDialog.getWindow().setAttributes(lp);

        Button btnYa = statusMessageDialog.findViewById(R.id.btn_ya);
        Button btnTidak = statusMessageDialog.findViewById(R.id.btn_tidak);

        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishIntent = new Intent(DialogMainActivity.this, LoginActivity.class);
                finishIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finishIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finishIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(finishIntent);
                finish();
                new LocalDataUsers().clearSession(DialogMainActivity.this);
                statusMessageDialog.dismiss();
            }
        });

        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusMessageDialog.dismiss();
            }
        });
        statusMessageDialog.show();
    }

}
