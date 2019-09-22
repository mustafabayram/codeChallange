package com.obilet.android.kariyernetchallange.ui.viewmodel.product;

import androidx.lifecycle.MutableLiveData;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.entity.Product;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LoginUseCase;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LogoutUseCase;
import com.obilet.android.kariyernetchallange.domain.interactor.product.GetProductListUseCase;
import com.obilet.android.kariyernetchallange.domain.model.LoginRequest;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class ProductViewModel extends BaseViewModel {

    private final GetProductListUseCase getProductListUseCase;
    private final LogoutUseCase logoutUseCase;

    private final MutableLiveData<List<Product>> productListResponse = new MutableLiveData<>();
    private final MutableLiveData<Boolean> logoutResponse = new MutableLiveData<>();

    public ProductViewModel(BaseApplication application,
                            GetProductListUseCase getProductListUseCase,
                            LogoutUseCase logoutUseCase) {
        super(application);
        this.getProductListUseCase = getProductListUseCase;
        this.logoutUseCase = logoutUseCase;
    }

    public MutableLiveData<List<Product>> productListResponse() {
        return productListResponse;
    }

    public MutableLiveData<Boolean> logoutResponse() {
        return logoutResponse;
    }

    public void getProductList() {
        disposables.add(getProductListUseCase.execute(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(productListResponse::setValue, this::error));

    }

    public void logout() {
        disposables.add(logoutUseCase.execute(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> logoutResponse.setValue(response.isSuccess), this::error));

    }

}