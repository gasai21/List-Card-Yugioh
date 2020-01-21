package com.example.listcardyugioh.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listcardyugioh.R;
import com.example.listcardyugioh.model.response.CardResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListCardAdapter extends RecyclerView.Adapter<ListCardAdapter.CardViewHolder> {
    Context context;
    List<CardResponse> data;
    ClickCard clickCard;

    public ListCardAdapter(Context context, List<CardResponse> data) {
        this.context = context;
        this.data = data;
    }

    public void setClickCard(ClickCard clickCard) {
        this.clickCard = clickCard;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_card, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Glide.with(context)
                .load(data.get(position).getCard_images().get(0).getImage())
                .into(holder.imgCard);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCard.ClickCardListener(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgCard) ImageView imgCard;
        @BindView(R.id.layout_img) RelativeLayout relativeLayout;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static interface ClickCard{
        void ClickCardListener(CardResponse data);
    }
}
