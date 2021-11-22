package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnTotalFare() {
        InvoiceGenerator fare = new InvoiceGenerator();
        double distance = 2;
        int time = 5;
        double totalFare = fare.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }
}
