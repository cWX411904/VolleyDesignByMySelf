package com.example.chengkai.volleybymyself.http;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * 一次http的任务类
 *
 * Created by wangsujuan on 2018/4/6.
 */

public class HttpTask<T> implements Runnable{

    private IHttpListener httpListener;
    private IHttpService httpService;

    /**
     * HttpTask：应用层发起一次网络请求的实体类
     * @param requestInfo 应用层发起请求的参数
     * @param url 应用层发起请求的url
     * @param httpService
     * @param httpListener
     * @param <T>
     */
    public<T> HttpTask(T requestInfo, String url, IHttpService httpService, IHttpListener httpListener) {
        this.httpService = httpService;
        this.httpListener = httpListener;

        httpService.setUrl(url);
        httpService.setHttpCallBack(httpListener);

        if (requestInfo != null) {
            String requestContent = JSON.toJSONString(requestInfo);
            try {
                httpService.setRequestData(requestContent.getBytes("utf-8"));
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
