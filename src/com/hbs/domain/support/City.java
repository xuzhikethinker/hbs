package com.hbs.domain.support;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Column(name = "PROVINCE_CODE", nullable = false)
    private String provinceCode;// 城市所属省份

    @Basic
    @Column(name = "CITY_KEY", nullable = true)
    private String keyword;// 存储城市拼音第一个字母，用来分组排序

    @Basic
    @Column(name = "CITY_SPELLING", nullable = true)
    private String spelling; // 汉语拼音，用来auto complete搜索

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<District> districts = new HashSet<District>();

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public void addDistrict(District district){
        district.setCity(this);
        districts.add(district);
    }

    public List<District> getDistrictList(){
        List<District> districtList = new ArrayList<District>();
        districtList.addAll(districts);
        return districtList;
    }
}
