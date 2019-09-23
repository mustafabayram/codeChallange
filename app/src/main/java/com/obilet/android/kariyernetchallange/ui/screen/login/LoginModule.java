package com.obilet.android.kariyernetchallange.ui.screen.login;

import com.obilet.android.kariyernetchallange.di.ActivityScope;
import com.obilet.android.kariyernetchallange.ui.activity.ActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class LoginModule {


    @Module
    public static class LoginActivityModule extends ActivityModule<LoginActivity> {
    }

    @Module
    public abstract class LoginScreenModule {

        @ActivityScope
        @ContributesAndroidInjector(modules = {LoginModule.LoginActivityModule.class})
        abstract LoginActivity loginActivity();
    }
}
