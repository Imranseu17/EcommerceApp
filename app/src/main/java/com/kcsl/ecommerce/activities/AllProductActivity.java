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
import com.kcsl.ecommerce.databinding.ActivityAllProductBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.ProductDatum;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.FeaturedProductsPresenter;
import com.kcsl.ecommerce.presenters.NewProductsPresenter;
import com.kcsl.ecommerce.utils.PaginationScrollListener;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class AllProductActivity extends AppCompatActivity implements ProductsUserView {

    ActivityAllProductBinding allProductBinding;
    NewProductsPresenter newProductsPresenter;
    FeaturedProductsPresenter featuredProductsPresenter;

    AllProductAdapter allProductAdapter;
    GridLayoutManager layoutManager1,layoutManager2;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 5;
    private int MY_TOTAL_PAGE = 0;
    private int currentPage = PAGE_START;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        allProductBinding = DataBindingUtil. setContentView(this, R.layout.activity_all_product);
        newProductsPresenter = new NewProductsPresenter(this);
        featuredProductsPresenter = new FeaturedProductsPresenter (this);
        allProductBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewConfig();

       if(getIntent().getIntExtra("new",0)==1)
           getAllNewProducts(currentPage,50);
       else
           getAllFeaturedProducts(currentPage,50);
    }

    private void  viewConfig(){

       if(getIntent().getIntExtra("new",0)==1){
           //New

           allProductBinding.allProductsList.setHasFixedSize(false);
           // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
           layoutManager1 = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
           allProductBinding.allProductsList.setLayoutManager(layoutManager1); // set LayoutManager to RecyclerView
           //  call the constructor of CustomAdapter to send the reference and data to Adapter
           allProductAdapter = new AllProductAdapter(this,this);
           allProductBinding.allProductsList.setAdapter(allProductAdapter);

           allProductBinding.allProductsList.addOnScrollListener(new PaginationScrollListener(layoutManager1) {
               @Override
               protected void loadMoreItems() {
                   if (MY_TOTAL_PAGE > currentPage){
                       isLoading = true;
                       currentPage += 1;
                       getAllNewProductsNext(currentPage,50);
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
       }else {
           // Featured

           allProductBinding.allProductsList.setHasFixedSize(false);
           // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
           layoutManager2 = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);;
           allProductBinding.allProductsList.setLayoutManager(layoutManager2); // set LayoutManager to RecyclerView
           //  call the constructor of CustomAdapter to send the reference and data to Adapter
           allProductAdapter = new AllProductAdapter(this,this);
           allProductBinding.allProductsList.setAdapter(allProductAdapter);

           allProductBinding.allProductsList.addOnScrollListener(new PaginationScrollListener(layoutManager2) {
               @Override
               protected void loadMoreItems() {
                   if (MY_TOTAL_PAGE > currentPage){
                       isLoading = true;
                       currentPage += 1;
                       getAllFeaturedProductsNext(currentPage,50);
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





    }


    private void getAllNewProducts(int page,int limit){
        if (checkConnection()){
            newProductsPresenter.attemptGetNewProducts(1,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllNewProductsNext(int page,int limit){
        if (checkConnection()){
            newProductsPresenter.attemptGetNewProducts(1,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllFeaturedProducts(int page,int limit){
        if (checkConnection()){
            featuredProductsPresenter.attemptGetFeaturedProducts(1,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllFeaturedProductsNext(int page,int limit){
        if (checkConnection()){
            featuredProductsPresenter.attemptGetFeaturedProducts(1,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    @Override
    public void onSuccess(Products products, int code) {

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
        allProductBinding.viewName.setVisibility(View.GONE);
        allProductBinding.viewNumber.setVisibility(View.GONE);
        allProductBinding.shimmerViewContainer.stopShimmerAnimation();
        allProductBinding.shimmerViewContainer.setVisibility(View.GONE);
        allProductBinding.textCategories.setVisibility(View.VISIBLE);
        allProductBinding.numberOfProducts.setVisibility(View.VISIBLE);
        List<ProductDatum> contentList = products.getData();
        for (ProductDatum content : contentList){
            count += 1;
        }
        allProductBinding.textCategories.setText(" New Product");
        allProductBinding.numberOfProducts.setText(count+" Products");
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
    public void onFeaturedProductSuccess(Products products, int code) {
        allProductBinding.viewName.setVisibility(View.GONE);
        allProductBinding.viewNumber.setVisibility(View.GONE);
        allProductBinding.shimmerViewContainer.stopShimmerAnimation();
        allProductBinding.shimmerViewContainer.setVisibility(View.GONE);
        allProductBinding.textCategories.setVisibility(View.VISIBLE);
        allProductBinding.numberOfProducts.setVisibility(View.VISIBLE);
        List<ProductDatum> contentList = products.getData();
        for (ProductDatum content : contentList){
            count += 1;
        }
        allProductBinding.textCategories.setText(" Featured Product");
        allProductBinding.numberOfProducts.setText(count+" Products");
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
                Toasty.info(this, "No data found", Toast.LENGTH_LONG).show();


            }
        }
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
        allProductBinding.shimmerViewContainer.stopShimmerAnimation();

    }

    @Override
    protected void onResume() {
        super.onResume();
        allProductBinding.shimmerViewContainer.startShimmerAnimation();

    }


}