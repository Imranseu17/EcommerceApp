package com.kcsl.ecommerce.ui.wishList;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.FilterActivity;
import com.kcsl.ecommerce.activities.SortByActivity;
import com.kcsl.ecommerce.adapter.WishListAdapter;

import java.util.ArrayList;

public class WishListFragment extends Fragment {

    RecyclerView productDesignList1;
    RecyclerView  productDesignList2;
    RecyclerView  productDesignList3;
    RecyclerView  productDesignList4;

    ArrayList<String> productDesignName_one;
    ArrayList<String> productDesignName_two;
    ArrayList<String> productDesignName_three;
    ArrayList<String> productDesignName_four;

    ArrayList<String> productDesignPrice_one;
    ArrayList<String> productDesignPrice_two;
    ArrayList<String> productDesignPrice_three;
    ArrayList<String> productDesignPrice_four;

    ArrayList<String> productDesignOldPrice_one;
    ArrayList<String> productDesignOldPrice_two;
    ArrayList<String> productDesignOldPrice_three;
    ArrayList<String> productDesignOldPrice_four;

    ArrayList<String> productDesignPercentege_one;
    ArrayList<String> productDesignPercentege_two;
    ArrayList<String> productDesignPercentege_three;
    ArrayList<String> productDesignPercentege_four;

    LinearLayout sortBy,filter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getContext() fragment
        View v =  inflater.inflate(R.layout.fragment_wish_list, container, false);
        productDesignList1 = v.findViewById(R.id.product_design_list_one);
        productDesignList2 =v.findViewById(R.id.product_design_list_two);
        productDesignList3 = v.findViewById(R.id.product_design_list_three);
        productDesignList4 = v.findViewById(R.id.product_design_list_four);
        sortBy = v.findViewById(R.id.sort_by_layout);
        filter = v.findViewById(R.id.filter);


        sortBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SortByActivity.class));
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FilterActivity.class));
            }
        });

        getAllProductDataList();
        return  v;
    }

    private void getAllProductDataList()
    {
        productDesignName_one = new ArrayList<>();
        productDesignName_two = new ArrayList<>();
        productDesignName_three = new ArrayList<>();
        productDesignName_four = new ArrayList<>();

        productDesignPrice_one = new ArrayList<>();
        productDesignPrice_two = new ArrayList<>();
        productDesignPrice_three = new ArrayList<>();
        productDesignPrice_four = new ArrayList<>();

        productDesignOldPrice_one = new ArrayList<>();
        productDesignOldPrice_two = new ArrayList<>();
        productDesignOldPrice_three = new ArrayList<>();
        productDesignOldPrice_four = new ArrayList<>();

        productDesignPercentege_one = new ArrayList<>();
        productDesignPercentege_two = new ArrayList<>();
        productDesignPercentege_three = new ArrayList<>();
        productDesignPercentege_four = new ArrayList<>();

        productDesignPercentege_one.add("-60%");
        productDesignPercentege_one.add("-50%");
        productDesignPercentege_one.add("-40%");
        productDesignPercentege_one.add("-30%");

        productDesignPercentege_two.add("-60%");
        productDesignPercentege_two.add("-50%");
        productDesignPercentege_two.add("-40%");
        productDesignPercentege_two.add("-30%");

        productDesignPercentege_three.add("-60%");
        productDesignPercentege_three.add("-50%");
        productDesignPercentege_three.add("-40%");
        productDesignPercentege_three.add("-30%");

        productDesignPercentege_four.add("-60%");
        productDesignPercentege_four.add("-50%");
        productDesignPercentege_four.add("-40%");
        productDesignPercentege_four.add("-30%");

        productDesignName_one.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_one.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_one.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_one.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_two.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_two.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_two.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_two.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_three.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_three.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_three.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_three.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignName_four.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_four.add("Tommy Hilfiger padded \n jackets - black with...");
        productDesignName_four.add("DKNY t-shirt - colour \n block front logo");
        productDesignName_four.add("Tommy Hilfiger padded \n jackets - black with...");

        productDesignPrice_one.add("BDT 19");
        productDesignPrice_one.add("BDT 55");
        productDesignPrice_one.add("BDT 19");
        productDesignPrice_one.add("BDT 55");

        productDesignPrice_two.add("BDT 19");
        productDesignPrice_two.add("BDT 55");
        productDesignPrice_two.add("BDT 19");
        productDesignPrice_two.add("BDT 55");

        productDesignPrice_three.add("BDT 19");
        productDesignPrice_three.add("BDT 55");
        productDesignPrice_three.add("BDT 19");
        productDesignPrice_three.add("BDT 55");

        productDesignPrice_four.add("BDT 19");
        productDesignPrice_four.add("BDT 55");
        productDesignPrice_four.add("BDT 19");
        productDesignPrice_four.add("BDT 55");


        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");
        productDesignOldPrice_one.add("BDT69");

        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");
        productDesignOldPrice_two.add("BDT110");

        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");
        productDesignOldPrice_three.add("BDT69");

        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");
        productDesignOldPrice_four.add("BDT110");


        productDesignList1.setHasFixedSize(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList1.setLayoutManager(layoutManager1);
        WishListAdapter wishListAdapter1 = new WishListAdapter(getContext(),productDesignPercentege_one,
                productDesignName_one,productDesignPrice_one,productDesignOldPrice_one);
        productDesignList1.setAdapter(wishListAdapter1);

        productDesignList2.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList2.setLayoutManager(layoutManager2);
        WishListAdapter wishListAdapter2 = new WishListAdapter(getContext(),productDesignPercentege_two,
                productDesignName_two,productDesignPrice_two,productDesignOldPrice_two);
        productDesignList2.setAdapter(wishListAdapter2);

        productDesignList3.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList3.setLayoutManager(layoutManager3);
        WishListAdapter wishListAdapter3 = new WishListAdapter(getContext(),productDesignPercentege_three,
                productDesignName_three,productDesignPrice_three,productDesignOldPrice_three);
        productDesignList3.setAdapter(wishListAdapter3);

        productDesignList4.setHasFixedSize(false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList4.setLayoutManager(layoutManager4);
        WishListAdapter wishListAdapter4 = new WishListAdapter(getContext(),productDesignPercentege_four,
                productDesignName_four,productDesignPrice_four,productDesignOldPrice_four);
        productDesignList4.setAdapter(wishListAdapter4);
    }
}