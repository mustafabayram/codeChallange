package com.obilet.android.kariyernetchallange.domain.repository;

import com.obilet.android.kariyernetchallange.domain.entity.User;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
public interface MembershipRepository {

    Flowable<Boolean> login(User user);

    Flowable<Boolean> logout();

    Flowable<User> getUser();
}
