package com.mukesh.utils;

import static com.mukesh.domain.enums.Currency.DOLLAR;
import static com.mukesh.domain.enums.Currency.EURO;
import static com.mukesh.domain.enums.Currency.POUND;

import com.mukesh.domain.enums.Currency;

public class CurrencyUtils {

    public static Currency convertStringToCurrency (String currency) {
        switch (currency.toLowerCase()) {
            case "euro":
                return EURO;
            case "dollar":
                return DOLLAR;
            case "pound":
                return POUND;

                default:
                    return EURO;

        }
    }
}
