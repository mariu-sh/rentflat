package com.mariuszf.rentflat.utils;

public class Utils {

    public static double roundWithPrecision(double value, int precision) {
        double factor = Math.pow(10, precision);
        return (double)Math.round(value * factor) / factor;
    }
}
