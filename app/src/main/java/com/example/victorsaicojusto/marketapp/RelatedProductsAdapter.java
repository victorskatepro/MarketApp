package com.example.victorsaicojusto.marketapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RelatedProductsAdapter extends RecyclerView.Adapter<HortusViewHolderHelper.RelatedProductsItemHolder> {

    private final Context ctx;

    public RelatedProductsAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HortusViewHolderHelper.RelatedProductsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_related_row, parent, false);
        return new HortusViewHolderHelper.RelatedProductsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HortusViewHolderHelper.RelatedProductsItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}