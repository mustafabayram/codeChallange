package com.obilet.android.kariyernetchallange.ui.viewmodel.splash;

import androidx.lifecycle.MutableLiveData;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.domain.entity.User;
import com.obilet.android.kariyernetchallange.domain.interactor.membership.GetUserUseCase;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Mustafa Bayram on 8.05.2019.
 */
public class SplashViewModel extends BaseViewModel {

    private final GetUserUseCase getUserUseCase;

    private final MutableLiveData<User> userResponse = new MutableLiveData<>();

    public SplashViewModel(BaseApplication application,
                           GetUserUseCase getUserUseCase) {
        super(application);
        this.getUserUseCase = getUserUseCase;
    }

    public MutableLiveData<User> userResponse() {
        return userResponse;
    }

    public void getUser() {
        disposables.add(getUserUseCase.execute(null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userResponse::setValue, throwable -> {
                    userResponse.setValue(null);
                }));

    }

}