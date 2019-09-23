package com.obilet.android.kariyernetchallange.ui.screen.productlist.holder;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.obilet.android.kariyernetchallange.R;
import com.obilet.android.kariyernetchallange.domain.entity.Product;
import com.obilet.android.kariyernetchallange.ui.holder.BaseViewHolder;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.common.ProductConstant;
import com.obilet.android.kariyernetchallange.ui.screen.productlist.viewmodel.ProductListViewModel;
import com.obilet.android.kariyernetchallange.util.DateUtils;
import com.obilet.android.kariyernetchallange.util.NumberUtils;

import net.cachapa.expandablelayout.ExpandableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class ProductListViewHolder extends BaseViewHolder<ProductListViewModel> {

    @BindView(R.id.date_info_linearLayout)
    LinearLayout dateInfoLayout;

    @BindView(R.id.date_textView)
    AppCompatTextView dateTextView;

    @BindView(R.id.month_textView)
    AppCompatTextView monthTextView;

    @BindView(R.id.market_name_textView)
    AppCompatTextView marketNameTextView;

    @BindView(R.id.order_name_textView)
    AppCompatTextView orderNameTextView;

    @BindView(R.id.product_state_textView)
    AppCompatTextView stateTextView;

    @BindView(R.id.product_price_textView)
    AppCompatTextView priceTextView;

    @BindView(R.id.product_detail_expand_imageView)
    AppCompatImageView expandImageView;

    @BindView(R.id.product_detail_expandableLayout)
    ExpandableLayout detailExpandableLayout;

    @BindView(R.id.order_detail_textView)
    AppCompatTextView orderDetailTextView;

    @BindView(R.id.summary_price_textView)
    AppCompatTextView summaryPriceTextView;


    public ProductListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(ProductListViewModel productListViewModel) {
        Product product = productListViewModel.product;

        if (productListViewModel.isExpanded) {
            expandImageView.setRotation(-90);
            detailExpandableLayout.expand(false);
        } else {
            expandImageView.setRotation(90);
            detailExpandableLayout.collapse(false);
        }

        dateInfoLayout.setBackgroundResource(getProperColor(product.productState));
        dateTextView.setText(product.date);
        monthTextView.setText(DateUtils.getMonthFullName(product.month));
        marketNameTextView.setText(product.marketName);
        orderNameTextView.setText(product.orderName);
        stateTextView.setText(product.productState);
        stateTextView.setTextColor(ContextCompat.getColor(itemView.getContext(), getProperColor(product.productState)));
        priceTextView.setText(NumberUtils.moneyStringIncludingTurkishCurrencySymbol(product.productPrice));
        orderDetailTextView.setText(product.productDetail.orderDetail);
        summaryPriceTextView.setText(NumberUtils.moneyStringIncludingTurkishCurrencySymbol(product.productDetail.summaryPrice));

    }

    @ColorRes
    int getProperColor(String productState) {

        if (productState.equals(ProductConstant.PRODUCT_STATE_PREPARING)) {
            return R.color.colorOrange;
        }
        if (productState.equals(ProductConstant.PRODUCT_STATE_UNDER_WEIGHT)) {
            return R.color.colorGreen;
        }
        if (productState.equals(ProductConstant.PRODUCT_STATE_WAITING_FOR_APPROVAL)) {
            return R.color.colorRed;
        }
        return R.color.colorPrimary;
    }
}
