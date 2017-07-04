package com.tw;

public interface Expression {
    Money reduce(String toCurrency, Bank bank);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}
