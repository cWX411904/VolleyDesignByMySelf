package com.example.jett.dn_netframework_20180401.http;

/**
 * 请求
 */

public interface IHttpService {
    void setUrl(String url);
    void setRequestData(byte[] requestData);
    void execute();//用来执行网络操作
    void setHttpCallBack(IHttpListener httpListener);
}
