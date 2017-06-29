package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DollarTest {

    @Test
    public void test_one_dollar_is_one_dollar() throws Exception {
        assertEquals(new Dollar(1), new Dollar(1));
    }

    @Test
    public void test_one_dollar_is_not_two_dollar() throws Exception {
        assertNotEquals(new Dollar(1), new Dollar(2));
    }

    @Test
    public void test_one_dollar_multiply_two() throws Exception {
        Dollar oneDollar = new Dollar(1);
        assertEquals(new Dollar(2), oneDollar.multiply(2));
    }
}
