package com.tps.challenge.DataLayer.Remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.tps.challenge.BuildConfig;
import com.tps.challenge.DataLayer.DataModels.api.Photos.PhotosResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;


@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {

    }

    @Override
    public Single<PhotosResponse> loadImagesApi() {
        return Rx2AndroidNetworking.get(ApiEndPoint.IMAGES_URL)
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .addQueryParameter("sol","152")
                .addQueryParameter("camera","NAVCAM")
                .build()
                .getObjectSingle(PhotosResponse.class);
    }

    @Override
    public Single<PhotosResponse> doLogoutApiCall() {
        return null;
    }
}
