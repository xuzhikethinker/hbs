package com.hbs.domain.support;

import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hbs.domain.common.PersistenceDomain;

/**
 * 生活、商业圈，这个圈比小区大，但比行政区小，如香洲区可以分为凤凰北生活/商业圈，百货公司商业圈，湾仔沙生活/商业圈等等。
 * 楼盘小区属于某个生活商业圈，生活商业圈属于某个行政区
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_LIFE_BUSINESS_CIRCLE")
public class LifeBusinessCircle extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "CIRCLE_NAME", nullable = false)
    private String circleName;// 生活圈名字

    @Basic
    @Column(name = "CIRCLE_CODE", nullable = false)
    private String circleCode;// 生活圈代码，区代码+序号

    @Basic
    @Column(name = "DISTRICT_CODE", nullable = false)
    private String districtCode; // 生活圈所属区代码

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "DISTRICT_ID")
    private District district;

    @Basic
    @Column(name = "DESCRIPTION", nullable = true)
    private String description;// 描述

    @Basic
    @Column(name = "KEYWORDS", nullable = true)
    private String keywords;// 该圈的关键词，包括小区，街道名，主要建筑群等等

    @Transient
    private List<LifeBusinessCircle> neighbourCircles = new ArrayList<LifeBusinessCircle>();

    public LifeBusinessCircle() {
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCircleCode() {
        return circleCode;
    }

    public void setCircleCode(String circleCode) {
        this.circleCode = circleCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<LifeBusinessCircle> getNeighbourCircles() {
        return neighbourCircles;
    }

    public void setNeighbourCircles(List<LifeBusinessCircle> neighbourCircles) {
        this.neighbourCircles = neighbourCircles;
    }

}
