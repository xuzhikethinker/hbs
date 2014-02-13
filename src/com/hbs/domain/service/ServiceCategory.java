package com.hbs.domain.service;

import com.hbs.domain.common.PersistenceDomain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Basic
    @Column(name = "DISP_SEQUENCE", nullable = true)
    private int displaySeq;
    
    @Basic
    @Column(name = "AMOUNT_ON_SIDE_BAR", nullable = true)
    private int amountOnSideBar=6; //显示在侧栏的项目数量 

    @OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "priorityWeight DESC")
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

    public int getDisplaySeq() {
        return displaySeq;
    }

    public void setDisplaySeq(int displaySeq) {
        this.displaySeq = displaySeq;
    }

    public int getAmountOnSideBar() {
      return amountOnSideBar;
    }

    public void setAmountOnSideBar(int amountOnSideBar) {
      this.amountOnSideBar = amountOnSideBar;
    }

    @Override
    public String toString() {
        return "ServiceCategory{" + "categoryName=" + categoryName + ", categoryCode=" + categoryCode + ", parentCategoryCode=" + parentCategoryCode + ", remarks=" + remarks + ", active=" + active + '}';
    }

}
