package com.example.listcardyugioh.ui.connection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.listcardyugioh.CardApp;
import com.example.listcardyugioh.model.response.CardResponse;
import com.example.listcardyugioh.network.ApiService;
import com.example.listcardyugioh.ui.activity.ListCardActivity;
import com.example.listcardyugioh.ui.activity.MainActivity;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class CNListCardActivity extends ListCardActivity {

    @Override
    protected void onResume() {
        super.onResume();
        getDataCard();
        setDataActivity();
    }


    //----- connection
    public void getDataCard(){
        recyclerView.setVisibility(View.GONE);
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        shimmerFrameLayout.startShimmerAnimation();
        data.clear();

        Call<List<CardResponse>> call = mApiService.getCard(getIntent().getStringExtra("title"));
        call.enqueue(new Callback<List<CardResponse>>() {
            @Override
            public void onResponse(Call<List<CardResponse>> call, Response<List<CardResponse>> response) {
                if(response.body() != null){
                    if(response.body().size() > 0){
                        data = response.body();
                        Log.e("dataa jumlahhh", data.size()+" and "+response.body().size());
                        setAdapter(data);

                        hiddenError();
                        shimmerFrameLayout.stopShimmerAnimation();
                        recyclerView.setVisibility(View.VISIBLE);
                        shimmerFrameLayout.setVisibility(View.GONE);
                        swipeRefreshLayout.setRefreshing(false);
                    }else{
                        Toast.makeText(getApplicationContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Terjadi kesalahan pada system", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CardResponse>> call, Throwable t) {
                shimmerFrameLayout.stopShimmerAnimation();
                recyclerView.setVisibility(View.VISIBLE);
                shimmerFrameLayout.setVisibility(View.GONE);

                if (t instanceof HttpException) {
                    Toast.makeText(getApplicationContext(),
                            ((HttpException) t).response().message(),
                            Toast.LENGTH_SHORT).show();
                }

                if (t instanceof IOException) {
                    Toast.makeText(getApplicationContext(),
                            "Terimakasih, Transaksi anda sedang dalam proses",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //----- set views
    public void setDataActivity(){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataCard();
                txtSearch.setText("");
            }
        });

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(txtSearch.length() > 0){
                    filterCard(s.toString());
                }else {
                    getDataCard();
                }
                Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //----- set funtion
    public void textToast(Context context){
        Toast.makeText(context, "cieee berhasil", Toast.LENGTH_SHORT).show();
    }
}
