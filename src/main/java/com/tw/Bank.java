package com.tw;

class Bank {
    Bank() {
    }

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String sourceCurrency, String toCurrency) {
        int rate = 1;
        if (sourceCurrency.equals("USD") && toCurrency.equals("CHF")) {
            rate = 2;
        }
        return rate;
    }
}