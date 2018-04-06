package com.example.jett.dn_netframework_20180401.http;

import java.io.InputStream;

/**
 * 处理响应
 */

public interface IHttpListener {
    //接收上一个接口的结果
    void onSuccess(InputStream inputStream);

    void onFailure();
}







