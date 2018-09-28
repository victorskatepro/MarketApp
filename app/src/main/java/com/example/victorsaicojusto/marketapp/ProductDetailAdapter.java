package com.example.victorsaicojusto.marketapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ProductDetailAdapter extends PagerAdapter implements View.OnClickListener {

    private Context ctx;
    private ProductDetailInterface mListener;
    private int position;

    public ProductDetailAdapter(Context ctx) {
        mListener = (ProductDetailInterface) ctx;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view;
        this.position = position;
        if (layoutInflater != null) {
            item_view = layoutInflater.inflate(R.layout.product_detail_adapter_row, container, false);
            container.addView(item_view);
            item_view.setOnClickListener(this);
            return item_view;
        } else {
            return null;
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @Override
    public void onClick(View v) {
        mListener.productClicked(position);
    }
}
