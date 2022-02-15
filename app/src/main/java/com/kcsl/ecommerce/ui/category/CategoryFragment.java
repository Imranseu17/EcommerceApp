package com.kcsl.ecommerce.ui.category;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.AllCategoryActivity;
import com.kcsl.ecommerce.adapter.CategoriesAdapter;
import com.kcsl.ecommerce.adapter.NumberOfCategoriesAdapter;
import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.presenters.CategoriesPresenter;

import java.util.ArrayList;
import java.util.Arrays;


public class CategoryFragment extends Fragment implements CategoriesUserView {

        View root;
        private CategoriesPresenter categoriesPresenter;
        RecyclerView categoriesList;
        TextView allCategories;
        ShimmerFrameLayout shimmerFrameLayout;

    ArrayList categoriesImages =
            new ArrayList<>(Arrays.asList(R.drawable.other,R.drawable.home,R.drawable.women,
                    R.drawable.splitac,R.drawable.speakericon,R.drawable.smart_tv,
                    R.drawable.smart_phones, R.drawable.refrigerator, R.drawable.motorbike,
                    R.drawable.microwave_oven));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_category, container, false);
        categoriesList = root.findViewById(R.id.category_list);
        allCategories = root.findViewById(R.id.newAllCategories);
        shimmerFrameLayout = root.findViewById(R.id.shimmer_view_container1);
        categoriesPresenter = new CategoriesPresenter(this);
        getAllCategories();
        allCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AllCategoryActivity.class));
            }
        });
        return root;
    }




    private void getAllCategories(){
        if (checkConnection()){
            categoriesPresenter.attemptGetAllCategories();
        }else  CustomAlertDialog.showError(getContext(),getString(R.string.no_internet_connection));
    }




    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getActivity(). getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Categories categories, int code) {
        shimmerFrameLayout.stopShimmerAnimation();
        shimmerFrameLayout.setVisibility(View.GONE);
        categoriesList.setVisibility(View.VISIBLE);
        categoriesList.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);;
       categoriesList.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CategoriesAdapter numberOfCategoriesAdapter = new CategoriesAdapter(getContext(),categories.getData(),categoriesImages);
        categoriesList.setAdapter(numberOfCategoriesAdapter);

    }

    @Override
    public void onError(String error, int code) {

      CustomAlertDialog.showError(getContext(),error);

    }



    @Override
    public void retryPageLoad() {

    }

    @Override
    public void onPause() {
        super.onPause();
        shimmerFrameLayout.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.stopShimmerAnimation();

    }
}