package com.bank.customerservice.util;

import java.util.UUID;

public final class CustomerNumberGenerator {

    private CustomerNumberGenerator() {
    }

    public static String generate() {

        String randomPart = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10)
                .toUpperCase();

        return "CUST-" + randomPart;
    }
}