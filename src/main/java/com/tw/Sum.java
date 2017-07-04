package com.tw;

public class Sum implements Expression {
    private final Money augend;
    private final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money getAugend() {
        return augend;
    }

    public Money getAddend() {
        return addend;
    }

    @Override
    public Money reduce(String toCurrency, Bank bank) {
        return bank.reduce(getAugend(), toCurrency).plus(bank.reduce(getAddend(), toCurrency));
    }
}
