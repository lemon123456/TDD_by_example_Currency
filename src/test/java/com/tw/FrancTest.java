package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FrancTest {

    @Test
    public void test_one_franc_is_one_franc() throws Exception {
        assertEquals(new Franc(1), new Franc(1));
    }

    @Test
    public void test_one_franc_is_not_two_franc() throws Exception {
        assertNotEquals(new Franc(1), new Franc(2));
    }

    @Test
    public void test_one_franc_multiply_two() throws Exception {
        Franc oneFranc = new Franc(1);
        assertEquals(new Franc(2), oneFranc.times(2));
    }

    @Test
    public void test_one_franc_multiply_three() throws Exception {
        Franc oneFranc = new Franc(1);
        assertEquals(new Franc(3), oneFranc.times(3));
    }

    @Test
    public void test_one_franc_plus_one_franc() throws Exception {
        Franc oneFranc = new Franc(1);
        assertEquals(new Franc(2), oneFranc.plus(oneFranc));
    }

    @Test
    public void test_one_franc_plus_two_franc_plus_two() throws Exception {
        assertEquals(new Franc(6), new Franc(1).plus(new Franc(2)).times(2));

    }

    @Test
    public void test_Franc_unit_is_CHF() throws Exception {
        assertEquals("CHF", new Franc(1).getCurrency());

    }

}
