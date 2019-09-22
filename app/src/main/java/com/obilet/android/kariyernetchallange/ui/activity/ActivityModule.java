package com.obilet.android.kariyernetchallange.ui.activity;

import android.content.Context;

import com.obilet.android.kariyernetchallange.di.ActivityContext;
import com.obilet.android.kariyernetchallange.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mustafa Bayram on 20.11.2018.
 */


@Module(includes = {})
public abstract class ActivityModule<T extends BaseActivity> {

    @Provides
    @ActivityScope
    @ActivityContext
    public Context context(T activity) {
        return activity;
    }
}
