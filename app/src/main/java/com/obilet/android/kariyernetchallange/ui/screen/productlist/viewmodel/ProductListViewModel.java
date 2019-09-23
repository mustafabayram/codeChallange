package com.obilet.android.kariyernetchallange.ui.screen.productlist.viewmodel;

import com.obilet.android.kariyernetchallange.domain.entity.Product;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListViewModel {
    public boolean isExpanded;
    public Product product;

    public ProductListViewModel(Product product) {
        this.product = product;
    }

    public ProductListViewModel(boolean isExpanded, Product product) {
        this.isExpanded = isExpanded;
        this.product = product;
    }
}
