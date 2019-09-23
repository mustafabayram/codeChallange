package com.obilet.android.kariyernetchallange.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class DateUtils {

    public static String getMonthFullName(String month) {
        int monthAsInt = Integer.valueOf(month);
        Calendar calendar = Calendar.getInstance(new Locale("tr", "TR"));
        calendar.set(Calendar.MONTH, monthAsInt);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", new Locale("tr", "TR"));
        return dateFormat.format(calendar.getTime());
    }
}
