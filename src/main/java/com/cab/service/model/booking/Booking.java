package com.cab.service.model.booking;

import com.cab.service.model.cab.Cab;
import com.cab.service.model.user.User;

/**
 * Created by shivam.si on 25/07/20 6:49 am
 */
public class Booking {
    private double distance;
    private static int bookingId;
    private User driver;
    private User rider;
    private double billingAmount;
    private Cab cab;
    //private Sting status; => "ride, end, cancelled"

    public Booking(double distance, User driver, User rider, Cab cab) {
        this.distance = distance;
        this.driver = driver;
        this.rider = rider;
        this.cab = cab;
    }

    public double getDistance() {
        return distance;
    }

    public static int getBookingId() {
        return bookingId;
    }

    public User getDriver() {
        return driver;
    }

    public User getRider() {
        return rider;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public Cab getCab() {
        return cab;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static void setBookingId(int bookingId) {
        Booking.bookingId = bookingId;
    }

    public void setDriver(User driverId) {
        this.driver = driverId;
    }

    public void setRider(User riderId) {
        this.rider = riderId;
    }

    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }
}
