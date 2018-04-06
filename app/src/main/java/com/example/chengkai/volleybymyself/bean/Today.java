package com.example.chengkai.volleybymyself.bean;

/**
 * Created by Jett on 2017/10/13.
 */

public class Today {
    public String temperature;
    public String weather;
    public Weather_id weather_id;
    public String wind;
    public String week;
    public String city;
    public String date_y;
    public String dressing_index;
    public String dressing_advice;
    public String uv_index;
    public String comfort_index;
    public String wash_index;
    public String drying_index;

    @Override
    public String toString() {
        return "Today{" +
                "temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", weather_id=" + weather_id +
                ", wind='" + wind + '\'' +
                ", week='" + week + '\'' +
                ", city='" + city + '\'' +
                ", date_y='" + date_y + '\'' +
                ", dressing_index='" + dressing_index + '\'' +
                ", dressing_advice='" + dressing_advice + '\'' +
                ", uv_index='" + uv_index + '\'' +
                ", comfort_index='" + comfort_index + '\'' +
                ", wash_index='" + wash_index + '\'' +
                ", drying_index='" + drying_index + '\'' +
                '}';
    }
}
