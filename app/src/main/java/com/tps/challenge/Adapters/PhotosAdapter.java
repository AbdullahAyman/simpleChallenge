package com.tps.challenge.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.tps.challenge.DataLayer.DataModels.api.Photos.Photo;
import com.tps.challenge.Views.Activities.Navigators.ImagesDisplayerActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewHolder;
import com.tps.challenge.databinding.ItemEmptyBinding;
import com.tps.challenge.databinding.ItemPhotoBinding;

import java.util.List;

import javax.inject.Inject;

public class PhotosAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    @Inject
    Context mContext;
    private List<Photo> mPhoto;
    private ImagesDisplayerActivityViewNavigator mListener;
    private PhotosAdapterViewHolder mPhotosAdapterViewHolder;

    public PhotosAdapter(List<Photo> items, Context context) {
        mPhoto = items;
        mContext = context;
    }

    public void assignListener(ImagesDisplayerActivityViewNavigator listener) {
        mListener = listener;

    }

    public void assignItems(List<Photo> items) {
        mPhoto = items;
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                mPhotosAdapterViewHolder = new PhotosAdapterViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
                return mPhotosAdapterViewHolder;
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(ItemEmptyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), mListener);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mPhoto != null && mPhoto.size() > 0) {
            return mPhoto.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mPhoto != null && mPhoto.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public class PhotosAdapterViewHolder extends BaseViewHolder {

        ItemPhotoBinding mViewBinding;
        PhotosViewModel mViewModel;

        public PhotosAdapterViewHolder(ItemPhotoBinding itemView) {
            super(itemView.getRoot());
            this.mViewBinding = itemView;
        }

        @Override
        public void onBind(int position) {
            mViewModel = new PhotosViewModel(mPhoto.get(position));
            mViewBinding.setViewModel(mViewModel);
            mViewBinding.executePendingBindings();
            Glide.with(mContext)
                    .load(mPhoto.get(position).getImgSrc())
                    .into(mViewBinding.photoId);
        }

    }

}
