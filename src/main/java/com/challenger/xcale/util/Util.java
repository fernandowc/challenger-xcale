package com.challenger.xcale.util;

import java.text.DecimalFormat;

public class Util {

    public static double formatNumber (double value) {

        double result;

        DecimalFormat df = new DecimalFormat("#.00");
        result = Double.parseDouble(df.format(value));

        return result;
    }

}
