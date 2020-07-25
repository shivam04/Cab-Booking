package com.cab.service.model.user;

/**
 * Created by shivam.si on 25/07/20 6:46 am
 */
public class Rider extends User{

    private Double wallet;

    public Rider(String id, String name, String email, String phone, int x, int y) {
        super(id, name, email, phone, x, y);
        this.wallet = 0.0;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
