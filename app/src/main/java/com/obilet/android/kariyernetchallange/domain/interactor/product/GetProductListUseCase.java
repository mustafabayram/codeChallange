package com.obilet.android.kariyernetchallange.domain.interactor.product;

import com.obilet.android.kariyernetchallange.domain.entity.Product;
import com.obilet.android.kariyernetchallange.domain.interactor.BaseUseCase;
import com.obilet.android.kariyernetchallange.domain.repository.ProductRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-07-15.
 */
public class GetProductListUseCase extends BaseUseCase<List<Product>, Object> {

    private final ProductRepository productRepository;

    @Inject
    public GetProductListUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // fromLocal flag'i Data Store Factory den datanın localden mi yoksa api den mi alınacağını belirtiyor.
    @Override
    public Flowable<List<Product>> execute(Object req) {
        return productRepository.getProductList();
    }
}
