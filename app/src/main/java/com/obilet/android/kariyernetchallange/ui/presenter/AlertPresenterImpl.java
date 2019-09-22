package com.obilet.android.kariyernetchallange.ui.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import com.google.android.material.button.MaterialButton;
import com.obilet.android.kariyernetchallange.R;

import io.reactivex.subjects.PublishSubject;

public class AlertPresenterImpl implements AlertPresenter {

    private final Context context;
    private final Activity activity;

    public AlertPresenterImpl(Context context) {
        this.context = context;
        this.activity = (Activity) context;
    }

    @Override
    public PublishSubject<Integer> presentWithMessage(CharSequence message) {
        return this.preparePresenterDialog(message);
    }

    @NonNull
    protected PublishSubject<Integer> preparePresenterDialog(CharSequence message) {

        final PublishSubject<Integer> resultSignal = PublishSubject.create();
        final View indicatorLayout = activity.getLayoutInflater().inflate(R.layout.layout_alert_dialog, null, false);

        final ConstraintLayout contentConstraint = indicatorLayout.findViewById(R.id.alert_dialog_root_constraintLayout);
        final AppCompatImageView closeImageView = indicatorLayout.findViewById(R.id.alert_dialog_close_imageView);
        final AppCompatTextView messageText = indicatorLayout.findViewById(R.id.alert_dialog_alert_message_textView);
        final MaterialButton primaryBasicButton = indicatorLayout.findViewById(R.id.alert_dialog_alert_button);

        final Dialog dialog = initializeAndShowDialog(indicatorLayout);
        messageText.setText(message);

        contentConstraint.setScaleX(0);
        contentConstraint.setScaleY(0);

        primaryBasicButton.setOnClickListener(view -> {
            resultSignal.onNext(AlertPresenterConstants.BASIC);
            dialog.dismiss();
        });

        closeImageView.setOnClickListener(view -> {
            resultSignal.onNext(AlertPresenterConstants.CLOSE);
            dialog.dismiss();
        });

        dialog.setOnShowListener(dialogInterface -> {
            contentConstraint.postDelayed(() -> {
                ViewCompat.animate(contentConstraint).scaleX(1).scaleY(1).setDuration(200).setInterpolator(new OvershootInterpolator(.5f)).start();
            }, 100);
        });

        if (!activity.isFinishing()) {
            dialog.show();
        }

        return resultSignal;
    }

    private Dialog initializeAndShowDialog(View indicatorLayout) {
        Dialog dialog = new Dialog(activity, R.style.IndicatorDialogTheme);
        dialog.setCancelable(false);
        dialog.setContentView(indicatorLayout);

        dialog.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //Android api level 20 altında loading çıktığında alerdialog mavi çizgisi gözüküyor.
        //Bunu engellemek için aşağıdaki yöntemi kullandık.
        int dividerId = dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null);
        View divider = dialog.findViewById(dividerId);
        if (divider != null) {
            divider.setBackgroundColor(ContextCompat.getColor(activity, android.R.color.transparent));
        }

        return dialog;
    }

    private void configureAlertDialogBeforeShow(AlertDialog.Builder alertBuilder) {

    }
}

