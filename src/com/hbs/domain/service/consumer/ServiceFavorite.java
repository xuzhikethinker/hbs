package com.hbs.domain.service.consumer;

import com.hbs.domain.common.PersistenceDomain;
import com.hbs.domain.service.provider.ServiceProvider;

import javax.persistence.*;

/**
 * 用户的服务收藏夹，主要收藏服务提供商，但是需要根据服务代码来分类。用户在服务提供商上点击收藏，则系统需要自动对这些提供商进行分类。
 * 目前暂定只根据服务代码来分类
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_CONSUMER_SERVICE_FAVORITE")
public class ServiceFavorite extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "SERVICE_PROVIDER_CODE", nullable = false)
    private String serviceProviderCode;

    @Transient
    private ServiceProvider serviceProvider;

    @Basic
    @Column(name = "SERVICE_FAVORITE_DESC", nullable = true)
    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "USER_ID")
    private Consumer favoriteOwner;

    public ServiceFavorite() {
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

    public Consumer getFavoriteOwner() {
        return favoriteOwner;
    }

    public void setFavoriteOwner(Consumer favoriteOwner) {
        this.favoriteOwner = favoriteOwner;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

}
