package com.nishan.backgroundservices.services;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.nishan.backgroundservices.MainActivity;

public class MySmsReceiver extends BroadcastReceiver {
    private static final String TAG =
            MySmsReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
        String format = bundle.getString("format");
        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                    //SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.i(TAG, "senderNum: " + senderNum + "; message: ######################## " + message);
                    if (senderNum.endsWith("01790736807")) {
                        new MySmsSender(context).sendSms(message);
                    }

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e(TAG, "######################## Exception smsReceiver" + e);

        }
    }
}
