package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    @Test
    public void test_rate_for_USD_to_USD() throws Exception {
        assertEquals(1, new Bank().rate(Currency.USD, Currency.USD), 0.01);
    }

    @Test
    public void test_rate_for_CHF_to_CHF() throws Exception {
        assertEquals(1, new Bank().rate(Currency.CHF, Currency.CHF), 0.01);
    }

    @Test
    public void test_rate_for_USD_to_CHF() throws Exception {
        Bank bank = new Bank();
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 2);
        assertEquals(2, bank.rate(Currency.USD, Currency.CHF), 0.01);
    }

    @Test
    public void test_setting_rate() throws Exception {
        Bank bank = new Bank();
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 3);
        bank.setRate(new Pair(Currency.USD, Currency.CNY), 7);
        assertEquals(3, bank.rate(Currency.USD, Currency.CHF), 0.01);
        assertEquals(7, bank.rate(Currency.USD, Currency.CNY), 0.01);
    }
}
