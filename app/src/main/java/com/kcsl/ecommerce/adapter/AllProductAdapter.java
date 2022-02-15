package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.kcsl.ecommerce.activities.ProductDetailsActivity;
import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.callbacks.ProductsUserView;
import com.kcsl.ecommerce.models.ProductDatum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<ProductDatum> productDatumList = new ArrayList<>();

    ProductsUserView productsUserView;


    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    private String errorMsg;


    public AllProductAdapter(Context context,ProductsUserView productsUserView) {
        this.context = context;
        this.productsUserView = productsUserView;

    }

    public void setAllProductDataList(List<ProductDatum> productDatumList, int currentPage){
        if (currentPage == 1){
            if(this.productDatumList != null) this.productDatumList.clear();
            this.productDatumList.addAll(productDatumList);
        }else  this.productDatumList.addAll(productDatumList);

        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
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
        AllProductAdapter.MyViewHolder viewHolder  = new AllProductAdapter.MyViewHolder(holder.itemView);
        final ProductDatum productDatum = productDatumList.get(position);

        switch (getItemViewType(position)) {
            case ITEM: {

                if (productDatum.getBaseImage().getLargeImageUrl() != null) {
                    Glide.with(context).load(productDatum.getBaseImage().getLargeImageUrl()).
                            into(viewHolder.product_image);
                } else {
                    viewHolder.product_image.setImageResource(R.drawable.prodct_display_border);
                }


                viewHolder.ratingBar.setRating(productDatum.getReviews().getTotalRating());
                viewHolder.product_name.setText(productDatum.getName());
                viewHolder.product_price.setText("\u09F3"+ productDatum.getFormatedPrice().substring(1));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ProductDetailsActivity.class);
                        intent.putExtra("id", productDatum.getId());
                        context.startActivity(intent);

                    }
                });

                break;

            }

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

        return (position == productDatumList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    @Override
    public int getItemCount() {

        return productDatumList != null ? productDatumList.size() : 0;

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
                    productsUserView.retryPageLoad();
                    break;
            }
        }
    }



    /*
        Helpers - Pagination
   _________________________________________________________________________________________________
    */

    public void add(ProductDatum r) {
        productDatumList.add(r);
        notifyItemInserted(productDatumList.size() - 1);
    }

    public void addAll(List<ProductDatum> moveContents) {
        for (ProductDatum Content : moveContents) {
            add(Content);
        }
    }

    public void remove(ProductDatum r) {
        int position = productDatumList.indexOf(r);
        if (position > -1) {
            productDatumList.remove(position);
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
        add(new ProductDatum());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = productDatumList.size() - 1;
        ProductDatum Content = getItem(position);

        if (Content != null) {
            productDatumList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public ProductDatum getItem(int position) {
        return productDatumList.get(position);
    }

    /**
     * Displays Pagination retry footer view along with appropriate errorMsg
     *
     * @param show
     * @param errorMsg to display if page load fails
     */
    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(productDatumList.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }
}
