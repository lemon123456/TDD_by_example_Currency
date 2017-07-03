package com.tw;

public class Money {
    protected String currency;
    int amount;

    Money(int amount) {
        this.amount = amount;
    }

    String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return this.amount;
    }
}
