package com.tps.challenge.Views.Activities.Models;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.DataLayer.DataModels.api.Photos.PhotosResponse;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Navigators.ImagesDisplayerActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewModel;

import io.reactivex.functions.Consumer;

public class ImagesDisplayerActivityViewModel extends BaseViewModel<ImagesDisplayerActivityViewNavigator> {

    public ImagesDisplayerActivityViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void loadImages() {
        getNavigator().showLoading();
        getCompositeDisposable().add(getDataManager()
                .loadImagesApi()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PhotosResponse>() {
                    @Override
                    public void accept(PhotosResponse response) throws Exception {
                        if (response != null) {
                            getNavigator().assignAdapter(response.getPhotos());
                        } else {
                            getNavigator().showToast("error Loading images", 1);
                        }
                        setIsLoading(false);
                        getNavigator().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getNavigator().hideLoading();
                        setIsLoading(false);
                        getNavigator().showToast("error Loading images", 1);
                        getNavigator().handleError(throwable);
                    }
                }));
    }
}
