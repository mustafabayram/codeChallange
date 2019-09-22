package com.obilet.android.kariyernetchallange.data.repository.membership.datasource;

import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.data.exception.BaseErrorException;
import com.obilet.android.kariyernetchallange.data.local.LocalStorageConstant;
import com.obilet.android.kariyernetchallange.data.local.service.MainLocalService;
import com.obilet.android.kariyernetchallange.domain.entity.User;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class LocalMembershipDataStore {

    private MainLocalService localService;

    @Inject
    public LocalMembershipDataStore(MainLocalService localService) {
        this.localService = localService;
    }

    public Flowable<Boolean> login(User user) {
        if (user.userName.equals(LocalStorageConstant.USER_NAME)) {
            if (user.password.equals(LocalStorageConstant.PASSWORD)) {
                if (user.rememberMe) {
                    return localService.storeUser(user);
                }
                return Flowable.just(true);
            }
            return Flowable.error(new BaseErrorException(R.string.login_exception_wrong_password_message));
        }
        return Flowable.error(new BaseErrorException(R.string.login_exception_wrong_user_name_message));
    }

    public Flowable<Boolean> logout() {
        return localService.hasUser().flatMap(hasUser -> hasUser ? localService.removeUser() : Flowable.just(true));
    }
}
