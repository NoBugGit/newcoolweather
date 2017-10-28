package com.example.administrator.newcoolweather.util;

import android.text.TextUtils;

import com.example.administrator.newcoolweather.model.City;
import com.example.administrator.newcoolweather.model.CoolWeatherDB;
import com.example.administrator.newcoolweather.model.County;
import com.example.administrator.newcoolweather.model.Province;

/**
 * Created by Administrator on 2017/10/27.
 */

public class Utility {
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces=response.split(",");
            if(allProvinces!=null&&allProvinces.length>0){
                for(String p:allProvinces){
                    String [] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeatherDB,
                                                          String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities=response.split(",");
            for(String c:allCities){
                String[] array=c.split("\\|");
                City city=new City();
                city.setCityCode(array[0]);
                city.setCityName(array[1]);
                city.setProvinceId(provinceId);
                coolWeatherDB.saveCity(city);
            }
            return true;
        }
        return false;
    }
    public synchronized static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,
                                                            String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allCounties=response.split(",");
            for(String c:allCounties){
                County county=new County();
                String[] array=c.split("\\|");
                county.setCountyCode(array[0]);
                county.setCountyName(array[1]);
                county.setCityId(cityId);
                coolWeatherDB.saveCounty(county);
            }
            return true;
        }
        return false;
    }
}
