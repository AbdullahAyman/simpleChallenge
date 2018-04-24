package com.tps.challenge.Adapters;

public class EmptyViewModel {
    private EmptyItemViewModelListener mListener;

    public EmptyViewModel(EmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface EmptyItemViewModelListener {
        void onRetryClick();
    }
}
