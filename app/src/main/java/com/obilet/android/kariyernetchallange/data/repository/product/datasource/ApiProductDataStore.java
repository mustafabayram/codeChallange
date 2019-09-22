package com.obilet.android.kariyernetchallange.data.repository.product.datasource;

import com.obilet.android.kariyernetchallange.data.api.service.MainApiService;
import com.obilet.android.kariyernetchallange.domain.entity.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ApiProductDataStore {

    private MainApiService apiService;

    @Inject
    public ApiProductDataStore(MainApiService apiService) {
        this.apiService = apiService;
    }

    public Flowable<List<Product>> getProducts() {
        return apiService.getProducts();
    }
}
