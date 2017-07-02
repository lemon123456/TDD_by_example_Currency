package com.tw;

public class Money {
    protected int amount;
    protected String currency;

    public Money(int amount) {
        this.amount = amount;
        currency = "CHF";
    }

    @Override
    public int hashCode() {
        return this.amount;
    }
}
