package com.example.jett.dn_netframework_20180401.http;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by jett on 2018/4/1.
 */

public class JsonHttpListener<M> implements IHttpListener {

    private IDataListener<M> dataListener;
    Class<M> responceClass;
    //用于线程的切换
    Handler handler = new Handler(Looper.getMainLooper());


    public JsonHttpListener(IDataListener<M> dataListener, Class<M> responceClass) {
        this.dataListener = dataListener;
        this.responceClass = responceClass;
    }

    @Override
    public void onSuccess(InputStream inputStream) {
        //把获取到的byte数据转换成String
        String content = getContent(inputStream);
        //再把string转成对象返回给调用层就行了
        final M responce = JSON.parseObject(content, responceClass);
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(dataListener!=null){
                    dataListener.onSuccess(responce);
                }
            }
        });
    }

    @Override
    public void onFailure() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(dataListener!=null){
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
