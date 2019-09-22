package com.obilet.android.kariyernetchallange.data.local;

import com.obilet.android.kariyernetchallange.domain.entity.User;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-22.
 */
public interface LocalService {
    public Flowable<User> getUser();

    public Flowable<Boolean> storeUser(User user);

    public Flowable<Boolean> removeUser();

    public Flowable<Boolean> hasUser();
}
