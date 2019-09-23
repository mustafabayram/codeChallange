package com.obilet.android.kariyernetchallange.ui.screen.productlist.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.ui.adapter.BaseRecyclerViewAdapter;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.holder.ProductListViewHolder;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.viewmodel.ProductListViewModel;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListAdapter extends BaseRecyclerViewAdapter<ProductListViewModel, ProductListViewHolder> {

    public ProductListAdapter(Context context) {
        super(context);
    }

    @Override
    public ProductListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductListViewHolder(getLayoutInflater().inflate(R.layout.item_product_list, parent, false));
    }
}
