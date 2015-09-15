package com.cf.study.jse.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18NSample {

    public static void main(final String[] args) {

        String language = "en";
        String country = "GB";

        if (args.length == 2) {
            language = args[0];
            country = args[1];
        }

        final Locale currentLocale;
        final ResourceBundle message;

        currentLocale = new Locale(language, country);
        message = ResourceBundle.getBundle("MessageBundle", currentLocale);

        System.out.println(message.getString("greetings"));
        System.out.println(message.getString("inquiry"));
        System.out.println(message.getString("farewell"));

        final DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, currentLocale);
        final Date today = new Date();
        System.out.println(df.format(today));

        final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(currentLocale);
        System.out.println(currencyFormat.format(1209382808));
    }
}
