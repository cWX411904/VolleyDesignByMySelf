package com.example.jett.dn_netframework_20180401;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jett.dn_netframework_20180401.bean.ResponceData;
import com.example.jett.dn_netframework_20180401.http.IDataListener;
import com.example.jett.dn_netframework_20180401.http.Jett;

public class MainActivity extends AppCompatActivity {

    String url="http://v.juhe.cn/weather/index?&cityname=长沙&key=fd0f609b22905a0a56a48d7cf59a558b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view){
//        for(int i=0;i<10;i++) {
            Jett.sendJsonRequest(null, url, ResponceData.class, new IDataListener<ResponceData>() {
                @Override
                public void onSuccess(ResponceData responceData) {
//                    Toast.makeText(MainActivity.this, "城市:" + responceData.result.today.city + " 今天的温度:" + responceData.result.today.temperature, Toast.LENGTH_SHORT).show();
                        Log.i("jett","城市:" + responceData.result.today.city);
                }

                @Override
                public void onFailure() {
                    Log.i("jett", "访问失败");
                }
            });
//        }
    }
}








