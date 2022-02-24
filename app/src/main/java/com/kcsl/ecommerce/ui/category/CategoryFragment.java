package com.kcsl.ecommerce.ui.category;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.AllCategoryActivity;
import com.kcsl.ecommerce.activities.AllProductActivity;
import com.kcsl.ecommerce.adapter.CategoriesAdapter;
import com.kcsl.ecommerce.adapter.NumberOfCategoriesAdapter;
import com.kcsl.ecommerce.adapter.NumberOfProductAdapter;
import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.dialog.CustomAlertDialog;
import com.kcsl.ecommerce.models.Categories;
import com.kcsl.ecommerce.models.Product;
import com.kcsl.ecommerce.models.Products;
import com.kcsl.ecommerce.presenters.CategoriesPresenter;
import com.kcsl.ecommerce.presenters.FeaturedProductsPresenter;
import com.kcsl.ecommerce.presenters.NewProductsPresenter;

import java.util.ArrayList;
import java.util.Arrays;


public class CategoryFragment extends Fragment implements CategoriesUserView, ProductsUserView {

        View root;
        private CategoriesPresenter categoriesPresenter;
        RecyclerView categoriesList;
        TextView allCategories;
        ShimmerFrameLayout shimmerFrameLayoutCategories;
    RecyclerView new_products_list,featured_products_list;

    TextView textForYou,textPopularItem;

    private NewProductsPresenter newProductsPresenter;
    private FeaturedProductsPresenter featuredProductsPresenter;
    TextView newAllProduct,featuredAllProduct;
    ShimmerFrameLayout shimmerFrameLayoutProduct;
    LinearLayout featureProducts;

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
        featureProducts = root.findViewById(R.id.featuredProducts);
        new_products_list = root.findViewById(R.id.new_products_list);
        shimmerFrameLayoutCategories = root.findViewById(R.id.shimmer_view_container1);
        newAllProduct = root.findViewById(R.id.newAllProduct);
        featuredAllProduct = root.findViewById(R.id.featuredAllProduct);
        featured_products_list = root.findViewById(R.id.featured_products_list);
        shimmerFrameLayoutProduct = root.findViewById(R.id.shimmer_view_container);
        textForYou = root.findViewById(R.id.textForYou);
        textPopularItem = root.findViewById(R.id.textPopularItem);

        categoriesPresenter = new CategoriesPresenter(this);
        newProductsPresenter = new NewProductsPresenter(this);
        featuredProductsPresenter = new FeaturedProductsPresenter(this);
        getAllCategories();
        allCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AllCategoryActivity.class));
            }
        });
        getAllNewProducts();
        getAllFeaturedProducts();
        newAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("HeaderName",textForYou.getText().toString().trim());
                startActivity(intent);

            }
        });
        featuredAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("HeaderName",textPopularItem.getText().toString().trim());
                startActivity(intent);
            }
        });
        return root;
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
    public void onSuccess(Categories categories, int code) {
        shimmerFrameLayoutCategories.stopShimmerAnimation();
        shimmerFrameLayoutCategories.setVisibility(View.GONE);
        categoriesList.setVisibility(View.VISIBLE);
        categoriesList.setHasFixedSize(false);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);;
       categoriesList.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfCategoriesAdapter numberOfCategoriesAdapter = new NumberOfCategoriesAdapter
                (getContext(),categories.getData(),categoriesImages);
        categoriesList.setAdapter(numberOfCategoriesAdapter);

    }

    @Override
    public void onSuccess(Products products, int code) {

    }

    @Override
    public void onError(String error, int code) {

      CustomAlertDialog.showError(getContext(),error);

    }

    @Override
    public void onNewProductSuccess(Products products, int code) {
        shimmerFrameLayoutProduct.stopShimmerAnimation();
        shimmerFrameLayoutProduct.setVisibility(View.GONE);
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
        shimmerFrameLayoutCategories.stopShimmerAnimation();
        shimmerFrameLayoutProduct.stopShimmerAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayoutCategories.stopShimmerAnimation();
        shimmerFrameLayoutProduct.stopShimmerAnimation();
    }
}