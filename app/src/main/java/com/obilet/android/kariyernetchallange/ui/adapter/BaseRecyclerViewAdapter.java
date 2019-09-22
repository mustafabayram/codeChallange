package com.obilet.android.kariyernetchallange.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.obilet.android.kariyernetchallange.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Bayram on 20.11.2018.
 */
public abstract class BaseRecyclerViewAdapter<TModel, TViewHolder extends BaseViewHolder> extends RecyclerView.Adapter<TViewHolder> {

    private final LayoutInflater layoutInflater;
    public final Context context;
    protected List<TModel> items = new ArrayList<>();
    protected OnItemClickListener onItemClickListener;


    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    public BaseRecyclerViewAdapter(Context context, List<TModel> items) {
        this.context = context;
        this.items = items;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(TViewHolder holder, final int position) {

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                onItemClickListener.onItemClick(holder.getLayoutPosition());
            });
        }

        if (items == null || items.isEmpty()) {
            return;
        }

        //noinspection unchecked
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public abstract TViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public TModel getItem(int position) {
        return items.get(position);
    }

    public List<TModel> getItems() {
        return items;
    }

    public void setItems(List<TModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

