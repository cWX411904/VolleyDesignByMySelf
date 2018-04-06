package com.example.chengkai.volleybymyself.http;

/**
 * Created by wangsujuan on 2018/4/6.
 */

public class Volley {

    public static<T,M> void sendJsonRequest(T requestInfo, String url, Class<M> response, IDataListener<M> dataListener)
    {
        IHttpService httpService = new JsonHttpService();
        IHttpListener httpListener = new JsonHttpListener<>(dataListener,response);
        HttpTask<T> httpTask = new HttpTask<T>(requestInfo,url,httpService,httpListener);
        ThreadPoolManager.getOurInstance().execute(httpTask);
    }
}
