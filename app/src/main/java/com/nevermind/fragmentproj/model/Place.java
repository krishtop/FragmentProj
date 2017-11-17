package com.nevermind.fragmentproj.model;

import java.io.Serializable;

/**
 * Created by Dmitry on 06.11.2017.
 */

public class Place implements Serializable {
    private String address;
    private String info;
    private long distance;
    private String telephone;
    private int rate;

    public Place(String address, String info, long distance, String telephone, int rate) {
        this.address = address;
        this.info = info;
        this.distance = distance;
        this.telephone = telephone;
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

