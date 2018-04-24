package com.tps.challenge.Views.Dialgos.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tps.challenge.R;
import com.tps.challenge.Views.BaseViews.BaseDialog;
import com.tps.challenge.Views.Dialgos.Models.EditMobileDialogModel;
import com.tps.challenge.Views.Dialgos.Navigator.EditMobileDialogNavigator;
import com.tps.challenge.databinding.DialogEditMobileBinding;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class EditMobileDialogView extends BaseDialog implements EditMobileDialogNavigator {
    private static final String TAG = "EditMobileDialogView";
    @Inject
    EditMobileDialogModel mViewModel;
    DialogEditMobileBinding mViewBinding;
    callBack icallBack;
    public static EditMobileDialogView newInstance() {
        return new EditMobileDialogView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(
                inflater, R.layout.dialog_edit_mobile, container, false);
        View view = mViewBinding.getRoot();
        AndroidSupportInjection.inject(this);
        mViewModel.setNavigator(this);
        mViewModel.displayMobile();
        hideKeyboard();
        mViewBinding.dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopup();
            }
        });
        mViewBinding.dialogSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.saveClick(mViewBinding.dialogMobileEt.getText().toString());
            }
        });
        return view;
    }


    public void show(FragmentManager fragmentManager, callBack listener) {
        super.show(fragmentManager, TAG);
        this.icallBack = listener;
    }

    @Override
    public void dismissPopup() {
        dismissDialog(TAG);
        hideKeyboard();
        icallBack.onDismiss();
    }

    @Override
    public void mobileError(String error) {
        mViewBinding.dialogMobileEt.setError(error);
    }

    @Override
    public void setPhone(String phone) {
        mViewBinding.dialogMobileEt.setText(phone);
    }


    public interface callBack{
        void onDismiss();
    }
}
