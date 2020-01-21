package com.example.listcardyugioh.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listcardyugioh.CardApp;
import com.example.listcardyugioh.R;
import com.example.listcardyugioh.model.response.CardResponse;
import com.example.listcardyugioh.network.ApiService;
import com.example.listcardyugioh.ui.adapter.ListCardAdapter;
import com.example.listcardyugioh.ui.dialog.DialogListCardActivity;
import com.example.listcardyugioh.ui.dialog.DialogMainActivity;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class ListCardActivity extends DialogListCardActivity {
        //----- add service
        protected  @Inject ApiService mApiService;

        //----- set variable views
        protected @BindView(R.id.rvItem) RecyclerView recyclerView;
        protected @BindView(R.id.shimmerCard) ShimmerFrameLayout shimmerFrameLayout;
        protected @BindView(R.id.txtNama) TextView txtNama;
        protected @BindView(R.id.layoutErr) RelativeLayout layoutErr;
        protected @BindView(R.id.swipeRefresh) SwipeRefreshLayout swipeRefreshLayout;
        protected @BindView(R.id.txtSearch) EditText txtSearch;

        //----- set variable data
        protected ListCardAdapter adapter;
        protected List<CardResponse> data = new ArrayList<>();
        protected String type = "";
        protected Context mContext;

        //----- set action button
        @OnClick(R.id.toolbar_back)
        void onActionBack(){
            finish();
            //doToast();
        }

        //----- function android
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_card);
            ButterKnife.bind(this);
            CardApp.getmComponent().inject(this);
            mContext = getApplicationContext();
            setDataActivity();
        }

        //----- set views
        private void setDataActivity(){
            Intent i = getIntent();
            txtNama.setText(i.getStringExtra("title"));
        }

        //----- set adapter
        protected void setAdapter(List<CardResponse> data){
            adapter = new ListCardAdapter(this, data);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            recyclerView.setAdapter(adapter);
            adapter.setClickCard(new ListCardAdapter.ClickCard() {
                @Override
                public void ClickCardListener(CardResponse data) {
                    Intent i = new Intent(ListCardActivity.this, DetailCardActivity.class);
                    i.putExtra("data", data);
                    i.putExtra("photo", data.getCard_images().get(0).getImage());
                    startActivity(i);
                }
            });
            adapter.notifyDataSetChanged();
        }

        //----- set function
        protected void filterCard(String s){
            List<CardResponse> dataa = new ArrayList<>();
            for(CardResponse cardResponse: data){
                if(cardResponse.getName().toLowerCase().contains(s.toLowerCase())){
                    dataa.add(cardResponse);
                }
            }

            if(dataa.size() > 0){
                data.clear();
                data.addAll(dataa);
                adapter.notifyDataSetChanged();
            }else{
                showError();
            }
        }
        protected void showError(){
            layoutErr.setVisibility(View.VISIBLE);
        }
        protected void hiddenError(){
            layoutErr.setVisibility(View.GONE);
        }
}
