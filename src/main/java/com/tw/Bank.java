package com.tw;

import java.util.HashMap;

class Bank {

    private HashMap<Pair, Integer> rates = new HashMap<>();

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency, this);
    }

    int rate(String sourceCurrency, String toCurrency) {
        if (sourceCurrency.equals(toCurrency)) {
            return 1;
        }
        return rates.get(new Pair(sourceCurrency, toCurrency));
    }

    void setRate(Pair pair, int rate) {
        rates.put(pair, rate);
    }
}