package com.obilet.android.kariyernetchallange.data.repository.product;

import com.obilet.android.kariyernetchallange.data.repository.product.datasource.ProductDataStoreFactory;
import com.obilet.android.kariyernetchallange.domain.entity.Product;
import com.obilet.android.kariyernetchallange.domain.repository.ProductRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductDataRepository implements ProductRepository {

    private ProductDataStoreFactory productDataStoreFactory;

    @Inject
    public ProductDataRepository(ProductDataStoreFactory productDataStoreFactory) {
        this.productDataStoreFactory = productDataStoreFactory;
    }

    @Override
    public Flowable<List<Product>> getProductList() {
        return productDataStoreFactory.getProducts();
    }
}
