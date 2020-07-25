package com.cab.service.model.user;

/**
 * Created by shivam.si on 25/07/20 6:47 am
 */
public class Driver extends User{
    private String cabNumber;
    private String licenseNumber;
    private Boolean available;
    private Integer thresholdDistance;
    //status waiting , riding, pooling
    public Driver(String id, String name, String email, String phone, int x, int y, String cabNumber, String licenseNumber) {
        super(id, name, email, phone, x, y);
        this.cabNumber = cabNumber;
        this.licenseNumber = licenseNumber;
        this.available = true;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
