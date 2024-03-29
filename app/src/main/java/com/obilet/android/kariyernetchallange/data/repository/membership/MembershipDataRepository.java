package com.obilet.android.kariyernetchallange.data.repository.membership;

import com.obilet.android.kariyernetchallange.data.repository.membership.datasource.MembershipDataStoreFactory;
import com.obilet.android.kariyernetchallange.domain.entity.User;
import com.obilet.android.kariyernetchallange.domain.repository.MembershipRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class MembershipDataRepository implements MembershipRepository {

    private MembershipDataStoreFactory membershipDataStoreFactory;

    @Inject
    public MembershipDataRepository(MembershipDataStoreFactory membershipDataStoreFactory) {
        this.membershipDataStoreFactory = membershipDataStoreFactory;
    }


    public Flowable<Boolean> login(User user) {
        return membershipDataStoreFactory.login(user);
    }

    public Flowable<Boolean> logout() {
        return membershipDataStoreFactory.logout();
    }

    @Override
    public Flowable<User> getUser() {
        return membershipDataStoreFactory.getUser();
    }
}
