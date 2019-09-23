package com.obilet.android.kariyernetchallange.ui.screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;

import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.ui.activity.BaseActivity;
import com.obilet.android.kariyernetchallange.ui.viewmodel.splash.SplashViewModel;
import com.obilet.android.kariyernetchallange.ui.viewmodel.splash.SplashViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash_textView)
    AppCompatTextView textView;

    @Inject
    SplashViewModelFactory viewModelFactory;
    SplashViewModel viewModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);
        attachViewModel(viewModel);

        viewModel.userResponse().observe(this, user -> {
            if (user == null) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            } else {
                startActivity(new Intent(SplashActivity.this, ProductListActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
            finish();
        });

        textView.animate()
                .alphaBy(0)
                .alpha(1f)
                .setDuration(2000)
                .withEndAction(() -> {
                    textView.animate().alpha(0).setDuration(2000).withEndAction(() -> {
                        viewModel.getUser();
                    });
                }).setStartDelay(500);
    }
}
