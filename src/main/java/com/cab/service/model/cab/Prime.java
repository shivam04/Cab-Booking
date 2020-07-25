package com.cab.service.model.cab;

/**
 * Created by shivam.si on 25/07/20 6:54 am
 */
public class Prime implements Cab{
    public double getAmount() {
        return 20.0;
    }

    public String getName() {
        return CabType.PRIME.toString();
    }
}
