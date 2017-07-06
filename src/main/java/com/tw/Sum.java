package com.tw;

public class Sum implements Expression {
    private final Expression augend;
    private final Expression addend;

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    private Expression getAugend() {
        return augend;
    }

    private Expression getAddend() {
        return addend;
    }

    @Override
    public Money reduce(Currency toCurrency, Bank bank) {
        Money money = bank.reduce(getAugend(), toCurrency);
        Money addend = bank.reduce(getAddend(), toCurrency);
        return (Money) money.plus(addend);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
