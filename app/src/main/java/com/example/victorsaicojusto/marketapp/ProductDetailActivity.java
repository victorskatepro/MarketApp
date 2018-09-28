package com.example.victorsaicojusto.marketapp;

import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener, ProductDetailInterface  {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.open_drawer)
    ImageView openDrawerIcon;
    @BindView(R.id.shopping_toolbar_icon)
    ImageView shoppingIcon;
    @BindView(R.id.product_view_pager)
    ViewPager productViewPager;
    @BindView(R.id.circle_indicator)
    CircleIndicator circleIndicator;
    @BindView(R.id.left_arrow)
    ImageView leftArrow;
    @BindView(R.id.right_arrow)
    ImageView rightArrow;
    @BindView(R.id.left_recycler_arrow)
    ImageView leftRecyclerArrow;
    @BindView(R.id.right_recycler_arrow)
    ImageView rightRecyclerArrow;
    @BindView(R.id.related_product_recycler)
    RecyclerView productRecycler;
    @BindView(R.id.pdf_layout_container)
    LinearLayout pdfLayoutContainer;

    private LinearLayoutManager horizontalLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        setListeners();
        setProductViewPager();
        setHorizontalProductsRecycler();
    }
    private void setProductViewPager() {
        ProductDetailAdapter adapter = new ProductDetailAdapter(this);
        productViewPager.setAdapter(adapter);
        circleIndicator.setViewPager(productViewPager);
    }
    private void setHorizontalProductsRecycler() {
        RelatedProductsAdapter productsAdapter = new RelatedProductsAdapter(this);
        horizontalLinearLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        productRecycler.setLayoutManager(horizontalLinearLayoutManager);
        productRecycler.setAdapter(productsAdapter);
    }
    private void setListeners() {
        //imageProduct.setOnClickListener(this);
        openDrawerIcon.setOnClickListener(this);
        shoppingIcon.setOnClickListener(this);
        leftArrow.setOnClickListener(this);
        rightArrow.setOnClickListener(this);
        leftRecyclerArrow.setOnClickListener(this);
        rightRecyclerArrow.setOnClickListener(this);
        pdfLayoutContainer.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.open_drawer:
                drawerLayout.openDrawer(Gravity.END);
                break;
            case R.id.shopping_toolbar_icon:
                //goToShoppingActivity();
                break;
            case R.id.left_arrow:
                productViewPager.setCurrentItem(productViewPager.getCurrentItem() - 1);
                break;
            case R.id.right_arrow:
                productViewPager.setCurrentItem(productViewPager.getCurrentItem() + 1);
                break;
            case R.id.left_recycler_arrow:
                int firstPosition = horizontalLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
                productRecycler.smoothScrollToPosition(firstPosition != 0 ? firstPosition - 1 : firstPosition);
                break;
            case R.id.right_recycler_arrow:
                int lastPosition = horizontalLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                productRecycler.smoothScrollToPosition(lastPosition != horizontalLinearLayoutManager.getItemCount() - 1 ? horizontalLinearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 : lastPosition);
                break;
            case R.id.dismiss_navigation_view:
                drawerLayout.closeDrawer(Gravity.END);
                break;
            case R.id.pdf_layout_container:
               // openWebViewActivity();
                break;
            default:
                break;
        }
    }

    @Override
    public void productClicked(int position) {

    }
}
