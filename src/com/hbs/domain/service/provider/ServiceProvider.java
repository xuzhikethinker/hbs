package com.hbs.domain.service.provider;

import com.hbs.domain.common.News;
import com.hbs.domain.service.AbstractUserInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 服务提供商
 *
 * @author develop
 */
@Entity
@Table(name = "HBS_SERVICE_PROVIDER")
public class ServiceProvider extends AbstractUserInfo {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "PROVIDER_NAME", nullable = false)
    private String providerName;

    @Basic
    @Column(name = "PROVIDER_CODE", nullable = false)
    private String providerCode;// 提供商的唯一代码，邮政编码+区号+其他， 系统提供，采用一种比较容易的方法来定位服务

    @Basic
    @Column(name = "PROVIDER_DESCRIPTION", nullable = true)
    private String description;

    @Basic
    @Column(name = "ACTIVE", nullable = true)
    private boolean active = true;// 是否激活

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AvailableService> servierList = new ArrayList<AvailableService>();// 可提供的服务，大部分是一项

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProviderContactMethod> contactMethodList = new ArrayList<ProviderContactMethod>();// 可提供的服务，大部分是一项

    @Basic
    @Column(name = "SERVICE_KEYWORD", nullable = true)
    private String serviceKeyword;// 服务关键字。搜索关键字，在用户添加服务代码的时候，把服务名称添加到这里，同时可以让服务提供商添加关键字

    @Basic
    @Column(name = "PLACE_KEYWORD", nullable = true)
    private String placeKeyword;// 地点关键字

    @Transient
    private List<News> newsList = new ArrayList<News>();

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductPicture> pictures = new HashSet<ProductPicture>();

    public ServiceProvider() {
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<AvailableService> getServierList() {
        return servierList;
    }

    public void setServierList(List<AvailableService> servierList) {
        this.servierList = servierList;
    }

    public String getServiceKeyword() {
        return serviceKeyword;
    }

    public void setServiceKeyword(String serviceKeyword) {
        this.serviceKeyword = serviceKeyword;
    }

    public String getPlaceKeyword() {
        return placeKeyword;
    }

    public void setPlaceKeyword(String placeKeyword) {
        this.placeKeyword = placeKeyword;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public Set<ProductPicture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<ProductPicture> pictures) {
        this.pictures = pictures;
    }

    public List<ProviderContactMethod> getContactMethodList() {
        return contactMethodList;
    }

    public void setContactMethodList(List<ProviderContactMethod> contactMethodList) {
        this.contactMethodList = contactMethodList;
    }
}
