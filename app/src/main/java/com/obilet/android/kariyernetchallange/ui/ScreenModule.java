package com.obilet.android.kariyernetchallange.ui;

import com.obilet.android.kariyernetchallange.ui.screen.login.LoginModule;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.ProductListModule;
import com.obilet.android.kariyernetchallange.ui.screen.splash.SplashModule;

import dagger.Module;

/**
 * Created by Mustafa Bayram on 2019-09-21.
 */
@Module(includes = {
        SplashModule.SplashScreenModule.class,
        LoginModule.LoginScreenModule.class,
        ProductListModule.ProductListScreenModule.class
})
public class ScreenModule {
}
