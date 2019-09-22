package com.obilet.android.kariyernetchallange.domain.repository;

import com.obilet.android.kariyernetchallange.domain.model.LoginRequest;
import com.obilet.android.kariyernetchallange.domain.model.LoginResponse;
import com.obilet.android.kariyernetchallange.domain.model.LogoutResponse;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
public interface MembershipRepository {

    Flowable<LoginResponse> login(LoginRequest req);

    Flowable<LogoutResponse> logout();
}
