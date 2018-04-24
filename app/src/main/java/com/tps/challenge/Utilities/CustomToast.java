package com.tps.challenge.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tps.challenge.R;


public class CustomToast {
    Context mContext;

    public CustomToast(Context mContext) {
        this.mContext = mContext;
    }

    public void show(int toastMSG, int toastDuration) {

        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View toastView = inflater.inflate(R.layout.layout_toast, null);


        Toast toast = new Toast(mContext);
        toast.setView(toastView);

        /**(just a fake number) 1 is Long period & 0 is Short Period. **/
        if (toastDuration == 0) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }

        TextView toastText = (TextView) toastView.findViewById(R.id.toast_text);
        toastText.setText(mContext.getString(toastMSG));

        toast.show();
    }

    public void show(String toastMSG, int toastDuration) {

        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View toastView = inflater.inflate(R.layout.layout_toast, null);


        Toast toast = new Toast(mContext);
        toast.setView(toastView);

        /**(just a fake number) 1 is Long period & 0 is Short Period. **/
        if (toastDuration == 0) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }

        TextView toastText = (TextView) toastView.findViewById(R.id.toast_text);
        toastText.setText(toastMSG);

        toast.show();
    }
}
