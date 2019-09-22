package com.obilet.android.kariyernetchallange.ui.presenter;

import android.content.Context;

import com.obilet.android.kariyernetchallange.di.ActivityContext;
import com.obilet.android.kariyernetchallange.di.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @ActivityScope
    @Provides
    public AlertPresenter provideAlertPresenter(@ActivityContext Context context) {
        return new AlertPresenterImpl(context);
    }

}
