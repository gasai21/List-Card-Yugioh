package com.example.listcardyugioh.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listcardyugioh.R;
import com.example.listcardyugioh.model.response.CardResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailCardActivity extends AppCompatActivity {

    //----- set variable view
    @BindView(R.id.imgDetail) ImageView imgDetail;
    @BindView(R.id.txtDesc) TextView txtDesc;
    @BindView(R.id.txtNama) TextView txtNama;
    @BindView(R.id.txtArchetype) TextView txtArcetype;
    @BindView(R.id.txtFormats) TextView txtFormat;
    @BindView(R.id.txtRace) TextView txtRace;
    @BindView(R.id.txtType) TextView txtType;

    //----- set action button
    @OnClick(R.id.toolbar_back)
    void onActionBack(){
        finish();
    }

    //----- function android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);
        ButterKnife.bind(this);
        setDataActivity();
    }

    //----- set views
    private void setDataActivity(){
        Intent i = getIntent();
        CardResponse data = i.getParcelableExtra("data");
        Glide.with(this)
                .load(i.getStringExtra("photo"))
                .into(imgDetail);
        txtDesc.setText(data.getDesc());
        txtNama.setText(data.getName());
        txtArcetype.setText(data.getArchetype());
        txtFormat.setText(data.getFormats());
        txtRace.setText(data.getRace());
        txtType.setText(data.getType());

    }
}
