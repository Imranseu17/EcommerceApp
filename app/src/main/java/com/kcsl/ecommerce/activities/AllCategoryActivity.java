package com.kcsl.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.AllCategoriesAdapter;
import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.databinding.ActivityAllCategoryBinding;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.models.CategoriesDatum;
import com.kcsl.ecommerce.models.ProductDatum;
import com.kcsl.ecommerce.presenters.CategoriesPresenter;
import com.kcsl.ecommerce.utils.PaginationScrollListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class AllCategoryActivity extends AppCompatActivity implements CategoriesUserView {

   ActivityAllCategoryBinding allCategoryBinding;
    private CategoriesPresenter categoriesPresenter;
    GridLayoutManager gridLayoutManager;
    AllCategoriesAdapter allCategoriesAdapter;


    private static final int PAGE_START = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    // limiting to 5 for this tutorial, since total pages in actual API is very large. Feel free to modify.
    private int TOTAL_PAGES = 5;
    private int MY_TOTAL_PAGE = 0;
    private int currentPage = PAGE_START;
    int count = 0;

    ArrayList categoriesImages =
            new ArrayList<>(Arrays.asList(R.drawable.other,R.drawable.home,R.drawable.women,
                    R.drawable.splitac,R.drawable.speakericon,R.drawable.smart_tv,
                    R.drawable.smart_phones, R.drawable.refrigerator, R.drawable.motorbike,
                    R.drawable.microwave_oven,R.drawable.watch,R.drawable.laptop,
                    R.drawable.desktop,R.drawable.men,R.drawable.ic_baseline_apps_24));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        allCategoryBinding = DataBindingUtil. setContentView(this,R.layout.activity_all_category);
        categoriesPresenter = new CategoriesPresenter(this);
        viewConfig();
        getAllCategories(currentPage,20);
        allCategoryBinding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void  viewConfig(){
       allCategoryBinding. categoriesList.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
       allCategoryBinding. categoriesList.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        allCategoriesAdapter = new AllCategoriesAdapter(this,this,categoriesImages);
       allCategoryBinding. categoriesList.setAdapter(allCategoriesAdapter);

      allCategoryBinding. categoriesList.addOnScrollListener(new PaginationScrollListener(gridLayoutManager) {
            @Override
            protected void loadMoreItems() {
                if (MY_TOTAL_PAGE > currentPage){
                    isLoading = true;
                    currentPage += 1;
                    getAllCategoriesNext(currentPage,20);
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


    private void getAllCategories(int page,int limit){
        if (checkConnection()){
            categoriesPresenter.attemptGetAllCategories(page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }

    private void getAllCategoriesNext(int page,int limit){
        if (checkConnection()){
            categoriesPresenter.attemptGetAllCategories(page,limit);
        }else  CustomAlertDialog.showError(this,getString(R.string.no_internet_connection));
    }


    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) this. getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Categories categories, int code) {
        allCategoryBinding.viewName.setVisibility(View.GONE);
        allCategoryBinding.viewNumber.setVisibility(View.GONE);
        allCategoryBinding.shimmerViewContainer.stopShimmerAnimation();
        allCategoryBinding.shimmerViewContainer.setVisibility(View.GONE);
        allCategoryBinding.textCategories.setVisibility(View.VISIBLE);
        allCategoryBinding.numberOfProducts.setVisibility(View.VISIBLE);
        List<CategoriesDatum> contentList = categories.getData();
        for (CategoriesDatum content : contentList){
            count += 1;
        }
        allCategoryBinding.numberOfProducts.setText(count+" categories");
        if (categories != null) MY_TOTAL_PAGE = categories.getMeta().getLastPage();
        if (currentPage > 1) {
            isLoading = false;
            allCategoriesAdapter.removeLoadingFooter();
        }
        if (categories.getData() != null) {
            if (categories.getData().size() > 0) {
                allCategoriesAdapter.setCategoriesDatumList(categories.getData(), currentPage);
            } else {
                if (allCategoriesAdapter != null) allCategoriesAdapter.clear();
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
            allCategoriesAdapter.removeLoadingFooter();
            Toasty.error(this,error,Toasty.LENGTH_SHORT).show();
        }

    }


    @Override
    public void retryPageLoad() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        allCategoryBinding.shimmerViewContainer.stopShimmerAnimation();

    }

    @Override
    protected void onResume() {
        super.onResume();
        allCategoryBinding.shimmerViewContainer.startShimmerAnimation();

    }
}