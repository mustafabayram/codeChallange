package com.obilet.android.kariyernetchallange.ui.presenter;

import io.reactivex.subjects.PublishSubject;

public interface AlertPresenter {

    PublishSubject<Integer> presentWithMessage(CharSequence message);
}
