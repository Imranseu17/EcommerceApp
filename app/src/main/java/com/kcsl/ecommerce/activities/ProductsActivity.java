package com.kcsl.ecommerce.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.AllProductAdapter;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.databinding.ActivityProductsBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.ProductDatum;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.ProductsPresenter;
import com.kcsl.ecommerce.utils.PaginationScrollListener;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class ProductsActivity extends AppCompatActivity implements ProductsUserView {

    ProductsPresenter productsPresenter;
    ActivityProductsBinding productsBinding;
    GridLayoutManager layoutManager;
    AllProductAdapter allProductAdapter;
    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 5;
    private int MY_TOTAL_PAGE = 0;
    private int currentPage = PAGE_START;
    int count = 0;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        productsBinding = DataBindingUtil.setContentView(this, R.layout.activity_products);
        productsPresenter = new ProductsPresenter(this);

        productsBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        id = getIntent().getIntExtra("id",0);
        viewConfig();
        getAllProduct(id,currentPage,50);
    }

    private void  viewConfig(){


            productsBinding.allProductsList.setHasFixedSize(false);
            // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
            layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
            productsBinding.allProductsList.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
            //  call the constructor of CustomAdapter to send the reference and data to Adapter
            allProductAdapter = new AllProductAdapter(this,this);
            productsBinding.allProductsList.setAdapter(allProductAdapter);

            productsBinding.allProductsList.addOnScrollListener(new PaginationScrollListener(layoutManager) {
                @Override
                protected void loadMoreItems() {
                    if (MY_TOTAL_PAGE > currentPage){
                        isLoading = true;
                        currentPage += 1;
                        getAllProductNext(id,currentPage,50);
                    }
                }

                @Override
                public int getTotalPageCount() {
                    return TOTAL_PAGES;
                }

                @Override
                public boolean isLastPage() {
                    return isLastPage;

                }

                @Override
                public boolean isLoading() {
                    return isLoading;
                }
            });





    }


    private void getAllProduct(int id,int limit,int page){
        if (checkConnection()){
            productsPresenter.attemptGetAllProduct(id,limit,page);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllProductNext(int id,int limit,int page){
        if (checkConnection()){
            productsPresenter.attemptGetAllProduct(id,limit,page);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Products products, int code) {
       productsBinding.viewName.setVisibility(View.GONE);
       productsBinding.viewNumber.setVisibility(View.GONE);
       productsBinding.shimmerViewContainer.stopShimmerAnimation();
       productsBinding.shimmerViewContainer.setVisibility(View.GONE);
       productsBinding.textCategories.setVisibility(View.VISIBLE);
       productsBinding.numberOfProducts.setVisibility(View.VISIBLE);
        List<ProductDatum> contentList = products.getData();
        for (ProductDatum content : contentList){
            count += 1;
        }
        productsBinding.textCategories.setText(getIntent().getStringExtra("name"));
        productsBinding.numberOfProducts.setText(count+" Products");
        if (products != null) MY_TOTAL_PAGE = products.getMeta().getLastPage();
        if (currentPage > 1) {
            isLoading = false;
            allProductAdapter.removeLoadingFooter();
        }
        if (products.getData() != null) {
            if (products.getData().size() > 0) {
                allProductAdapter.setAllProductDataList(products.getData(), currentPage);
            } else {
                if (allProductAdapter != null) allProductAdapter.clear();
                Toasty.info(this, "No data found", Toasty.LENGTH_SHORT).show();


            }
        }
    }

    @Override
    public void onError(String error, int code) {
        if (currentPage == 1){
            Toasty.error(this, "Data not found", Toasty.LENGTH_SHORT).show();
        }else {
            isLoading = false;
            allProductAdapter.removeLoadingFooter();
            Toasty.error(this, error, Toasty.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNewProductSuccess(Products products, int code) {

    }

    @Override
    public void onFeaturedProductSuccess(Products products, int code) {

    }

    @Override
    public void onOneProductSuccess(Product product, int code) {

    }

    @Override
    public void retryPageLoad() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        productsBinding.shimmerViewContainer.stopShimmerAnimation();

    }

    @Override
    protected void onResume() {
        super.onResume();
        productsBinding.shimmerViewContainer.startShimmerAnimation();

    }
}