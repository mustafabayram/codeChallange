package com.obilet.android.kariyernetchallange.data.repository.membership.datasource;

import com.obilet.android.kariyernetchallange.domain.entity.User;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class MembershipDataStoreFactory {

    private final LocalMembershipDataStore localMembershipDataStore;

    @Inject
    public MembershipDataStoreFactory(LocalMembershipDataStore localMembershipDataStore) {
        this.localMembershipDataStore = localMembershipDataStore;
    }

    public Flowable<Boolean> login(User user) {
        return localMembershipDataStore.login(user);
    }

    public Flowable<Boolean> logout() {
        return localMembershipDataStore.logout();
    }

    public Flowable<User> getUser() {
        return localMembershipDataStore.getUser();
    }
}
