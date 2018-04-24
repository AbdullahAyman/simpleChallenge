package com.tps.challenge.DataLayer.Remote;

import com.tps.challenge.DataLayer.DataModels.api.Photos.PhotosResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<PhotosResponse> loadImagesApi();

    Single<PhotosResponse> doLogoutApiCall();

}
