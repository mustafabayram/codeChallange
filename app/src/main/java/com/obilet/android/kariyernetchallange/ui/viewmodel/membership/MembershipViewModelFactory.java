package com.obilet.android.kariyernetchallange.ui.viewmodel.membership;

import androidx.lifecycle.ViewModel;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LoginUseCase;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LogoutUseCase;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModelFactory;

import javax.inject.Inject;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class MembershipViewModelFactory extends BaseViewModelFactory {

    private final BaseApplication application;
    private final LoginUseCase loginUseCase;


    @Inject
    public MembershipViewModelFactory(BaseApplication application,
                                      LoginUseCase loginUseCase,
                                      LogoutUseCase logoutUseCase) {
        super(application);
        this.application = application;
        this.loginUseCase = loginUseCase;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MembershipViewModel.class)) {
            return (T) new MembershipViewModel(application, loginUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
