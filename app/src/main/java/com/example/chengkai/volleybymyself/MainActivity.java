package com.example.chengkai.volleybymyself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.chengkai.volleybymyself.bean.ResponceData;
import com.example.chengkai.volleybymyself.http.IDataListener;
import com.example.chengkai.volleybymyself.http.Volley;

public class MainActivity extends AppCompatActivity {

    String url="http://v.juhe.cn/weather/index?&cityname=长沙&key=fd0f609b22905a0a56a48d7cf59a558b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Volley.sendJsonRequest(null, url, ResponceData.class, new IDataListener<ResponceData>() {
            @Override
            public void onSuccess(ResponceData responceData) {
                Log.i("chengkai","城市:" + responceData.result.today.city);
            }

            @Override
            public void onFailure() {
                Log.i("chengkai", "访问失败");
            }
        });
    }
}
