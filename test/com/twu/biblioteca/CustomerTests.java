package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by subham on 11/01/15.
 */
public class CustomerTests {
    @Test
    public void checkEquality()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertTrue(customer.equals(new Customer("John","john@gmail.com","9123456780","123-1234","xxxx")));
    }

    @Test
    public void checkInequality()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertFalse(customer.equals(new Customer("Jane", "john@gmail.com", "9123456780", "123-1234", "xxxx")));
    }

    @Test
    public void checkGetLibraryNumber()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertEquals(customer.getLibraryNumber(),"123-1234");
    }
}

