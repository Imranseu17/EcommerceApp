package com.kcsl.ecommerce.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.kcsl.ecommerce.activities.AllCategoryActivity;
import com.kcsl.ecommerce.activities.AllProductActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.adapter.AllProductAdapter;
import com.kcsl.ecommerce.adapter.FlashSellAdapter;
import com.kcsl.ecommerce.adapter.NumberOfCategoriesAdapter;
import com.kcsl.ecommerce.adapter.NumberOfProductAdapter;
import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.ProductDatum;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.CategoriesPresenter;
import com.kcsl.ecommerce.presenters.FeaturedProductsPresenter;
import com.kcsl.ecommerce.presenters.NewProductsPresenter;
import com.kcsl.ecommerce.utils.PaginationScrollListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment implements ProductsUserView, CategoriesUserView {

    private HomeViewModel homeViewModel;
    View root;
    RecyclerView new_products_list,featured_products_list,recyclerViewFlash;
    private NewProductsPresenter newProductsPresenter;
    private FeaturedProductsPresenter featuredProductsPresenter;
    TextView newAllProduct,featuredAllProduct;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout featureProducts;

    private CategoriesPresenter categoriesPresenter;
    RecyclerView categoriesList;
    TextView allCategories;

    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.item,R.drawable.item,R.drawable.item,R.drawable.item));

    ArrayList categoriesImages =
            new ArrayList<>(Arrays.asList(R.drawable.other,R.drawable.home,R.drawable.women,
                    R.drawable.splitac,R.drawable.speakericon,R.drawable.smart_tv,
                    R.drawable.smart_phones, R.drawable.refrigerator, R.drawable.motorbike));

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        root =  inflater.inflate(R.layout.fragment_home, container, false);
        featureProducts = root.findViewById(R.id.featuredProducts);
        new_products_list = root.findViewById(R.id.new_products_list);
        recyclerViewFlash = root.findViewById(R.id.recyclerFlash);
        newAllProduct = root.findViewById(R.id.newAllProduct);
        featuredAllProduct = root.findViewById(R.id.featuredAllProduct);
        featured_products_list = root.findViewById(R.id.featured_products_list);
        shimmerFrameLayout = root.findViewById(R.id.shimmer_view_container);
        categoriesList = root.findViewById(R.id.category_list);
        allCategories = root.findViewById(R.id.newAllCategories);

        newProductsPresenter = new NewProductsPresenter(this);
        featuredProductsPresenter = new FeaturedProductsPresenter(this);
        categoriesPresenter = new CategoriesPresenter(this);
        ImageSlider imageSlider = root. findViewById(R.id.image_slider);
        List imageList = new  ArrayList<SlideModel>(); // Create image list

        imageList.add(new SlideModel(R.drawable.slider, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.image_1,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.image_2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.image_3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.image_4, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.image_5, ScaleTypes.FIT));


        imageSlider.setImageList(imageList);
        getAllCategories();
        allCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AllCategoryActivity.class));
            }
        });
        recyclerViewFlash.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFlash.setLayoutManager(layoutManager3);
        FlashSellAdapter flashSellAdapter = new FlashSellAdapter(images,getContext());
        recyclerViewFlash.setAdapter(flashSellAdapter);
        getAllNewProducts();
        getAllFeaturedProducts();
        newAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("new",1);
                startActivity(intent);

            }
        });
        featuredAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("featured",0);
                startActivity(intent);
            }
        });
        return  root;
    }

    private void getAllCategories(){
        if (checkConnection()){
            categoriesPresenter.attemptGetAllCategories();
        }else  CustomAlertDialog.showError(getContext(),getString(R.string.no_internet_connection));
    }

    private void getAllNewProducts(){
        if (checkConnection()){
            newProductsPresenter.attemptGetNewProducts(1);
        }else  CustomAlertDialog.showError(getContext(),getString(R.string.no_internet_connection));
    }

    private void getAllFeaturedProducts(){
        if (checkConnection()){
            featuredProductsPresenter.attemptGetFeaturedProducts(1);
        }else  CustomAlertDialog.showError(getContext(),getString(R.string.no_internet_connection));
    }

    private boolean checkConnection() {

        ConnectivityManager cm = (ConnectivityManager) getActivity(). getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onSuccess(Products products, int code) {


    }

    @Override
    public void onSuccess(Categories categories, int code) {
        categoriesList.setVisibility(View.VISIBLE);
        categoriesList.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4, LinearLayoutManager.VERTICAL, false);
        categoriesList.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfCategoriesAdapter numberOfCategoriesAdapter = new NumberOfCategoriesAdapter(getContext(),categories.getData(),categoriesImages);
        categoriesList.setAdapter(numberOfCategoriesAdapter);
    }

    @Override
    public void onError(String error, int code) {
        CustomAlertDialog.showError(getContext(),error);
    }

    @Override
    public void onNewProductSuccess(Products products, int code) {
        shimmerFrameLayout.stopShimmerAnimation();
        shimmerFrameLayout.setVisibility(View.GONE);
        new_products_list.setVisibility(View.VISIBLE);
        // New product List
        new_products_list.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);
        new_products_list.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfProductAdapter numberOfProductAdapter = new NumberOfProductAdapter(getContext(),products.getData());
        new_products_list.setAdapter(numberOfProductAdapter);

    }

    @Override
    public void onFeaturedProductSuccess(Products products, int code) {
        featureProducts.setVisibility(View.VISIBLE);
        featured_products_list.setVisibility(View.VISIBLE);
        // featured product List
        featured_products_list.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);
        featured_products_list.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfProductAdapter numberOfProductAdapter = new NumberOfProductAdapter(getContext(),products.getData());
        featured_products_list.setAdapter(numberOfProductAdapter);
    }

    @Override
    public void onOneProductSuccess(Product product, int code) {

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