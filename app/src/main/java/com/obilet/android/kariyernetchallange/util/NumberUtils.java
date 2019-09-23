package com.obilet.android.kariyernetchallange.util;

import android.os.Build;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Mustafa Bayram on 2019-09-23.
 */
public class NumberUtils {

    private static String TURKISH_CURRENCY_SYMBOL = "\u20ba";

    public static String moneyStringIncludingTurkishCurrencySymbol(double number) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return String.format("%s %s", moneyString(number, new Locale("tr", "TR")), TURKISH_CURRENCY_SYMBOL);
        }
        return String.format("%s %s", moneyString(number, new Locale("tr", "TR")), "TL");
    }

    public static String moneyString(double number, Locale locale) {
        NumberFormat formatter = Formatter.moneyFormatter(locale, false);
        return formatter.format(number);
    }
}
