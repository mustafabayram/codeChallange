package com.obilet.android.kariyernetchallange.di;

import android.content.Context;

import com.obilet.android.kariyernetchallange.BaseApplication;
import com.obilet.android.kariyernetchallange.data.DataModule;
import com.obilet.android.kariyernetchallange.ui.ScreenModule;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        ScreenModule.class,
        DataModule.class
})
public class AppModule {

    @ApplicationScope
    @Provides
    Context provideContext(BaseApplication application) {
        return application.getApplicationContext();
    }

}
