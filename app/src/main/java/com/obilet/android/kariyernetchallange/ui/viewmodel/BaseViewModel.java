package com.obilet.android.kariyernetchallange.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Mustafa Bayram on 13.11.2018.
 */
public class BaseViewModel extends AndroidViewModel {

    private BehaviorSubject<Boolean> isReadySubject;
    private BehaviorSubject<Integer> consumerCountSubject;
    private BehaviorSubject<Throwable> hasError;
    private int consumerCount;
    public CompositeDisposable disposables;

    public BaseViewModel(Application application) {
        super(application);
        consumerCount = 0;
        isReadySubject = BehaviorSubject.create();
        hasError = BehaviorSubject.create();
        consumerCountSubject = BehaviorSubject.createDefault(0);
        init();
    }

    private void init() {
        disposables = new CompositeDisposable();
        consumerCountSubject.doOnNext(count -> {
            if (count == 0) {
                isReadySubject.onNext(true);
            } else {
                isReadySubject.onNext(false);
            }
        }).subscribe();
    }

    protected void consume() {
        consumerCount += 1;
        consumerCountSubject.onNext(consumerCount);
    }

    protected void done() {
        consumerCount -= 1;
        consumerCountSubject.onNext(consumerCount);
    }

    protected void error(Throwable throwable) {
        //subscribe block'unun içinde internal hatalar olabiliyor
        //parse exception, nullpointer exp. gibi o nedenle consumer count - ye düşmemesi gerek!
        if (consumerCount > 0) {
            consumerCount -= 1;
            consumerCountSubject.onNext(consumerCount);
        }
        hasError.onNext(throwable);
    }

    protected void errorWithoutConsume(Throwable throwable) {
        hasError.onNext(throwable);
    }


    @Override
    protected void onCleared() {
        disposables.clear();
    }

    public BehaviorSubject<Boolean> isReady() {
        return isReadySubject;
    }

    public BehaviorSubject<Throwable> hasError() {
        return hasError;
    }

}
