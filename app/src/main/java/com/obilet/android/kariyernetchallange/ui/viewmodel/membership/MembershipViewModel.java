package com.obilet.android.kariyernetchallange.ui.viewmodel.membership;

import androidx.lifecycle.MutableLiveData;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.LoginUseCase;
import com.obilet.android.kariyernetchallange.domain.model.LoginRequest;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class MembershipViewModel extends BaseViewModel {

    private final LoginUseCase loginUseCase;

    private final MutableLiveData<Boolean> loginResponse = new MutableLiveData<>();

    public MembershipViewModel(BaseApplication application,
                               LoginUseCase loginUseCase) {
        super(application);
        this.loginUseCase = loginUseCase;
    }

    public MutableLiveData<Boolean> loginResponse() {
        return loginResponse;
    }

    public void login(LoginRequest request) {
        disposables.add(loginUseCase.execute(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginRes -> loginResponse.setValue(loginRes.isSuccess), this::error));

    }

}