package com.kcsl.ecommerce.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.AllProductAdapter;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.databinding.ActivitySearchProductBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.ProductDatum;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.FeaturedProductsPresenter;
import com.kcsl.ecommerce.presenters.NewProductsPresenter;
import com.kcsl.ecommerce.presenters.ProductsPresenter;
import com.kcsl.ecommerce.utils.DebugLog;
import com.kcsl.ecommerce.utils.PaginationScrollListener;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class SearchProductActivity extends AppCompatActivity implements ProductsUserView {


    ActivitySearchProductBinding searchProductBinding;
    ProductsPresenter productsPresenter;

    AllProductAdapter allProductAdapter;
    GridLayoutManager layoutManager;

    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 5;
    private int MY_TOTAL_PAGE = 0;
    private int currentPage = PAGE_START;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        searchProductBinding = DataBindingUtil. setContentView(this,R.layout.activity_search_product);
        productsPresenter = new ProductsPresenter(this);
        searchProductBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(SearchProductActivity.this);
                finish();
            }
        });

        viewConfig();

        searchProductBinding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!searchProductBinding.floatingSearchView.getQuery().trim().matches(""))
                    getAllProductByName(currentPage,50);

                else
                    Toasty.info(SearchProductActivity.this,"Please input first",Toasty.LENGTH_SHORT).show();
            }
        });

        searchProductBinding.floatingSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {

                if(!searchProductBinding.floatingSearchView.getQuery().trim().matches(""))
                    getAllProductByName(currentPage,50);

            }
        });

        searchProductBinding.floatingSearchView.setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.action_voice_rec) {
                    recordSpeech();
                    if(!searchProductBinding.floatingSearchView.getQuery().trim().matches(""))
                        getAllProductByName(currentPage,50);


                }
            }
        });

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    private void recordSpeech() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {

            startActivityForResult(intent, 1);
        } catch (Exception e) {
            Toasty.info(this, "Your device does not support Speech recognizer", Toasty.LENGTH_SHORT).show();
        }

    }

    private void  viewConfig(){

            searchProductBinding.allProductsList.setHasFixedSize(false);
            // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
            layoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
            searchProductBinding.allProductsList.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
            //  call the constructor of CustomAdapter to send the reference and data to Adapter
            allProductAdapter = new AllProductAdapter(this,this);
            searchProductBinding.allProductsList.setAdapter(allProductAdapter);

            searchProductBinding.allProductsList.addOnScrollListener(new PaginationScrollListener(layoutManager) {
                @Override
                protected void loadMoreItems() {
                    if (MY_TOTAL_PAGE > currentPage){
                        isLoading = true;
                        currentPage += 1;
                        getAllProductByNameNext(currentPage,50);
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


    private void getAllProductByName(int page,int limit){
        if (checkConnection()){
            String name = searchProductBinding.floatingSearchView.getQuery();
            DebugLog.e(name);
            productsPresenter.attemptGetProductByName(name,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllProductByNameNext(int page,int limit){
        if (checkConnection()){
            String name = searchProductBinding.floatingSearchView.getQuery();
            productsPresenter.attemptGetProductByName(name,page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }




    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Products products, int code) {
        hideSoftKeyboard(SearchProductActivity.this);
        searchProductBinding.viewName.setVisibility(View.GONE);
        searchProductBinding.viewNumber.setVisibility(View.GONE);
        searchProductBinding.shimmerViewContainer.stopShimmerAnimation();
        searchProductBinding.shimmerViewContainer.setVisibility(View.GONE);
        searchProductBinding.textCategories.setVisibility(View.VISIBLE);
        searchProductBinding.numberOfProducts.setVisibility(View.VISIBLE);
        searchProductBinding.numberOfProducts.setText(products.getData().size()+" Products");
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
            Toasty.error(this,error,Toasty.LENGTH_SHORT).show();
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
               searchProductBinding.floatingSearchView.setSearchText(text.get(0));
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        searchProductBinding.shimmerViewContainer.stopShimmerAnimation();

    }

    @Override
    protected void onResume() {
        super.onResume();
        searchProductBinding.shimmerViewContainer.startShimmerAnimation();

    }
}