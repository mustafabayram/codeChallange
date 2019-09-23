package com.obilet.android.kariyernetchallange.ui.screen.productlist.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.ui.activity.BaseActivity;
import com.obilet.android.kariyernetchallange.ui.screen.login.LoginActivity;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.adapter.ProductListAdapter;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.viewmodel.ProductListViewModel;
import com.obilet.android.kariyernetchallange.ui.viewmodel.product.ProductViewModel;
import com.obilet.android.kariyernetchallange.ui.viewmodel.product.ProductViewModelFactory;
import com.obilet.android.kariyernetchallange.util.ArrayUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListActivity extends BaseActivity {

    @BindView(R.id.products_recyclerView)
    RecyclerView productListRecyclerView;

    @BindView(R.id.logout_button)
    MaterialButton logoutButton;

    @Inject
    ProductViewModelFactory viewModelFactory;
    ProductViewModel viewModel;

    ProductListAdapter adapter;
    int DEFAULT_INDEX = -1;
    int lastSelectedIndex = DEFAULT_INDEX;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_product_list;
    }

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductViewModel.class);
        attachViewModel(viewModel);

        adapter = new ProductListAdapter(this);
        adapter.setOnItemClickListener(position -> {
            ProductListViewModel selectedItem = adapter.getItem(position);
            selectedItem.isExpanded = !selectedItem.isExpanded;

            if (selectedItem.isExpanded) {
                if (lastSelectedIndex != DEFAULT_INDEX) {
                    ProductListViewModel lastSelectedItem = adapter.getItem(lastSelectedIndex);
                    lastSelectedItem.isExpanded = false;
                    adapter.notifyItemChanged(lastSelectedIndex);
                }
                lastSelectedIndex = position;

            } else {
                lastSelectedIndex = DEFAULT_INDEX;
            }
            adapter.notifyItemChanged(position);

        });
        productListRecyclerView.setAdapter(adapter);

        viewModel.productListResponse().observe(this, products ->
                adapter.setItems(ArrayUtils.map(products, ProductListViewModel::new)));

        viewModel.logoutResponse().observe(this, isLogout -> {
            startActivity(new Intent(ProductListActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        });

        logoutButton.setOnClickListener(v -> {
            viewModel.logout();
        });

    }
}
