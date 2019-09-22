package com.obilet.android.kariyernetchallange.data;

import com.obilet.android.kariyernetchallange.data.api.ApiModule;
import com.obilet.android.kariyernetchallange.data.local.LocalModule;

import dagger.Module;

@Module(includes = {
        ApiModule.class,
        LocalModule.class
})
public class DataModule {

}

