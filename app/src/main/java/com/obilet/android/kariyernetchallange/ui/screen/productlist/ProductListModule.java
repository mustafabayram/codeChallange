package com.obilet.android.kariyernetchallange.ui.screen.productlist;

import com.obilet.android.kariyernetchallange.di.ActivityScope;
import com.obilet.android.kariyernetchallange.ui.activity.ActivityModule;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.activity.ProductListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListModule {

    @Module
    public static class ProductListActivityModule extends ActivityModule<ProductListActivity> {
    }

    @Module
    public abstract class ProductListScreenModule {

        @ActivityScope
        @ContributesAndroidInjector(modules = {ProductListModule.ProductListActivityModule.class})
        abstract ProductListActivity productListActivity();
    }
}
