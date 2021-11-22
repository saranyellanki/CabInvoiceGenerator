package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    int numOfRides;
    double totalFare;
    Object average;

    public InvoiceSummary(int numOfRides, double totalFare){
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.average = this.totalFare/this.numOfRides;
    }

    public InvoiceSummary(double totalFare){
        this.totalFare = totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0
                && Objects.equals(average, that.average);
    }
}
