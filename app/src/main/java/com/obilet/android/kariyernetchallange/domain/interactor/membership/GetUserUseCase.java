package com.obilet.android.kariyernetchallange.domain.interactor.membership;

import com.obilet.android.kariyernetchallange.domain.entity.User;
import com.obilet.android.kariyernetchallange.domain.interactor.BaseUseCase;
import com.obilet.android.kariyernetchallange.domain.repository.MembershipRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class GetUserUseCase extends BaseUseCase<User, Object> {

    private final MembershipRepository membershipRepository;

    @Inject
    public GetUserUseCase(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Flowable<User> execute(Object req) {
        return membershipRepository.getUser();
    }
}