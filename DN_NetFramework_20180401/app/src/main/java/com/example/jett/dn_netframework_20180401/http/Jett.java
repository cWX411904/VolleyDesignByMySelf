package com.example.jett.dn_netframework_20180401.http;

/**
 * Created by jett on 2018/4/1.
 */

public class Jett {
    public static<T,M> void sendJsonRequest(T requestInfo,String url,Class<M> responce,IDataListener<M> dataListener){
        IHttpListener httpListener=new JsonHttpListener<>(dataListener,responce);
        IHttpService httpService=new JsonHttpService();
        HttpTask<T> httpTask=new HttpTask<T>(requestInfo,url,httpService,httpListener);
        ThreadPoolManager.getInstance().execute(httpTask);
    }
}
