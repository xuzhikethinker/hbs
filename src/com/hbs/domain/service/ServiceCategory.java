package com.hbs.domain.service;

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

/**
 * 这是系统提供的服务分类，类似于京东、淘宝的商品分类。暂定于两级，方便用户。但系统支持多级.用户点击类别，则会展开该类别所拥有的服务项目
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_SERVICE_CATEGORY")
public class ServiceCategory extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;// 分类名称，用于页面显示

    @Basic
    @Column(name = "CATEGORY_CODE", nullable = false)
    private String categoryCode;// 分类代码，用于服务项使用

    @Basic
    @Column(name = "CATEGORY_PARENT_CODE", nullable = true)
    private String parentCategoryCode; // 上一级分类代码

    @Basic
    @Column(name = "CATEGORY_REMARKS", nullable = true)
    private String remarks; // 分类说明

    @Basic
    @Column(name = "ACTIVE", nullable = true)
    private boolean active = true; // 是否激活

    @OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ServiceItem> serviceItemList = new ArrayList<ServiceItem>();

    public ServiceCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getParentCategoryCode() {
        return parentCategoryCode;
    }

    public void setParentCategoryCode(String parentCategoryCode) {
        this.parentCategoryCode = parentCategoryCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ServiceItem> getServiceItemList() {
        return serviceItemList;
    }

    public void setServiceItemList(List<ServiceItem> serviceItemList) {
        this.serviceItemList = serviceItemList;
    }

    @Override
    public String toString() {
        return "ServiceCategory{" + "categoryName=" + categoryName + ", categoryCode=" + categoryCode + ", parentCategoryCode=" + parentCategoryCode + ", remarks=" + remarks + ", active=" + active + '}';
    }

}