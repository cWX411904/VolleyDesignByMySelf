package com.example.jett.dn_netframework_20180401.bean;

/**
 * Created by Jett on 2017/10/13.
 */

public class Sk {
    public String temp;
    public String wind_direction;
    public String wind_strength;
    public String humidity;
    public String time;

    @Override
    public String toString() {
        return "Sk{" +
                "temp='" + temp + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", wind_strength='" + wind_strength + '\'' +
                ", humidity='" + humidity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
