package com.abcd.findyourdoctor.util;

import android.content.Context;
import android.text.format.DateFormat;

import java.util.Calendar;

public class TimeUtil {
    public static String getFormattedDate(Context context, long smsTimeInMilis) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(smsTimeInMilis);

        Calendar now = Calendar.getInstance();

        final String timeFormatString = "h:mm aa";
        final String dateTimeFormatString = "EEEE, MMMM d, h:mm aa";
        final long HOURS = 60 * 60 * 60;
        if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
            return "Today";
        } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
            return "Yesterday";
        } else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
            return DateFormat.format(dateTimeFormatString, smsTime).toString();
        } else {
            return DateFormat.format("MMMM dd yyyy, h:mm aa", smsTime).toString();
        }
    }

    public static String getTimeFromTimeStamp(Context context, long timestamp) {
        Calendar smsTime = Calendar.getInstance();
        smsTime.setTimeInMillis(timestamp);
        return DateFormat.format("h:mm aa", smsTime).toString();
    }
}
