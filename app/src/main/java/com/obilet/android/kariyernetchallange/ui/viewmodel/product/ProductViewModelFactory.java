package com.obilet.android.kariyernetchallange.ui.viewmodel.product;

import androidx.lifecycle.ViewModel;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LoginUseCase;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LogoutUseCase;
import com.obilet.android.kariyernetchallange.domain.interactor.product.GetProductListUseCase;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModelFactory;

import javax.inject.Inject;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class ProductViewModelFactory extends BaseViewModelFactory {

    private final BaseApplication application;
    private final GetProductListUseCase getProductListUseCase;
    private final LogoutUseCase logoutUseCase;


    @Inject
    public ProductViewModelFactory(BaseApplication application,
                                   GetProductListUseCase getProductListUseCase,
                                   LogoutUseCase logoutUseCase) {
        super(application);
        this.application = application;
        this.getProductListUseCase = getProductListUseCase;
        this.logoutUseCase = logoutUseCase;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProductViewModel.class)) {
            return (T) new ProductViewModel(application, getProductListUseCase, logoutUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
