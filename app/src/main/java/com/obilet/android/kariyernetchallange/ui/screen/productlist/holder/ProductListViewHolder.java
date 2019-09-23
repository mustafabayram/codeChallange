package com.obilet.android.kariyernetchallange.ui.screen.productlist.holder;

import android.view.View;

import com.obilet.android.kariyernetchallange.ui.holder.BaseViewHolder;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.viewmodel.ProductListViewModel;

import butterknife.ButterKnife;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListViewHolder extends BaseViewHolder<ProductListViewModel> {


    public ProductListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(ProductListViewModel productListViewModel) {

    }
}
