package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
        double totalFare = iG.calculateFare(distance, time, InvoiceGenerator.RideType.NORMAL_RIDE);
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
                new Ride(2.0, 5, "1", InvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride(3.0, 5, "1", InvoiceGenerator.RideType.PREMIUM_RIDE),
                new Ride(3.0, 5, "2", InvoiceGenerator.RideType.NORMAL_RIDE),
                new Ride(1.0, 1, "1", InvoiceGenerator.RideType.NORMAL_RIDE)
        };
        InvoiceSummary invoiceSummary = iG.invoice(rides, "1");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(91);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}
