package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {

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
        assertEquals("USD", Money.dollar(1).getCurrency());

    }

}
