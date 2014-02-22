package com.hbs.domain.service.provider;

import com.hbs.domain.common.News;

import javax.persistence.*;

/**
 * Created by Administrator on 14-2-21.
 */
@Entity
@DiscriminatorValue("SERVICE_PROVIDER")
public class ProviderNews extends News {
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
    @JoinColumn(name = "NEWS_SOURCE")
    private ServiceProvider serviceProvider;

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
