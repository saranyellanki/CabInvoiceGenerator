package com.bridgelabz;


public class InvoiceGenerator {

    public double FARE_PER_KILOMETER_NORMAL = 10;
    public double FARE_PER_MINUTE_NORMAL = 1;
    public double FARE_PER_KILOMETER_PREMIUM = 15;
    public double FARE_PER_MINUTE_PREMIUM = 2;
    public double MINIMUM_FARE_NORMAL = 5;
    public double MINIMUM_FARE_PREMIUM = 20;

    enum RideType {
        PREMIUM_RIDE,
        NORMAL_RIDE
    }

    public double calculateFare(double distance, int time, RideType type) {
        if (type == RideType.PREMIUM_RIDE) {
            double totalFare = distance * FARE_PER_KILOMETER_PREMIUM + time * FARE_PER_MINUTE_PREMIUM;
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
        } else {
            double totalFare = distance * FARE_PER_KILOMETER_NORMAL + time * FARE_PER_MINUTE_NORMAL;
            return Math.max(totalFare, MINIMUM_FARE_NORMAL);
        }
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, ride.type);
        }
        return totalFare;
    }

    public InvoiceSummary invoiceSummaryCalculation(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, ride.type);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary invoice(Ride[] rides, String userId) {
        double totalFare = 0;
        for (Ride ride : rides) {
            if (ride.userId.equals(userId)) {
                totalFare += this.calculateFare(ride.distance, ride.time, ride.type);
            }
        }
        return new InvoiceSummary(totalFare);
    }
}
