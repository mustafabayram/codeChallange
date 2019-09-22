package com.obilet.android.kariyernetchallange.data.api.service;

import com.obilet.android.kariyernetchallange.data.api.ApiService;
import com.obilet.android.kariyernetchallange.domain.entity.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class MainApiService {

    private ApiService apiService;

    @Inject
    public MainApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    public Flowable<List<Product>> getProducts() {
        return apiService.getProducts();
    }
}
