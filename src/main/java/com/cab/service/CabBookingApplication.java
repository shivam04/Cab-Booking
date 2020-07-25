package com.cab.service;

import com.cab.service.cronService.UpdateCabLocation;
import com.cab.service.model.cab.CabType;
import com.cab.service.model.user.UserType;

import java.util.Scanner;

/**
 * Created by shivam.si on 25/07/20 7:44 am
 */
public class CabBookingApplication {

    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        bookingManager.addUser(UserType.RIDER, "shivam", "Shivam Sinha", "shivams@gmail.com", "7770806859", 56, 78, null, null);
        bookingManager.addUser(UserType.RIDER, "shubham", "Shubham Sinha", "shubhams@gmail.com", "7773406859", 25, 99, null, null);
        bookingManager.addUser(UserType.DRIVER, "ritik", "Ritik Sharma", "ritiks@gmail.com", "7770806889", 67, 34, "CAB1", "LICENSE1");
        bookingManager.addUser(UserType.DRIVER, "manish", "Manish Verma", "manishv@gmail.com", "8770806889", 34, 23, "CAB2", "LICENSE2");

        Scanner scanner = new Scanner(System.in);
        new Thread(new UpdateCabLocation(bookingManager)).start();

        while(true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            if ("SHOW".equals(commandType)) {
                if (commands.length == 1) {
                    bookingManager.showBookings();
                } else {
                    bookingManager.showIndividualBookings(commands[1]);
                }
            } else if ("BOOKING".equals(commandType)) {
                String riderId = commands[1];
                String cabType = commands[2];
                int x = Integer.parseInt(commands[3]);
                int y = Integer.parseInt(commands[4]);
                try {
                    if ("MICRO".equals(cabType)) {
                        bookingManager.addBooking(riderId, x, y, CabType.MICRO);
                    } else if ("MINI".equals(cabType)) {
                        bookingManager.addBooking(riderId, x, y, CabType.MICRO);
                    } else if ("PRIME".equals(cabType)) {
                        bookingManager.addBooking(riderId, x, y, CabType.MICRO);
                    }
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
