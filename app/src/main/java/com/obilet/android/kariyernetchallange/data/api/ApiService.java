package com.obilet.android.kariyernetchallange.data.api;

import com.obilet.android.kariyernetchallange.domain.entity.Product;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    @GET
    Flowable<List<Product>> getProducts();

}
