package com.example.listcardyugioh.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.listcardyugioh.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    //----- set variable views
    @BindView(R.id.txtNoTelp) EditText txtNoTelp;

    //----- set action button
    @OnClick(R.id.btnLogin)
    void onActionLogin(){
        String mobile = txtNoTelp.getText().toString().trim();
        if(mobile.isEmpty() || mobile.length() < 10){
            txtNoTelp.setError("Enter a valid mobile");
            txtNoTelp.requestFocus();
            return;
        }
        Intent intent = new Intent(LoginActivity.this, VerificationActivity.class);
        intent.putExtra("mobile", mobile);
        startActivity(intent);
    }

    //----- function android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
