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
