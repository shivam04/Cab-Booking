package com.cab.service.model.user;

/**
 * Created by shivam.si on 25/07/20 6:43 am
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private int x;
    private int y;

    public User(String id, String name, String email, String phone, int x, int y) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
