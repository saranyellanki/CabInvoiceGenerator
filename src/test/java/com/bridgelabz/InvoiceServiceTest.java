package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceTest {
    InvoiceGenerator iG;

    @Before
    public void setUp() throws Exception {
        iG = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnTotalFare() {
        double distance = 2;
        int time = 5;
        double totalFare = iG.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnTotalFareOfMultipleRides(){
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(3.0,5),
                new Ride(1.0,1)
        };
        double multipleRideFare = iG.calculateFare(rides);
        Assert.assertEquals(71,multipleRideFare,0.0);
    }

    @Test
    public void givenDistanceAndTimeWhenAddedShouldReturnInvoiceSummary(){
        Ride[] rides = {
                new Ride(2.0,5),
                new Ride(3.0,5),
                new Ride(1.0,1)
        };
        InvoiceSummary invoiceSummary = iG.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,71);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }

    @Test
    public void givenUserIdWhenAddedShouldReturnInvoice(){
        Ride[] rides = {
                new Ride(2.0,5,"1"),
                new Ride(3.0,5,"2"),
                new Ride(1.0,1,"3")
        };
        InvoiceSummary invoiceSummary = iG.invoice(rides,"2");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary("2",35);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}
