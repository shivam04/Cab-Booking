package com.cab.service;

import com.cab.service.model.booking.Booking;
import com.cab.service.model.cab.Cab;
import com.cab.service.model.user.Driver;
import com.cab.service.model.user.User;

import java.util.Map;

/**
 * Created by shivam.si on 25/07/20 6:57 am
 */
public class BookingService {
    public static Booking createBooking(double distance, User driver, User rider, Cab cab) {
        Booking booking = new Booking(distance, driver, rider, cab);
        booking.setBillingAmount(distance*cab.getAmount());
        return booking;
    }

    public static Driver getDriver(int x1, int y1, Map<String, User> userMap) {
        double minDistance = 100000000.0;
        Driver driver = null;
        for(Map.Entry<String, User> user : userMap.entrySet()) {
            if(user.getValue() instanceof Driver) {
                Driver driver1 = (Driver)user.getValue();
                if(driver1.isAvailable()) {
                    int x2 = user.getValue().getX();
                    int y2 = user.getValue().getY();
                    double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                    if (distance < minDistance) {
                        minDistance = distance;
                        driver = driver1;
                    }
                }
            }
        }
        return driver;
    }
}
