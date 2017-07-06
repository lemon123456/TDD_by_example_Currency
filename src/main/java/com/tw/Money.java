package com.tw;

public class Money implements Expression {
    private Currency currency;
    private int amount;


    Money(int amount, Currency currency1) {
        this.amount = amount;
        setCurrency(currency1);
    }

    static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    int getAmount() {
        return amount;
    }

    @Override
    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, getCurrency());
    }

    @Override
    public Expression plus(Expression expression) {
        if (expression instanceof Money) {
            Money addend = (Money) expression;
            if (getCurrency().equals(addend.getCurrency())) {
                return new Money(this.amount + addend.amount, getCurrency());
            }
        }
        return new Sum(this, expression);
    }

    @Override
    public Money reduce(Currency toCurrency, Bank bank) {
        int rate = bank.rate(getCurrency(), toCurrency);
        return new Money(getAmount() * rate, toCurrency);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Money money = (Money) object;

        if (amount != money.amount) return false;
        return currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + amount;
        return result;
    }

    public Currency getCurrency() {
        return currency;
    }

    private void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
