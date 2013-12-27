package com.hbs.domain.service.consumer;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hbs.domain.common.PersistenceDomain;

@Entity
@Table(name = "HBS_USER_SERVICE_ORDER")
public class ServiceOrder extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "ORDER_NUM", nullable = false)
    private String orderNum;// 订单号码，系统生成，服务提供商代码+时间戳？

    @Basic
    @Column(name = "SERVICE_PROVIDER_CODE", nullable = false)
    private String serviceProviderCode;

    @Basic
    @Column(name = "ORDER_DESC", nullable = true)
    private String description;

    @Basic
    @Column(name = "PRICE", nullable = true)
    private double price;

    @Basic
    @Column(name = "STATUS", nullable = false)
    private int status = 1;// 订单状态，是否用enum表示

    @ManyToOne(optional = false)
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "USER_ID")
    private UserInfo orderOwner;

    public ServiceOrder() {
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getServiceProviderCode() {
        return serviceProviderCode;
    }

    public void setServiceProviderCode(String serviceProviderCode) {
        this.serviceProviderCode = serviceProviderCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserInfo getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(UserInfo orderOwner) {
        this.orderOwner = orderOwner;
    }

}
