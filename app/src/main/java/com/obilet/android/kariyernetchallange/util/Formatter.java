package com.obilet.android.kariyernetchallange.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Mustafa Bayram on 26.12.2018.
 */
public class Formatter {

    private static final int FRACTION_DIGIT_MAXIMUM_LENGTH = 2;
    private static final int FRACTION_DIGIT_MINIMUM_LENGTH = 2;

    private static final String TR_LOCALE_CURRENCY_PATTERN = "#.##0,00 \u00A4";


    public static NumberFormat moneyFormatter(Locale locale, boolean includingCurrencySymbol) {

        // Get decimal and grouping separator
        char decimalSeparator = getDecimalSeparator(locale);
        char groupingSeparator = getGroupingSeparator(locale);

        // Initialize formatter
        DecimalFormat decimalFormater = (DecimalFormat) (includingCurrencySymbol ? NumberFormat.getCurrencyInstance(locale) : NumberFormat.getNumberInstance(locale));
        decimalFormater.setMaximumFractionDigits(FRACTION_DIGIT_MAXIMUM_LENGTH);
        decimalFormater.setMinimumFractionDigits(FRACTION_DIGIT_MINIMUM_LENGTH);

        if (locale.getLanguage().equals("tr") && includingCurrencySymbol) {
            // apply pattern default formatter
            decimalFormater.applyLocalizedPattern(TR_LOCALE_CURRENCY_PATTERN);
        }

        // Initialize formatter symbols
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        decimalFormatSymbols.setDecimalSeparator(decimalSeparator);
        decimalFormatSymbols.setGroupingSeparator(groupingSeparator);

        // Check if including currency symbol is defined
        if (includingCurrencySymbol) {
            // Get currency from locale
            Currency currency = Currency.getInstance(locale);

            decimalFormater.setCurrency(currency);

            // Set currency to decimalFormatSymbols
            decimalFormatSymbols.setCurrency(currency);

            // Set currency symbol to decimalFormatSymbols
            decimalFormatSymbols.setCurrencySymbol(currency.getSymbol());
        }

        // Set decimalFormatSymbols to decimal formatter
        decimalFormater.setDecimalFormatSymbols(decimalFormatSymbols);

        // Return formatter
        return decimalFormater;
    }

    public static char getDecimalSeparator(Locale locale) {
        DecimalFormatSymbols formatSymbols = DecimalFormatSymbols.getInstance(locale);
        return formatSymbols.getDecimalSeparator();
    }

    public static char getGroupingSeparator(Locale locale) {
        DecimalFormatSymbols formatSymbols = DecimalFormatSymbols.getInstance(locale);
        return formatSymbols.getGroupingSeparator();
    }
}
