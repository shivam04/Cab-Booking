package com.cab.service.model.cab;

/**
 * Created by shivam.si on 25/07/20 6:53 am
 */
public class Micro implements Cab{
    //numberseat
    public double getAmount() {

        return 5.0;
    }

    public String getName() {
        return CabType.MICRO.toString();
    }
}
