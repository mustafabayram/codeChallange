package com.obilet.android.kariyernetchallange.data.repository.product.datasource;

import com.obilet.android.kariyernetchallange.domain.entity.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductDataStoreFactory {

    private final ApiProductDataStore apiProductDataStore;

    @Inject
    public ProductDataStoreFactory(ApiProductDataStore apiProductDataStore) {
        this.apiProductDataStore = apiProductDataStore;
    }

    public Flowable<List<Product>> getProducts() {
        return apiProductDataStore.getProducts();
    }
}
