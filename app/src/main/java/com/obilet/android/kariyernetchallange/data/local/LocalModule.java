package com.obilet.android.kariyernetchallange.data.local;

import android.content.Context;

import com.google.gson.Gson;
import com.obilet.android.kariyernetchallange.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mustafa Bayram on 2019-09-22.
 */
@Module
public class LocalModule {


    @ApplicationScope
    @Provides
    public LocalStorage provideLocalStorage(Context context, Gson gson) {
        return new LocalStorage(context, gson);
    }

    @ApplicationScope
    @Provides
    public LocalService provideLocalService(LocalStorage localStorage) {
        return new LocalServiceImpl(localStorage);
    }
}
