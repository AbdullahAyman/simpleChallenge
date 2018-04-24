package com.tps.challenge.Views.Dialgos.Models;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.Utilities.AppLogger;
import com.tps.challenge.Utilities.CommonUtils;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.BaseViews.BaseViewModel;
import com.tps.challenge.Views.Dialgos.Navigator.EditMobileDialogNavigator;

import io.reactivex.functions.Consumer;


public class EditMobileDialogModel extends BaseViewModel<EditMobileDialogNavigator> {


    private String typedMobile;

    public EditMobileDialogModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

    }


    public void displayMobile() {
        typedMobile = getDataManager().getMobileNo();
        AppLogger.d(typedMobile);
        getNavigator().setPhone(typedMobile);
    }

    public void saveClick(String typedMobile) {
        if (CommonUtils.isPhoneValid(typedMobile)) {
            //TODO update db and shared pref
            AppLogger.d(typedMobile.concat(" is valid"));
            getNavigator().showLoading();
            getDataManager().setMobileNumber(typedMobile);
            getCompositeDisposable().add(getDataManager()
                    .updateMobileUser(getDataManager().getCurrentUserEmail(), typedMobile)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Boolean>() {
                        @Override
                        public void accept(Boolean response) throws Exception {
                            getNavigator().hideLoading();
                            if (response) {
                                getNavigator().showToast("Number was edited successfully", 1);
                                getNavigator().dismissPopup();
                            } else {
                                AppLogger.d("User Not registered");
                                getNavigator().showToast("Failed", 1);
                            }
                            setIsLoading(false);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            setIsLoading(false);
                            getNavigator().hideLoading();
                            getNavigator().showToast("User Not registered", 1);
                            getNavigator().handleError(throwable);
                        }
                    }));
        } else {
            AppLogger.d(typedMobile.concat(" not valid"));
            getNavigator().showToast("Invalid phone number", 1);
        }
    }
}
