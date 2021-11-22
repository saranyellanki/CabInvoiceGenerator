package com.bridgelabz;

public class Ride {
    double distance;
    int time;
    String userId;

    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }
    public Ride(double distance, int time, String userId){
        this.distance = distance;
        this.time = time;
        this.userId = userId;
    }

}
