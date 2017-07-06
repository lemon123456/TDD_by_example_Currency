package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FrancTest {

    @Test
    public void test_one_franc_is_one_franc() throws Exception {
        assertEquals(Money.franc(1), Money.franc(1));
    }

    @Test
    public void test_one_franc_is_not_two_franc() throws Exception {
        assertNotEquals(Money.franc(1), Money.franc(2));
    }

    @Test
    public void test_one_franc_multiply_two() throws Exception {
        Money oneMoney = Money.franc(1);
        assertEquals(Money.franc(2), oneMoney.times(2));
    }

    @Test
    public void test_one_franc_multiply_three() throws Exception {
        Money oneMoney = Money.franc(1);
        assertEquals(Money.franc(3), oneMoney.times(3));
    }

    @Test
    public void test_one_franc_plus_one_franc() throws Exception {
        Money oneMoney = Money.franc(1);
        assertEquals(Money.franc(2), oneMoney.plus(oneMoney));
    }

    @Test
    public void test_one_franc_plus_two_franc_plus_two() throws Exception {
        assertEquals(Money.franc(6), Money.franc(1).plus(Money.franc(2)).times(2));

    }

    @Test
    public void test_Franc_unit_is_CHF() throws Exception {
        assertEquals("CHF", Money.franc(1).getCurrency().name());

    }

}
