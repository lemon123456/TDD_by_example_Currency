package com.tw;

public class Money {
    String currency;
    int amount;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return this.amount;
    }
}
