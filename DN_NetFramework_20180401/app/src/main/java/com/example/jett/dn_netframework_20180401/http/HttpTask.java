package com.example.jett.dn_netframework_20180401.http;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Created by jett on 2018/4/1.
 */

public class HttpTask<T> implements Runnable{
    private IHttpService httpService;
    private IHttpListener httpListener;

    protected HttpTask(T requestInfo,String url,IHttpService httpService, IHttpListener httpListener) {
        this.httpService = httpService;
        this.httpListener = httpListener;
        httpService.setUrl(url);
        httpService.setHttpCallBack(httpListener);
        if(requestInfo!=null){
            //把请求参数转换成json格式
            String requestContent= JSON.toJSONString(requestInfo);
            try {
                httpService.setRequestData(requestContent.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        httpService.execute();
    }
}
