package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnTotalFare() {
        InvoiceGenerator iG = new InvoiceGenerator();
        double distance = 2;
        int time = 5;
        double totalFare = iG.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnTotalFareOfMultipleRides(){
        InvoiceGenerator iG = new InvoiceGenerator();
        Ride[] rides = {
                        new Ride(2.0,5),
                        new Ride(3.0,5),
                        new Ride(1.0,1)
                        };
        double multipleRideFare = iG.calculateFare(rides);
        Assert.assertEquals(71,multipleRideFare,0.0);
    }
}
