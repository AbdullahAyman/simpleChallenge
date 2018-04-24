package com.tps.challenge.Views.Activities.Modules;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.tps.challenge.Adapters.PhotosAdapter;
import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Models.ImagesDisplayerActivityViewModel;
import com.tps.challenge.Views.Activities.View.ImagesDisplayerActivityView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ImagesDisplayerActivityModule {
    @Provides
    ImagesDisplayerActivityViewModel provideImagesDisplayerActivityViewModel(DataManager dataManager,
                                                                             SchedulerProvider schedulerProvider) {
        return new ImagesDisplayerActivityViewModel(dataManager, schedulerProvider);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(ImagesDisplayerActivityView activityView) {
        return new GridLayoutManager(activityView,2);
    }

    @Provides
    PhotosAdapter providePhotosAdapter(ImagesDisplayerActivityView activityView) {
        return new PhotosAdapter(new ArrayList<>(), activityView.getBaseContext());
    }
}
