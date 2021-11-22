package com.bridgelabz;

public class Ride {
    InvoiceGenerator.RideType type;
    double distance;
    int time;
    String userId;

    
    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }
    
    public Ride(double distance, int time, String userId,InvoiceGenerator.RideType type ){
        this.distance = distance;
        this.time = time;
        this.userId = userId;
        this.type = type;
    }
}
