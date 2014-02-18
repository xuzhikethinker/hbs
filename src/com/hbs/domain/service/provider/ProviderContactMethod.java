package com.hbs.domain.service.provider;

import com.hbs.domain.common.ContactMethod;

import javax.persistence.*;

@Entity
@DiscriminatorValue("P")
public class ProviderContactMethod extends ContactMethod {
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
    @JoinColumn(name = "USER_ID")
    private ServiceProvider serviceProvider;

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
