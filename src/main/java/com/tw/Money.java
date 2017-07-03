package com.tw;

public class Money {
    private String currency;
    private int amount;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    int getAmount() {
        return amount;
    }

    String getCurrency() {
        return currency;
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    Money plus(Money addend) {
        return new Money(this.amount + addend.amount, this.currency);
    }

    @Override
    public int hashCode() {
        return this.amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money money = (Money) obj;
            return this.amount == money.amount && money.currency.equals(this.currency);
        }
        return false;
    }
}
