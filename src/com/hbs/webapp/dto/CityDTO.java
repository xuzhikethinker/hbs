package com.hbs.webapp.dto;

import com.hbs.domain.support.City;

import java.io.Serializable;

/**
 * Created by Administrator on 14-1-25.
 */
public class CityDTO implements Serializable {
    protected String proviceCode;
    protected String cityCode;
    protected String cityName;


    public String getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(String proviceCode) {
        this.proviceCode = proviceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City convertToCity(){
        City city = new City();
        city.setCityCode(cityCode);
        city.setCityName(cityName);
        city.setProvinceCode(proviceCode);
        return city;
    }
}
