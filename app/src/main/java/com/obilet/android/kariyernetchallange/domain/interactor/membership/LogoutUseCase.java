package com.obilet.android.kariyernetchallange.domain.interactor.membership;

import com.obilet.android.kariyernetchallange.domain.interactor.BaseUseCase;
import com.obilet.android.kariyernetchallange.domain.model.LogoutResponse;
import com.obilet.android.kariyernetchallange.domain.repository.MembershipRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
public class LogoutUseCase extends BaseUseCase<LogoutResponse, Object> {

    private final MembershipRepository membershipRepository;

    @Inject
    public LogoutUseCase(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Flowable<LogoutResponse> execute(Object req) {
        return membershipRepository.logout();
    }
}
