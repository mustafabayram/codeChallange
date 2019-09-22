package com.obilet.android.kariyernetchallange.di;

import com.obilet.android.kariyernetchallange.BaseApplication;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseApplication> {
    }
}
