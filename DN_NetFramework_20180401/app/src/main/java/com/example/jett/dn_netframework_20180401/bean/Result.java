package com.example.jett.dn_netframework_20180401.bean;

/**
 * Created by Jett on 2017/10/13.
 */

public class Result {
    public Sk sk;
    public Today today;
    public int error_code;

    @Override
    public String toString() {
        return "Result{" +
                "sk=" + sk +
                ", today=" + today  +
                ", error_code=" + error_code +
                '}';
    }
}
