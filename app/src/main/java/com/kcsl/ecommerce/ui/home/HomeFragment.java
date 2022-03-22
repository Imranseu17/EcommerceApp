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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.kcsl.ecommerce.activities.AllProductActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.CategoryActivity;
import com.kcsl.ecommerce.activities.FlashSellActivity;
import com.kcsl.ecommerce.activities.FollowActivity;
import com.kcsl.ecommerce.activities.NewUserGiftActivity;
import com.kcsl.ecommerce.activities.TradingActivity;
import com.kcsl.ecommerce.activities.WorkSpaceActivity;
import com.kcsl.ecommerce.adapter.AdjustListAdapter;
import com.kcsl.ecommerce.adapter.BannerListAdapter;
import com.kcsl.ecommerce.adapter.CategoriesTitleAdapter;
import com.kcsl.ecommerce.adapter.ExtraCategoriesAdapter;
import com.kcsl.ecommerce.adapter.FlashCellProductAdapter;
import com.kcsl.ecommerce.adapter.FlashSellAdapter;
import com.kcsl.ecommerce.adapter.FollowDesignAdapter;
import com.kcsl.ecommerce.adapter.MainCategoriesAdapter;
import com.kcsl.ecommerce.adapter.NewUserGiftAdapter;
import com.kcsl.ecommerce.adapter.NumberOfCategoriesAdapter;
import com.kcsl.ecommerce.adapter.NumberOfProductAdapter;
import com.kcsl.ecommerce.adapter.ProductDesignAdapter;
import com.kcsl.ecommerce.adapter.TrandingAdapter;
import com.kcsl.ecommerce.adapter.WorkSpaceAdapter;
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

public class HomeFragment extends Fragment implements ProductsUserView, CategoriesUserView {

    private HomeViewModel homeViewModel;
    View root;
    RecyclerView new_products_list,featured_products_list,recyclerViewFlash;
    private NewProductsPresenter newProductsPresenter;
    private FeaturedProductsPresenter featuredProductsPresenter;
    TextView newAllProduct,featuredAllProduct;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout featureProducts;

    TextView textNewProduct,textFeaturedProduct;

    private CategoriesPresenter categoriesPresenter;
    RecyclerView categoriesList;

    ArrayList<String> categoriesTitleList;
    RecyclerView categoryTitleList;

    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.item,R.drawable.item,R.drawable.item,R.drawable.item));

    ArrayList categoriesImages =
            new ArrayList<>(Arrays.asList(R.drawable.logo_1,R.drawable.logo_2,R.drawable.logo_3,
                    R.drawable.logo_4,R.drawable.logo_5,R.drawable.logo_6,
                    R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9, R.drawable.logo_10));

    ArrayList bannerImages =
            new ArrayList<>(Arrays.asList(R.drawable.banner_image,R.drawable.banner_image_1,R.drawable.banner_image_1,
                    R.drawable.banner_image,R.drawable.banner_image));
    RecyclerView bannerList;

    ArrayList categoryMainImages =
            new ArrayList<>(Arrays.asList(R.drawable.apparel,R.drawable.beauty,R.drawable.eletronics,
                    R.drawable.furniture,R.drawable.kitchen_layout,R.drawable.gift,
                    R.drawable.computer, R.drawable.gadget, R.drawable.vegetable, R.drawable.fashion));
    RecyclerView mainCategoriesList;
    ArrayList<String> mainCategoriesTitle;

    ArrayList<String> newGiftProductParcentege;
    ArrayList<String> newGiftProductName;
    ArrayList<String> newGiftProductPrice;
    ArrayList<String> newGiftProductOldPrice;
    RecyclerView newGiftProductList;

    RecyclerView categoryListMore;
    RecyclerView mainCategoryListMore;

    ArrayList<String> adjustableName;
    ArrayList<String> adjustableContent;
    ArrayList<String> adjustableRating;

    RecyclerView adjustableList;

    RecyclerView flashCellList;
    ArrayList flashCellImages =
            new ArrayList<>(Arrays.asList(R.drawable.nike_air_max,R.drawable.new_nike_air,R.drawable.nike_air_max,
                    R.drawable.new_nike_air,R.drawable.nike_air_max));

    RecyclerView trandingList;
    ArrayList trandingImages =
            new ArrayList<>(Arrays.asList(R.drawable.smart_watch,R.drawable.headphone,R.drawable.image_chair,
                    R.drawable.smart_watch,R.drawable.image_chair));
    ArrayList<String> trandingName;


    RecyclerView workspaceList;
    ArrayList workspaceImages =
            new ArrayList<>(Arrays.asList(R.drawable.workspace_computer,R.drawable.workspace_marketer,R.drawable.workspace_computer,
                    R.drawable.workspace_marketer,R.drawable.workspace_computer));
    ArrayList<String> workspaceName;
    ArrayList<String> workspaceContent;

    RecyclerView extraCategoriesList;
    ArrayList<String> extraCategoriesName;
    ArrayList extraCategoriesImages =
            new ArrayList<>(Arrays.asList(R.drawable.home_icon_silhouette,
                    R.drawable.hearts,R.drawable.free_shipping,
                    R.drawable.e_mail,R.drawable.global_navigation));

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

    ArrayList newUserGiftImages =
            new ArrayList<>(Arrays.asList(R.drawable.dkny,R.drawable.tommy,R.drawable.dkny,
                    R.drawable.tommy,R.drawable.dkny));

    ArrayList<String> follow_name;
    ArrayList<String> follow_title;
    RecyclerView follow_list;
    ArrayList followImages =  new ArrayList<>(Arrays.asList(R.drawable.vegetablespixel,R.drawable.grocery_shop,
            R.drawable.vegetablespixel,R.drawable.grocery_shop,R.drawable.vegetablespixel));

    LinearLayout flash_cell_title_all,workspace_all_data,gift_title_all_data,
            trading_title_all_data,category_title_all_data,all_follow_list;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        root =  inflater.inflate(R.layout.fragment_home, container, false);
        newGiftProductList = root.findViewById(R.id.gift_list);
        mainCategoriesList = root.findViewById(R.id.main_category_list);
        categoryTitleList = root.findViewById(R.id.category_title_list);
        bannerList = root.findViewById(R.id.banner_list);
        featureProducts = root.findViewById(R.id.featuredProductText);
        new_products_list = root.findViewById(R.id.new_products_list);
        recyclerViewFlash = root.findViewById(R.id.recyclerFlash);
        newAllProduct = root.findViewById(R.id.newAllProduct);
        featuredAllProduct = root.findViewById(R.id.featuredAllProduct);
        featured_products_list = root.findViewById(R.id.featured_products_list);
        shimmerFrameLayout = root.findViewById(R.id.shimmer_view_container);
        categoriesList = root.findViewById(R.id.category_list);
        textNewProduct = root.findViewById(R.id.newProductText);
        textFeaturedProduct = root.findViewById(R.id.textfeatured);
        categoryListMore = root.findViewById(R.id.category_list_more);
        mainCategoryListMore = root.findViewById(R.id.main_category_list_more);
        adjustableList = root.findViewById(R.id.adjustable_list);
        flashCellList = root.findViewById(R.id.flash_cell_list);
        trandingList = root.findViewById(R.id.trending_list);
        workspaceList = root.findViewById(R.id.workspace_list);
        extraCategoriesList = root.findViewById(R.id.extra_categories_list);
        productDesignList1 = root.findViewById(R.id.product_design_list_one);
        productDesignList2 = root.findViewById(R.id.product_design_list_two);
        productDesignList3 = root.findViewById(R.id.product_design_list_three);
        productDesignList4 = root.findViewById(R.id.product_design_list_four);
        follow_list = root.findViewById(R.id.follow_list);
        flash_cell_title_all = root.findViewById(R.id.flash_title_all);
        workspace_all_data = root.findViewById(R.id.workspace_title_all);
        gift_title_all_data = root.findViewById(R.id.gift_title_all);
        trading_title_all_data = root.findViewById(R.id.trending_title_all);
        category_title_all_data = root.findViewById(R.id.category_title_all);
        all_follow_list = root.findViewById(R.id.all_follow_list);

        newProductsPresenter = new NewProductsPresenter(this);
        featuredProductsPresenter = new FeaturedProductsPresenter(this);
        categoriesPresenter = new CategoriesPresenter(this);

       getAllCategoriesTitle();
        getAllCategories();
        getAllBanner();
        getMainCategoryList();
        getAllGiftList();
        getAllAdjustableList();
        getAllFlashList();
        getAllTranding();
        getAllWorkspaces();
        getAllFollowList();
        getAllExtraCategory();
        getAllProductDataList();
        getAllFlash();
        getAllNewProducts();
        getAllFeaturedProducts();

        flash_cell_title_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FlashSellActivity.class));
            }
        });

        newAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("HeaderName",textNewProduct.getText().toString().trim());
                startActivity(intent);

            }
        });
        featuredAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllProductActivity.class);
                intent.putExtra("HeaderName",textFeaturedProduct.getText().toString().trim());
                startActivity(intent);
            }
        });

        workspace_all_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), WorkSpaceActivity.class));
            }
        });
        gift_title_all_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewUserGiftActivity.class));
            }
        });
        trading_title_all_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), TradingActivity.class));
            }
        });
        category_title_all_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CategoryActivity.class));
            }
        });
        all_follow_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FollowActivity.class));
            }
        });
        return  root;
    }

    private void getAllCategoriesTitle()
    {
        categoriesTitleList = new ArrayList<>();
        categoryTitleList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryTitleList.setLayoutManager(layoutManager);
        categoriesTitleList.add("All");
        categoriesTitleList.add("Beauty");
        categoriesTitleList.add("Woman's Fashion");
        categoriesTitleList.add("Man's Fashion");
        categoriesTitleList.add("Others");
        CategoriesTitleAdapter categoriesTitleAdapter = new CategoriesTitleAdapter(getContext(),categoriesTitleList);
        categoryTitleList.setAdapter(categoriesTitleAdapter);
    }

    private void getAllGiftList()
    {
        newGiftProductParcentege = new ArrayList<>();
        newGiftProductName = new ArrayList<>();
        newGiftProductPrice = new ArrayList<>();
        newGiftProductOldPrice = new ArrayList<>();

        newGiftProductParcentege.add("-60%");
        newGiftProductParcentege.add("-50%");
        newGiftProductParcentege.add("-40%");
        newGiftProductParcentege.add("-30%");
        newGiftProductParcentege.add("-20%");

        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");
        newGiftProductName.add("Tommy Hilfiger padded \n jackets - black with...");
        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");
        newGiftProductName.add("Tommy Hilfiger padded \n jackets - black with...");
        newGiftProductName.add("DKNY t-shirt - colour \n block front logo");

        newGiftProductPrice.add("BDT 19");
        newGiftProductPrice.add("BDT 55");
        newGiftProductPrice.add("BDT 19");
        newGiftProductPrice.add("BDT 55");
        newGiftProductPrice.add("BDT 19");

        newGiftProductOldPrice.add("BDT69");
        newGiftProductOldPrice.add("BDT110");
        newGiftProductOldPrice.add("BDT69");
        newGiftProductOldPrice.add("BDT110");
        newGiftProductOldPrice.add("BDT69");

        newGiftProductList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        newGiftProductList.setLayoutManager(layoutManager);

       NewUserGiftAdapter newUserGiftAdapter = new NewUserGiftAdapter(getContext(),newGiftProductParcentege,
               newGiftProductName,newGiftProductPrice,newGiftProductOldPrice,newUserGiftImages);
        newGiftProductList.setAdapter(newUserGiftAdapter);
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
        ProductDesignAdapter productDesignAdapter1 = new ProductDesignAdapter(getContext(),productDesignPercentege_one,
                productDesignName_one,productDesignPrice_one,productDesignOldPrice_one);
        productDesignList1.setAdapter(productDesignAdapter1);

        productDesignList2.setHasFixedSize(false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList2.setLayoutManager(layoutManager2);
        ProductDesignAdapter productDesignAdapter2 = new ProductDesignAdapter(getContext(),productDesignPercentege_two,
                productDesignName_two,productDesignPrice_two,productDesignOldPrice_two);
        productDesignList2.setAdapter(productDesignAdapter2);

        productDesignList3.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList3.setLayoutManager(layoutManager3);
        ProductDesignAdapter productDesignAdapter3 = new ProductDesignAdapter(getContext(),productDesignPercentege_three,
                productDesignName_three,productDesignPrice_three,productDesignOldPrice_three);
        productDesignList3.setAdapter(productDesignAdapter3);

        productDesignList4.setHasFixedSize(false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        productDesignList4.setLayoutManager(layoutManager4);
        ProductDesignAdapter productDesignAdapter4 = new ProductDesignAdapter(getContext(),productDesignPercentege_four,
                productDesignName_four,productDesignPrice_four,productDesignOldPrice_four);
        productDesignList4.setAdapter(productDesignAdapter4);
    }

    private void getAllBanner()
    {
        bannerList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        bannerList.setLayoutManager(layoutManager);
        BannerListAdapter bannerListAdapter = new BannerListAdapter(getContext(),bannerImages);
       bannerList.setAdapter(bannerListAdapter);
    }

    private void getMainCategoryList()
    {
        mainCategoriesTitle = new ArrayList<>();
        mainCategoriesList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mainCategoriesList.setLayoutManager(layoutManager);
        mainCategoriesTitle.add("Apparel");
        mainCategoriesTitle.add("Beauty");
        mainCategoriesTitle.add("Electronics");
        mainCategoriesTitle.add("Furniture");
        mainCategoriesTitle.add("Kitchen");
        mainCategoriesTitle.add("Gift");
        mainCategoriesTitle.add("Computer");
        mainCategoriesTitle.add("Gadget");
        mainCategoriesTitle.add("Vegetable");
        mainCategoriesTitle.add("Fashion");
        MainCategoriesAdapter mainCategoriesAdapter = new MainCategoriesAdapter(getContext(),mainCategoriesTitle,categoryMainImages);
        mainCategoriesList.setAdapter(mainCategoriesAdapter);

        mainCategoriesList.setHasFixedSize(false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mainCategoryListMore.setLayoutManager(layoutManager1);
        MainCategoriesAdapter mainCategoriesAdapter1 = new MainCategoriesAdapter(getContext(),mainCategoriesTitle,categoryMainImages);
        mainCategoryListMore.setAdapter(mainCategoriesAdapter1);
    }





    private void getAllFlash(){
        recyclerViewFlash.setHasFixedSize(false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFlash.setLayoutManager(layoutManager3);
        FlashSellAdapter flashSellAdapter = new FlashSellAdapter(images,getContext());
        recyclerViewFlash.setAdapter(flashSellAdapter);
    }

    private void getAllAdjustableList()
    {
        adjustableName = new ArrayList<>();
        adjustableContent = new ArrayList<>();
        adjustableRating = new ArrayList<>();
        adjustableList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adjustableList.setLayoutManager(layoutManager);

        adjustableName.add("Adjustable Office Chair");
        adjustableName.add("Adjustable Office Chair");
        adjustableName.add("Adjustable Office Chair");
        adjustableName.add("Adjustable Office Chair");
        adjustableName.add("Adjustable Office Chair");

        adjustableContent.add("Hughlan Workspaces");
        adjustableContent.add("Hughlan Workspaces");
        adjustableContent.add("Hughlan Workspaces");
        adjustableContent.add("Hughlan Workspaces");
        adjustableContent.add("Hughlan Workspaces");

        adjustableRating.add("4.8");
        adjustableRating.add("3.8");
        adjustableRating.add("2.8");
        adjustableRating.add("1.8");
        adjustableRating.add("5.8");



        AdjustListAdapter adjustListAdapter = new AdjustListAdapter(getContext(),adjustableName,adjustableContent,adjustableRating);
        adjustableList.setAdapter(adjustListAdapter);
    }

    private void getAllTranding()
    {
        trandingName = new ArrayList<>();
        trandingList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        trandingList.setLayoutManager(layoutManager);
        trandingName.add("Smart Watch");
        trandingName.add("Headsets");
        trandingName.add("Ergonomic Chair");
        trandingName.add("Smart Watch");
        trandingName.add("Ergonomic Chair");
        TrandingAdapter trandingAdapter  = new TrandingAdapter(getContext(),trandingImages,trandingName);
        trandingList.setAdapter(trandingAdapter);
    }

    private void getAllWorkspaces()
    {
        workspaceName = new ArrayList<>();
        workspaceContent = new ArrayList<>();
        workspaceList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        workspaceList.setLayoutManager(layoutManager);
        workspaceName.add("Developer");
        workspaceName.add("Marketer");
        workspaceName.add("Developer");
        workspaceName.add("Marketer");
        workspaceName.add("Developer");
        workspaceContent.add("21 suggested items");
        workspaceContent.add("19 suggested items");
        workspaceContent.add("21 suggested items");
        workspaceContent.add("19 suggested items");
        workspaceContent.add("21 suggested items");
        WorkSpaceAdapter workSpaceAdapter = new WorkSpaceAdapter(getContext(),workspaceImages,workspaceName,workspaceContent);
        workspaceList.setAdapter(workSpaceAdapter);
    }

    private void getAllExtraCategory()
    {
        extraCategoriesName = new ArrayList<>();
        extraCategoriesList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        extraCategoriesList.setLayoutManager(layoutManager);
        extraCategoriesName.add("All");
        extraCategoriesName.add("Valentine’s");
        extraCategoriesName.add("Free Shipping");
        extraCategoriesName.add("E-Mall");
        extraCategoriesName.add("E-Global");
        ExtraCategoriesAdapter extra_categories_adapter =
                new ExtraCategoriesAdapter(getContext(),extraCategoriesImages,extraCategoriesName);
        extraCategoriesList.setAdapter(extra_categories_adapter);
    }

    private void getAllFollowList() {
        follow_name = new ArrayList<>();
        follow_title = new ArrayList<>();
        follow_list.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        follow_list.setLayoutManager(layoutManager);
        follow_name.add("E-One Store");
        follow_name.add("Groceries store");
        follow_name.add("E-One Store");
        follow_name.add("Groceries store");
        follow_name.add("E-One Store");
        follow_title.add("T");
        follow_title.add("A");
        follow_title.add("T");
        follow_title.add("A");
        follow_title.add("T");
       FollowDesignAdapter followDesignAdapter = new FollowDesignAdapter(getContext(),
               followImages,follow_name,follow_title);
        follow_list.setAdapter(followDesignAdapter);

    }

    private void getAllFlashList()
    {
        flashCellList.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        flashCellList.setLayoutManager(layoutManager);
        FlashCellProductAdapter flashCellProductAdapter = new FlashCellProductAdapter(getContext(),flashCellImages);
        flashCellList.setAdapter(flashCellProductAdapter);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoriesList.setLayoutManager(layoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfCategoriesAdapter numberOfCategoriesAdapter = new NumberOfCategoriesAdapter(getContext(),categories.getData(),categoriesImages);
        categoriesList.setAdapter(numberOfCategoriesAdapter);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        categoryListMore.setLayoutManager(layoutManager1); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        NumberOfCategoriesAdapter numberOfCategoriesAdapter1 = new NumberOfCategoriesAdapter(getContext(),categories.getData(),categoriesImages);
        categoryListMore.setAdapter(numberOfCategoriesAdapter1);
    }

    @Override
    public void onError(String error, int code) {
        CustomAlertDialog.showError(getContext(),error);
    }

    @Override
    public void onNewProductSuccess(Products products, int code) {
        shimmerFrameLayout.stopShimmerAnimation();
        shimmerFrameLayout.setVisibility(View.GONE);
        new_products_list.setVisibility(View.GONE);
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
        featureProducts.setVisibility(View.GONE);
        featured_products_list.setVisibility(View.GONE);
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