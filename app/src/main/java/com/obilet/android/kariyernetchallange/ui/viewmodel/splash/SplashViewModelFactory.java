package com.obilet.android.kariyernetchallange.ui.viewmodel.splash;

import androidx.lifecycle.ViewModel;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.GetUserUseCase;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModelFactory;

import javax.inject.Inject;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class SplashViewModelFactory extends BaseViewModelFactory {

    private final BaseApplication application;
    private final GetUserUseCase getUserUseCase;


    @Inject
    public SplashViewModelFactory(BaseApplication application, GetUserUseCase getUserUseCase) {
        super(application);
        this.application = application;
        this.getUserUseCase = getUserUseCase;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            return (T) new SplashViewModel(application, getUserUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
