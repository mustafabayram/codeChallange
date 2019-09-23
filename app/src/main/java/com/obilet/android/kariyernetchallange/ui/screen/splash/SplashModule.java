package com.obilet.android.kariyernetchallange.ui.screen.splash;

import com.obilet.android.kariyernetchallange.di.ActivityScope;
import com.obilet.android.kariyernetchallange.ui.activity.ActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class SplashModule {

    @Module
    public static class SplashActivityModule extends ActivityModule<SplashActivity> {
    }

    @Module
    public abstract class SplashScreenModule {

        @ActivityScope
        @ContributesAndroidInjector(modules = {SplashModule.SplashActivityModule.class})
        abstract SplashActivity splashActivity();
    }
}
