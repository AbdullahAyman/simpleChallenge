package com.tps.challenge.Views.Activities.Models;

import android.databinding.ObservableField;

import com.tps.challenge.DataLayer.DataManager;
import com.tps.challenge.DataLayer.DataModels.db.UsersDBTable;
import com.tps.challenge.Utilities.rx.SchedulerProvider;
import com.tps.challenge.Views.Activities.Navigators.MainActivityViewNavigator;
import com.tps.challenge.Views.BaseViews.BaseViewModel;

import io.reactivex.functions.Consumer;

public class MainActivityViewModel extends BaseViewModel<MainActivityViewNavigator> {

    public ObservableField<String> fName;
    public ObservableField<String> lName;
    public ObservableField<String> phoneNumber;

    public MainActivityViewModel(DataManager dataManager,
                                 SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        fName = new ObservableField<>();
        fName.set("");
        lName = new ObservableField<>();
        lName.set("");
        phoneNumber = new ObservableField<>();
        phoneNumber.set("");
    }

    public void displayUserData() {
        setIsLoading(true);
        getNavigator().showLoading();
        String email = getDataManager().getCurrentUserEmail();
        getCompositeDisposable().add(getDataManager()
                .getUserWithEmail(email)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UsersDBTable>() {
                    @Override
                    public void accept(UsersDBTable response) throws Exception {

                        setIsLoading(false);
                        getNavigator().hideLoading();
                        phoneNumber.set(response.getMobileNo());
                        fName.set(response.getFirstName());
                        lName.set(response.getLastName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().hideLoading();
                        getNavigator().handleError(throwable);
                        getNavigator().showToast("error display user data", 1);
                    }
                }));
    }

    public void onEditPhone() {
        getNavigator().showPopupToEditPhone(phoneNumber.get());
    }

    public void showImages() {
        getNavigator().navigateToImagesView();
    }

    public void logOut() {
        getDataManager().setUserAsLoggedOut();
        getNavigator().logOut();
    }
}
