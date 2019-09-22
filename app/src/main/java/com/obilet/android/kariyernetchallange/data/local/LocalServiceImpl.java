package com.obilet.android.kariyernetchallange.data.local;

import com.obilet.android.kariyernetchallange.domain.entity.User;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by Mustafa Bayram on 20.11.2018.
 */
public class LocalServiceImpl implements LocalService {

    // store işlemleri için direkt localstorage a erişilir.
    private LocalStorage localStorage;

    public LocalServiceImpl(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    @Override
    public Flowable<User> getUser() {
        return Flowable.create(emitter ->
                emitter.onNext(localStorage.getObject(LocalStorageConstant.USER_DATA, User.class, null)), BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<Boolean> storeUser(User user) {
        return Flowable.create(emitter ->
                emitter.onNext(localStorage.storeObject(LocalStorageConstant.USER_DATA, user)), BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<Boolean> removeUser() {
        return Flowable.create(emitter ->
                emitter.onNext(localStorage.remove(LocalStorageConstant.USER_DATA)), BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<Boolean> hasUser() {
        return Flowable.create(emitter ->
                emitter.onNext(localStorage.getObject(LocalStorageConstant.USER_DATA, User.class, null) != null), BackpressureStrategy.BUFFER);
    }
}
