package com.obilet.android.kariyernetchallange.ui.holder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Mustafa Bayram on 20.11.2018.
 */
public abstract class BaseViewHolder<TModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(TModel model);
}