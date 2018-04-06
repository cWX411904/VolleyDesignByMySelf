package com.example.chengkai.volleybymyself.http;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wangsujuan on 2018/4/6.
 */

public class JsonHttpListener<M> implements IHttpListener {

    private Class<M> responseClass;
    private IDataListener<M> dataListener;
    //用于线程到切换
    private Handler handler = new Handler(Looper.getMainLooper());

    public JsonHttpListener(IDataListener<M> dataListener, Class<M> responseClass) {
        this.dataListener = dataListener;
        this.responseClass = responseClass;
    }

    @Override
    public void onSuccess(InputStream inputStream) {
        //获取响应结果，把byte数据转换成String数据
        String content = getContent(inputStream);
        //处理json字符串，转换为对象
        final M response = JSON.parseObject(content, responseClass);
        //把结果传送到调用层
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dataListener != null) {
                    dataListener.onSuccess(response);
                }
            }
        });

    }

    @Override
    public void onFailure() {
        //把结果传送到调用层
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dataListener != null) {
                    dataListener.onFailure();
                }
            }
        });

    }

    private String getContent(InputStream inputStream) {
        String content = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error=" + e.toString());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Error=" + e.toString());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
