package com.hbs.domain.support;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "HBS_CITY")
public class City extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "CITY_NAME", nullable = false)
    private String cityName;// 城市名称，用来给用户在页面上指定

    @Basic
    @Column(name = "CITY_CODE", nullable = false)
    private String cityCode;// 城市代码，使用电话区号来代替，一共四位，不足四位前面补0，如北京0010

    @Basic
    @Column(name = "PROVIDER_CODE", nullable = false)
    private String provinceCode;// 城市所属省份

    @Basic
    @Column(name = "CITY_KEY", nullable = true)
    private String keyword;// 存储城市拼音第一个字母，用来分组排序

    @Basic
    @Column(name = "CITY_SPELLING", nullable = true)
    private String spelling; // 汉语拼音，用来auto complete搜索

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

}
