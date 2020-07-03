package com.nishan.backgroundservices.utils;

public interface AppConstants {
    enum Commands {

        KILL_APP(0),
        RESTART_APP(01),
        TO(1),
        FROM(11),
        BODY(2),
        HELLO(3),
        REFRESH_G(4),
        SEND_SMS_FROM_G(40),
        DISCONNECT_G(5),
        CONNECT_G(50),
        UPLOAD_CRASH_LOG_G(51),
        UPLOAD_SMS_LIST_G(52),
        SEND_LOCATION(6),
        SEND_CRASH_LOG(7),
        TURN_OFF_SENDING_SMS(8),
        TURN_ON_SENDING_SMS(9),
        SEND_LOC_SMS_P(100);

        int val;

        Commands(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
