package com.tw;

public interface Expression {
    Money reduce(String toCurrency, Bank bank);
}
