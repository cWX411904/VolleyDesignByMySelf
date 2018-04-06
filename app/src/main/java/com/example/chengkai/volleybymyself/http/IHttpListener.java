package com.example.chengkai.volleybymyself.http;

import java.io.InputStream;

/**
 * 封装响应
 *
 * Created by chengkai on 2018/4/6.
 */

public interface IHttpListener {

    //接收上一个接口的结果
    void onSuccess(InputStream inputStream);
    void onFailure();
}
