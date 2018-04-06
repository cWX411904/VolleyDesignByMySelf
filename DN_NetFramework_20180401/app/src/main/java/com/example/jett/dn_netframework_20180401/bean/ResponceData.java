package com.example.jett.dn_netframework_20180401.bean;

/**
 * Created by baby on 2017/5/26.
 */

public class ResponceData {
    public String resultcode;
    public String reason;
    public Result result;
    int error_code;

    @Override
    public String toString() {
        return "ResponceData{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
