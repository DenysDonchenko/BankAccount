package com.bank.api.utils;

public final class PhoneNumberUtils {

    private PhoneNumberUtils() {
    }

    public static String adjustPhoneNumber(String phone) {
        if (phone.startsWith("380")) {
            return "+" + phone;
        } else if (phone.startsWith("80")) {
            return "+3" + phone;
        } else if (phone.startsWith("0")) {
            return "+38" + phone;
        }
        return phone;
    }
}
