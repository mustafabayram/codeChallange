package com.obilet.android.kariyernetchallange.domain.interactor.membership;

import com.obilet.android.kariyernetchallange.data.repository.membership.MembershipDataRepository;
import com.obilet.android.kariyernetchallange.domain.interactor.BaseUseCase;
import com.obilet.android.kariyernetchallange.domain.repository.MembershipRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
public class LogoutUseCase extends BaseUseCase<Boolean, Object> {

    private final MembershipRepository membershipRepository;

    @Inject
    public LogoutUseCase(MembershipDataRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Flowable<Boolean> execute(Object req) {
        return membershipRepository.logout();
    }
}
