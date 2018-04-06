package com.example.chengkai.volleybymyself.http;

/**
 * 回调给应用层到接口
 *
 * Created by chengkai on 2018/4/6.
 */

public interface IDataListener<M> {

    void onSuccess(M m);
    void onFailure();
}
