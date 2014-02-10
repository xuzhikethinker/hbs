package com.hbs.domain.service;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hbs.domain.common.PersistenceDomain;

/**
 * 服务项目，存在于服务类别之下。点击项目链接，则会跳转到该项目的查询结果上。
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_SERVICE_ITEM")
public class ServiceItem extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "SERVICE_NAME", nullable = false)
    private String serviceName;// 用于页面显示

    @Basic
    @Column(name = "SERVICE_CODE", nullable = false)
    private String serviceCode;// 服务代码，用于关联服务提供商

    @Basic
    @Column(name = "SERVICE_REMARKS", nullable = true)
    private String remarks;// 服务说明

    @Basic
    @Column(name = "ACTIVE", nullable = true)
    private boolean active = true;// 是否激活
    
    @Basic
    @Column(name = "PRIORITY_WEIGHT", nullable = true)
    private int priorityWeight = 0;// 优先级权重，数值越大，权重越大，则有可能会显示在侧栏。但是受限于侧栏允许显示的数量，见ServiceCategory.amountOnSideBar

    @ManyToOne
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "SERVICE_CATEGORY_ID")
    private ServiceCategory serviceCategory;

    public ServiceItem() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public int getPriorityWeight() {
      return priorityWeight;
    }

    public void setPriorityWeight(int priorityWeight) {
      this.priorityWeight = priorityWeight;
    }

    @Override
    public String toString() {
        return "ServiceItem{" + "serviceName=" + serviceName + ", serviceCode=" + serviceCode + ", remarks=" + remarks + ", active=" + active  + '}';
    }

}
