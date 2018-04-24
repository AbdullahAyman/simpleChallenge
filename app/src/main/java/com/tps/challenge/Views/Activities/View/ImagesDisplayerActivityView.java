package com.tps.challenge.Views.Activities.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.tps.challenge.Adapters.PhotosAdapter;
import com.tps.challenge.BR;
import com.tps.challenge.DataLayer.DataModels.api.Photos.Photo;
import com.tps.challenge.R;
import com.tps.challenge.Views.Activities.Models.ImagesDisplayerActivityViewModel;
import com.tps.challenge.Views.Activities.Navigators.ImagesDisplayerActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseActivity;
import com.tps.challenge.databinding.ActivityImagesViewBinding;

import java.util.List;

import javax.inject.Inject;

public class ImagesDisplayerActivityView extends BaseActivity<ActivityImagesViewBinding, ImagesDisplayerActivityViewModel> implements ImagesDisplayerActivityViewNavigator {

    @Inject
    ImagesDisplayerActivityViewModel mViewModel;
    @Inject
    LinearLayoutManager mLinearLayoutManager;
    @Inject
    PhotosAdapter mPhotosAdapter;
    ActivityImagesViewBinding mViewBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ImagesDisplayerActivityView.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        setupRecycler();
        loadImages();
    }

    @Override
    public ImagesDisplayerActivityViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_images_view;
    }

    private void setupRecycler() {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewBinding.imagesRecycler.setLayoutManager(mLinearLayoutManager);
        mViewBinding.imagesRecycler.setItemAnimator(new DefaultItemAnimator());
        mViewBinding.imagesRecycler.setAdapter(mPhotosAdapter);
        mPhotosAdapter.assignListener(this);
    }

    @Override
    public void assignAdapter(List<Photo> items) {
        mPhotosAdapter.assignItems(items);
    }

    @Override
    public void loadImages() {
        mViewModel.loadImages();
    }
}
