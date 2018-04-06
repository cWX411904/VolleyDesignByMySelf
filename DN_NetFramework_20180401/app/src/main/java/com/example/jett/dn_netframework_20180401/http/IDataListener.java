package com.example.jett.dn_netframework_20180401.http;

/**
 * Created by jett on 2018/4/1.
 */

public interface IDataListener<M> {
    void onSuccess(M m);
    void onFailure();
}
