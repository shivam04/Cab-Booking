package com.cab.service.cronService;

import com.cab.service.BookingManager;
import com.cab.service.model.user.Driver;
import com.cab.service.model.user.User;

import java.util.Map;

/**
 * Created by shivam.si on 25/07/20 8:04 am
 */
public class UpdateCabLocation implements Runnable{

    private BookingManager bookingManager;
    int[] X = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] Y = { -1, 0, 1, -1, 1, -1, 0, 1 };
    public UpdateCabLocation(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void run() {
        Map<String, User> userMap = bookingManager.getUserMap();
        Driver driver = null;
        for(Map.Entry<String, User> user : userMap.entrySet()) {
            if (user.getValue() instanceof Driver) {
                driver = (Driver) user.getValue();
                for(int i=0;i<4;i++) {
                    driver.setX(driver.getX() + X[i]);
                    driver.setY(driver.getY() + Y[i]);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
