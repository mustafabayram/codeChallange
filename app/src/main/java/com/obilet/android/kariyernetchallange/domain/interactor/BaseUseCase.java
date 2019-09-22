package com.obilet.android.kariyernetchallange.domain.interactor;

import io.reactivex.Flowable;

public abstract class BaseUseCase<Response, Request> {

    public abstract Flowable<Response> execute(Request params);

}
