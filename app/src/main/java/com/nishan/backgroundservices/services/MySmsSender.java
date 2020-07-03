package com.nishan.backgroundservices.services;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

import com.nishan.backgroundservices.utils.SmsHelper;

public class MySmsSender {
    private static final String TAG =
            MySmsSender.class.getSimpleName();
    Context context;
    SmsHelper smsHelper;
    public MySmsSender(Context context) {
        this.context = context;
        this.smsHelper = new SmsHelper(context);
    }

    public void sendSms(String message) {
        //Getting intent and PendingIntent instance
        Intent intent = new Intent(context, context.getClass());
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);

        //String senderNum = "8801538087819";//smsHelper.getSim1No();
        //Log.i(TAG, "######################## senderNum: " + senderNum);

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("8801790736807", null, message, pi, null);
    }
}
