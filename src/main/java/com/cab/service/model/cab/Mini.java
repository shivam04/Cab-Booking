package com.cab.service.model.cab;

/**
 * Created by shivam.si on 25/07/20 6:53 am
 */
public class Mini implements Cab{

    public double getAmount() {
        return 10.0;
    }

    public String getName() {
        return CabType.MINI.toString();
    }


}
