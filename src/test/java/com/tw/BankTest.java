package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    @Test
    public void test_rate_for_USD_to_USD() throws Exception {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void test_rate_for_CHF_to_CHF() throws Exception {
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }

    @Test
    public void test_rate_for_USD_to_CHF() throws Exception {
        Bank bank = new Bank();
        bank.setRate(new Pair("USD", "CHF"), 2);
        assertEquals(2, bank.rate("USD", "CHF"));
    }

    @Test
    public void test_setting_rate() throws Exception {
        Bank bank = new Bank();
        bank.setRate(new Pair("USD", "CHF"), 3);
        bank.setRate(new Pair("USD", "CNY"), 7);
        assertEquals(3, bank.rate("USD", "CHF"));
        assertEquals(7, bank.rate("USD", "CNY"));
    }
}
