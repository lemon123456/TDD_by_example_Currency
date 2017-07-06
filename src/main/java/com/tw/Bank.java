package com.tw;

import java.util.HashMap;

class Bank {

    private HashMap<Pair, Integer> rates = new HashMap<>();

    Money reduce(Expression source, Currency toCurrency) {
        return source.reduce(toCurrency, this);
    }


    void setRate(Pair pair, int rate) {
        rates.put(pair, rate);
    }

    double rate(Currency sourceCurrency, Currency toCurrency) {
        if (sourceCurrency.equals(toCurrency)) {
            return 1;
        }
        return rates.get(new Pair(sourceCurrency, toCurrency));
    }
}