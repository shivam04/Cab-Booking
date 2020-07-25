package com.cab.service;

import com.cab.service.model.booking.Booking;
import com.cab.service.model.cab.*;
import com.cab.service.model.user.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shivam.si on 25/07/20 7:01 am
 */
public class BookingManager {
    List<Booking> bookings;
    Map<String, User> userMap;
    Map<String, List<Booking>> riderBookings;

    public BookingManager() {
        bookings = new ArrayList<Booking>();
        userMap = new HashMap<String, User>();
        riderBookings = new HashMap<String, List<Booking>>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Map<String, List<Booking>> getRiderBookings() {
        return riderBookings;
    }

    public void addUser(UserType userType, String id, String name, String email, String phone, int x, int y, String cabNumber, String licenseNumber) {
        User user = null;
        switch (userType) {
            case RIDER:
                user = new Rider(id, name, email, phone, x, y);
                break;
            case DRIVER:
                user = new Driver(id, name, email, phone, x, y, cabNumber, licenseNumber);
        }
        userMap.put(user.getId(), user);
    }

    public void showBookings() {
        for(Booking booking : bookings) {
            User rider = booking.getRider();
            User driver = booking.getDriver();
            System.out.println(rider.getName() + " rides with " + driver.getName() + " for distance " + booking.getDistance() + "at a amount of " + booking.getBillingAmount() + "in a cab " + booking.getCab().getName());
        }
    }

    public void showIndividualBookings(String riderId) {
        List<Booking> bookings = riderBookings.get(riderId);
        for(Booking booking : bookings) {
            User rider = booking.getRider();
            User driver = booking.getDriver();
            System.out.println(rider.getName() + " rides with " + driver.getName() + " for distance " + booking.getDistance() + "at a amount of " + booking.getBillingAmount() + "in a cab " + booking.getCab().getName());
        }
    }

    public void updateRiderWallet(String riderId, double amount) {
        Rider rider = (Rider) userMap.get(riderId);
        rider.setWallet(rider.getWallet() + amount);
    }

    public void addBooking(String riderId, int x1, int y1, CabType cabType) throws Exception {
        Rider rider = (Rider)userMap.get(riderId);
        Driver driver = BookingService.getDriver(x1, y1, userMap);
        if(driver == null) {
            throw new Exception("Driver Not available");
        }
        int x2 = driver.getX();
        int y2 = driver.getY();
        double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        Cab cab = null;
        switch (cabType) {
            case MINI:
                cab = new Mini();
                break;
            case MICRO:
                cab = new Micro();
                break;
            case PRIME:
                cab = new Prime();
                break;
        }
        Booking booking = BookingService.createBooking(distance, driver, rider, cab);
        bookings.add(booking);
        if(!riderBookings.containsKey(rider.getId())) {
            riderBookings.put(rider.getId(), new ArrayList<Booking>());
        }
        riderBookings.get(rider.getId()).add(booking);
        driver.setAvailable(false);
    }

    public void updateDriverLocation(String driverId, int x, int y) {
        User driver = userMap.get(driverId);
        driver.setX(x);
        driver.setY(y);
    }
}
