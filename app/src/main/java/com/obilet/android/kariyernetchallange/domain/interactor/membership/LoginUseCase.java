package com.obilet.android.kariyernetchallange.domain.interactor.membership;

import com.obilet.android.kariyernetchallange.domain.interactor.BaseUseCase;
import com.obilet.android.kariyernetchallange.domain.model.LoginRequest;
import com.obilet.android.kariyernetchallange.domain.model.LoginResponse;
import com.obilet.android.kariyernetchallange.domain.repository.MembershipRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
public class LoginUseCase extends BaseUseCase<LoginResponse, LoginRequest> {

    private final MembershipRepository membershipRepository;

    @Inject
    public LoginUseCase(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Flowable<LoginResponse> execute(LoginRequest req) {
        return membershipRepository.login(req);
    }
}
