package com.hbs.domain.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hbs.domain.common.PersistenceDomain;

@Entity
@Table(name = "HBS_DISTRICT")
public class District extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "DISTRICT_NAME", nullable = false)
    private String districtName;// 区的名字，如香洲区

    @Basic
    @Column(name = "DISCTRICT_CODE", nullable = false)
    private String districtCode;// 区代码，城市代码+两位数字

    @Basic
    @Column(name = "CITY_CODE", nullable = false)
    private String cityCode;// 城市代码

    @Basic
    @Column(name = "DESCRIPTION", nullable = true)
    private String description;//

    @Basic
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LifeBusinessCircle> lifeBusinessCicles = new ArrayList<LifeBusinessCircle>();

    @Basic
    @Column(name = "KEYWORDS", nullable = true)
    private String keywords;// 众人对某个区的某些重点地带，如凤凰北，邮政大厦，主要用来标识某个区的重点，如唐家没有搜索到，则会搜索香洲区的凤凰北，而不会去搜索电脑城附近。这里面的词可以从用户输入的关键字拼凑。

    public District() {
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LifeBusinessCircle> getLifeBusinessCicles() {
        return lifeBusinessCicles;
    }

    public void setLifeBusinessCicles(List<LifeBusinessCircle> lifeBusinessCicles) {
        this.lifeBusinessCicles = lifeBusinessCicles;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
