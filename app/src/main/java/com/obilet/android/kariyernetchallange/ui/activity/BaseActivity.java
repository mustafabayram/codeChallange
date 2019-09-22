package com.obilet.android.kariyernetchallange.ui.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;

import com.google.gson.Gson;
import com.obilet.android.kariyernetchallange.data.exception.BaseErrorException;
import com.obilet.android.kariyernetchallange.data.local.LocalStorage;
import com.obilet.android.kariyernetchallange.ui.viewmodel.BaseViewModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mustafa Bayram on 13.11.2018.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutResId();

    @Inject
    public LocalStorage localStorage;

    @Inject
    public Gson gson;

    private CompositeDisposable disposables = new CompositeDisposable();

    protected BaseViewModel attachedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        onActivityCreated(savedInstanceState);
    }

    protected void onActivityCreated(Bundle savedInstanceState) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    public void registerDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    public void unregisterDisposable(Disposable disposable) {
        disposables.remove(disposable);
    }

    public void attachViewModel(BaseViewModel viewModel) {
        attachedViewModel = viewModel;
        disposables.add(viewModel.isReady().subscribe(isReady -> {
            if (isReady) {
                //hideIndicator();
            } else {
                //showIndicator();
            }
        }));

        disposables.add(viewModel.hasError().subscribe(throwable -> {
            if (throwable instanceof BaseErrorException) {
                // show alert
            }
            throwable.printStackTrace();
        }));
    }

    public String serialize(Object o) {
        return gson.toJson(o);
    }

    public <T> T deserialize(String data, Class<T> objectClass) {
        return gson.fromJson(data, objectClass);
    }

}
