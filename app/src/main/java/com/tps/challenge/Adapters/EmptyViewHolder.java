package com.tps.challenge.Adapters;

import com.tps.challenge.Views.Activities.Navigators.ImagesDisplayerActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewHolder;
import com.tps.challenge.databinding.ItemEmptyBinding;

public class EmptyViewHolder extends BaseViewHolder implements EmptyViewModel.EmptyItemViewModelListener {
    ItemEmptyBinding itemBinding;
    ImagesDisplayerActivityViewNavigator mListener;

    public EmptyViewHolder(ItemEmptyBinding itemView, ImagesDisplayerActivityViewNavigator listener) {
        super(itemView.getRoot());
        this.itemBinding = itemView;
        this.mListener = listener;
    }

    @Override
    public void onBind(int position) {
        EmptyViewModel emptyItemViewModel = new EmptyViewModel(this);
        itemBinding.setViewModel(emptyItemViewModel);
    }

    @Override
    public void onRetryClick() {
        if (mListener != null)
            mListener.loadImages();
    }
}
