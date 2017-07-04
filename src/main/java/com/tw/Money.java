package com.tw;

public class Money implements Expression {
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

    @Override
    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression expression) {
        if (expression instanceof Money) {
            Money addend = (Money) expression;
            if (this.getCurrency().equals(addend.getCurrency())) {
                return new Money(this.amount + addend.amount, this.currency);
            }
        }
        return new Sum(this, expression);
    }

    @Override
    public Money reduce(String toCurrency, Bank bank) {
        int rate = bank.rate(getCurrency(), toCurrency);
        return new Money(getAmount() * rate, toCurrency);
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
