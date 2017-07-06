package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {

    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        bank.setRate(new Pair(Currency.USD, Currency.CHF), 2);
    }

    @Test
    public void test_one_dollar_is_one_dollar() throws Exception {
        assertEquals(Money.dollar(1), Money.dollar(1));
    }

    @Test
    public void test_one_dollar_is_not_two_dollar() throws Exception {
        assertNotEquals(Money.dollar(1), Money.dollar(2));
    }

    @Test
    public void test_one_dollar_multiply_two() throws Exception {
        Money oneMoney = Money.dollar(1);
        assertEquals(Money.dollar(2), oneMoney.times(2));
    }

    @Test
    public void test_one_dollar_multiply_three() throws Exception {
        Money oneMoney = Money.dollar(1);
        assertEquals(Money.dollar(3), oneMoney.times(3));
    }

    @Test
    public void test_one_dollar_plus_one_dollar() throws Exception {
        Money oneMoney = Money.dollar(1);
        assertEquals(Money.dollar(2), oneMoney.plus(oneMoney));
    }

    @Test
    public void test_one_dollar_plus_two_dollar_plus_two() throws Exception {
        assertEquals(Money.dollar(6), Money.dollar(1).plus(Money.dollar(2)).times(2));

    }

    @Test
    public void dollar_unit_is_USD() throws Exception {
        assertEquals("USD", Money.dollar(1).getCurrency().name());

    }

    @Test
    public void test_reduce_one_dollar_to_dollar() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.dollar(1), bank.reduce(Money.dollar(1), Currency.USD));
    }

    @Test
    public void test_reduce_one_dollar_to_franc() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.franc(2), bank.reduce(Money.dollar(1), Currency.CHF));
    }

    @Test
    public void test_reduce_two_dollar_to_franc() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.franc(4), bank.reduce(Money.dollar(2), Currency.CHF));
    }

    @Test
    public void test_one_dollar_plus_two_franc() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.franc(4), bank.reduce(new Sum(Money.dollar(1), Money.franc(2)), Currency.CHF));
    }

    @Test
    public void test_one_dollar_plus_two_francs_plus_three_francs() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.franc(7), bank.reduce(new Sum(Money.dollar(1), Money.franc(2)).plus(Money.franc(3)), Currency.CHF));
    }

    @Test
    public void test_sum_plus_sum() throws Exception {
        Bank bank = this.bank;
        Sum sum = new Sum(Money.dollar(1), Money.franc(2));
        assertEquals(Money.franc(8), bank.reduce(sum.plus(sum), Currency.CHF));
    }

    @Test
    public void test_sum_times_three() throws Exception {
        Bank bank = this.bank;
        Sum sum = new Sum(Money.dollar(1), Money.franc(2));
        assertEquals(Money.franc(12), bank.reduce(sum.times(3), Currency.CHF));
    }

    @Test
    public void final_test() throws Exception {
        Bank bank = this.bank;
        assertEquals(Money.franc(22), bank.reduce(Money.dollar(1).plus(Money.dollar(2)).times(3).plus(Money.franc(4)), Currency.CHF));
    }

    @Test
    public void test_rate_for_CHF_to_USD() throws Exception {
        Bank bank = this.bank;
        bank.setRate(new Pair(Currency.CHF, Currency.USD), 0.5);
        assertEquals(0.5, bank.rate(Currency.CHF, Currency.USD), 0.01);
    }

}
