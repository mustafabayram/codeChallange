package com.obilet.android.kariyernetchallange.data.exception;

import androidx.annotation.StringRes;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class BaseErrorException extends Exception {
    public @StringRes
    int errorMessageResId;

    public BaseErrorException() {
    }

    public BaseErrorException(@StringRes int errorMessageResId) {
        this.errorMessageResId = errorMessageResId;
    }

    public BaseErrorException(String message) {
        super(message);
    }

    public BaseErrorException(Throwable cause) {
        super(cause);
    }
}
