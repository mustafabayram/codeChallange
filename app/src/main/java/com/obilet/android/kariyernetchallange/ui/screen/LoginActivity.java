package com.obilet.android.kariyernetchallange.ui.screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.domain.entity.User;
import com.obilet.android.kariyernetchallange.ui.activity.BaseActivity;
import com.obilet.android.kariyernetchallange.ui.viewmodel.membership.MembershipViewModel;
import com.obilet.android.kariyernetchallange.ui.viewmodel.membership.MembershipViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.user_name_editText)
    AppCompatEditText userNameEditText;

    @BindView(R.id.password_editText)
    AppCompatEditText passwordEditText;

    @BindView(R.id.remember_me_switch)
    SwitchCompat rememberMeSwitch;

    @BindView(R.id.login_button)
    MaterialButton loginButton;

    @Inject
    MembershipViewModelFactory viewModelFactory;
    MembershipViewModel viewModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MembershipViewModel.class);
        attachViewModel(viewModel);

        viewModel.loginResponse().observe(this, isLogin -> {
            if (isLogin) {
                startActivity(new Intent(LoginActivity.this, ProductListActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

        loginButton.setOnClickListener(v -> {
            viewModel.login(new User(userNameEditText.getText().toString(),
                    passwordEditText.getText().toString(),
                    rememberMeSwitch.isChecked()));
        });


    }
}
