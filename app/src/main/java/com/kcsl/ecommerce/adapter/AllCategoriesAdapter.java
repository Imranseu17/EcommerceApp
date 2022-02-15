package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kcsl.ecommerce.activities.ProductsActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.CategoriesUserView;
import com.kcsl.ecommerce.models.CategoriesDatum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllCategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    private List<CategoriesDatum> categoriesDatumList = new ArrayList<>();
    int click;
    CategoriesUserView categoriesUserView;

    ArrayList categoriesImages;

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    private String errorMsg;

    public AllCategoriesAdapter(Context context, CategoriesUserView categoriesUserView, ArrayList categoriesImages) {
        this.context = context;
        this.categoriesUserView = categoriesUserView;
        click = -1;
       this. categoriesImages = categoriesImages;
    }

    public void setCategoriesDatumList(List<CategoriesDatum> categoriesDatumList, int currentPage){
        if (currentPage == 1){
            if(this.categoriesDatumList != null) this.categoriesDatumList.clear();
            this.categoriesDatumList.addAll(categoriesDatumList);
        }else  this.categoriesDatumList.addAll(categoriesDatumList);

        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.product_display_all, parent, false);
                viewHolder = new MyViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(viewLoading);
                break;
        }
        return viewHolder;


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder  = new  MyViewHolder(holder.itemView);
        final CategoriesDatum categoriesDatum = categoriesDatumList.get(position);

        switch (getItemViewType(position)) {
            case ITEM:

                viewHolder.product_image.setImageResource(Integer.parseInt(String.valueOf(categoriesImages.get(position))));
                viewHolder.product_name.setText(categoriesDatum.getName());
                viewHolder.product_name.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
                viewHolder.product_price.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
                viewHolder.product_price.setTextColor(Color.parseColor("#000000"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    viewHolder.product_price.setText(Html.fromHtml("<p>"+categoriesDatum.getDescription()+"</p>",
                            Html.FROM_HTML_MODE_COMPACT));
                } else {
                    viewHolder.product_price.setText(Html.fromHtml("<p>"+categoriesDatum.getDescription()+"</p>"));
                }
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ProductsActivity.class);
                        intent.putExtra("id", categoriesDatum.getId());
                        intent.putExtra("name", categoriesDatum.getName());
                        context.startActivity(intent);
                    }
                });


//        if(click==position){
//            viewHolder.categories_name.setTextColor(Color.parseColor("#008000"));
//        }
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int previousItem = click;
//                click = position;
//                notifyItemChanged(previousItem);
//                notifyItemChanged(position);
//                categoriesUserView.categoryClick(categoriesDatum.getId(),categoriesDatum.getName());
//            }
//        });

                break;

            case LOADING:
                LoadingVH loadingVH = (LoadingVH) holder;
                if (retryPageLoad) {
                    loadingVH.mErrorLayout.setVisibility(View.VISIBLE);
                    loadingVH.mProgressBar.setVisibility(View.GONE);

                    loadingVH.mErrorTxt.setText(
                            errorMsg != null ?
                                    errorMsg :
                                    context.getString(R.string.error_msg_unknown));
                } else {
                    loadingVH.mErrorLayout.setVisibility(View.GONE);
                    loadingVH.mProgressBar.setVisibility(View.VISIBLE);
                }
                break;


        }


    }

    @Override
    public int getItemViewType(int position) {

        return (position == categoriesDatumList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    @Override
    public int getItemCount() {
        return categoriesDatumList != null ? categoriesDatumList.size() : 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        RatingBar ratingBar;
        TextView product_name,product_price;
        public MyViewHolder(View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.productSmallImage);
            ratingBar = itemView.findViewById(R.id.productRating);
            product_name = itemView.findViewById(R.id.productName);
            product_price = itemView.findViewById(R.id.productPrice);
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        //UI View Bind
        @BindView(R.id.loadmore_progress)
        ProgressBar mProgressBar;
        @BindView(R.id.loadmore_retry)
        ImageButton mRetryBtn;
        @BindView(R.id.loadmore_errortxt) TextView mErrorTxt;
        @BindView(R.id.loadmore_errorlayout)
        LinearLayout mErrorLayout;



        public LoadingVH(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
            mRetryBtn.setOnClickListener(this);
            mErrorLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:
                    showRetry(false, null);
                    categoriesUserView.retryPageLoad();
                    break;
            }
        }
    }



    /*
        Helpers - Pagination
   _________________________________________________________________________________________________
    */

    public void add(CategoriesDatum r) {
        categoriesDatumList.add(r);
        notifyItemInserted(categoriesDatumList.size() - 1);
    }

    public void addAll(List<CategoriesDatum> moveContents) {
        for (CategoriesDatum Content : moveContents) {
            add(Content);
        }
    }

    public void remove(CategoriesDatum r) {
        int position = categoriesDatumList.indexOf(r);
        if (position > -1) {
            categoriesDatumList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new CategoriesDatum());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = categoriesDatumList.size() - 1;
        CategoriesDatum Content = getItem(position);

        if (Content != null) {
            categoriesDatumList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public CategoriesDatum getItem(int position) {
        return categoriesDatumList.get(position);
    }

    /**
     * Displays Pagination retry footer view along with appropriate errorMsg
     *
     * @param show
     * @param errorMsg to display if page load fails
     */
    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(categoriesDatumList.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }
}
