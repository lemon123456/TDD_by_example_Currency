package com.tw;

class Bank {
    Bank() {
    }

    Money reduce(Money source, String toCurrency) {
        int rate = rate(source.getCurrency(), toCurrency);
        return new Money(source.getAmount() * rate, toCurrency);
    }

    private int rate(String sourceCurrency, String toCurrency) {
        int rate = 1;
        if (sourceCurrency.equals("USD") && toCurrency.equals("CHF")) {
            rate = 2;
        }
        return rate;
    }
}