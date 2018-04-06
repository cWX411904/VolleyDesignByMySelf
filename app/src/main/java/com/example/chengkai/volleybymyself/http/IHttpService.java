package com.example.chengkai.volleybymyself.http;

/**
 * 封装请求
 *
 * Created by chengkai on 2018/4/6.
 */

public interface IHttpService {

    //1.设置URL
    void setUrl(String url);

    //2.设置请求参数
    void setRequestData(byte[] requestData);

    //3.执行请求
    void execute();

    //需要设置两个接口之间的关系
    void setHttpCallBack(IHttpListener httpListener);
}
