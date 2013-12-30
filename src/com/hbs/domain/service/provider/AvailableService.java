package com.hbs.domain.service.provider;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hbs.domain.common.PersistenceDomain;

/**
 * 服务提供商所提供的服务，这些服务是系统已经定义好的。系统搜索服务的时候将根据这里的服务代码来获取结果。
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_SP_SERVICE")
public class AvailableService extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "SP_SERVICE_CODE", nullable = false)
    private String serviceItemCode;// 系统提供的服务代码

    @Basic
    @Column(name = "REMARKS", nullable = true)
    private String remarks;// 提供商对该服务的补充说明

    @Basic
    @Column(name = "DISPLAY_ORDER", nullable = false)
    private int displayOrder = 1;// 显示顺序，用户添加完所有的服务后，通过下拉菜单让用户定位显示顺序

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "SERVICE_PROVIDER_ID")
    private ServiceProvider serviceProvider;

    public AvailableService() {
    }

    public String getServiceItemCode() {
        return serviceItemCode;
    }

    public void setServiceItemCode(String serviceItemCode) {
        this.serviceItemCode = serviceItemCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

}
