package com.bridgelabz;

public class InvoiceGenerator {

    public double FARE_PER_KILOMETER = 10;
    public double FARE_PER_MINUTE = 1;
    public double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * FARE_PER_KILOMETER + time * FARE_PER_MINUTE;
        if (totalFare < MINIMUM_FARE) return MINIMUM_FARE;
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
