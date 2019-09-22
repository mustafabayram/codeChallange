package com.obilet.android.kariyernetchallange.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Mustafa Bayram on 14.11.2018.
 */
public class BaseViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    public BaseViewModelFactory(Application application) {
        super(application);
    }
}
