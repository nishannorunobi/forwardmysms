package com.nishan.backgroundservices.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.util.List;

public class SmsHelper {
    Context context;
    private static final String TAG =
            SmsHelper.class.getSimpleName();

    List<SubscriptionInfo> subsInfoList = null;

    public SmsHelper(Context context) {
        this.context = context;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
            SubscriptionManager subscriptionManager = SubscriptionManager.from(context);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                //return;
            }

            subsInfoList = subscriptionManager.getActiveSubscriptionInfoList();

            Log.d(TAG, "Current list = " + subsInfoList);
        }
    }

    public String getTeleTalkSim() {
        if (subsInfoList == null) {
            return null;
        }

        for (SubscriptionInfo subscriptionInfo : subsInfoList) {
            String number = subscriptionInfo.getNumber();
            if (number != null && number.endsWith("01538087819")) {
                return number;
            }
            Log.d(TAG, "Tele talk Number is  " + number);
        }
        return null;
    }

    public String getSim1No() {
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        String num = mTelephonyMgr.getLine1Number();
        return num;
    }

    public String getBlinkSim() {
        if (subsInfoList == null) {
            return null;
        }

        for (SubscriptionInfo subscriptionInfo : subsInfoList) {
            String number = subscriptionInfo.getNumber();
            if (number != null && number.endsWith("0190736807")) {
                return number;
            }
            Log.d(TAG, " Blink Number is  " + number);
        }
        return null;
    }

}
