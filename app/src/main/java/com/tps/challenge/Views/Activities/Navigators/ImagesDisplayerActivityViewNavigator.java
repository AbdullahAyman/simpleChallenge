package com.tps.challenge.Views.Activities.Navigators;

import com.tps.challenge.DataLayer.DataModels.api.Photos.Photo;
import com.tps.challenge.Views.BaseNavigator;

import java.util.List;

public interface ImagesDisplayerActivityViewNavigator extends BaseNavigator{

    void assignAdapter(List<Photo> items);

    void loadImages();
}
