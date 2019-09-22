package com.obilet.android.kariyernetchallange.data.local.service;

import com.obilet.android.kariyernetchallange.data.local.LocalService;
import com.obilet.android.kariyernetchallange.domain.entity.User;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-22.
 */
public class MainLocalService {

    private LocalService localService;

    @Inject
    public MainLocalService(LocalService localService) {
        this.localService = localService;
    }

    public Flowable<User> getUser() {
        return localService.getUser();
    }

    public Flowable<Boolean> storeUser(User user) {
        return localService.storeUser(user);
    }

    public Flowable<Boolean> removeUser() {
        return localService.removeUser();
    }

    public Flowable<Boolean> hasUser() {
        return localService.hasUser();
    }
}
