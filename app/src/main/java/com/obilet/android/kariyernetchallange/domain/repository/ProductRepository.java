package com.obilet.android.kariyernetchallange.domain.repository;

import com.obilet.android.kariyernetchallange.domain.entity.Product;

import java.util.List;

import io.reactivex.Flowable;

public interface ProductRepository {

    Flowable<List<Product>> getProductList();
}
