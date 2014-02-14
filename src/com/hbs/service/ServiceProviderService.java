package com.hbs.service;

import java.util.List;

import com.hbs.domain.service.provider.ServiceProvider;

public interface ServiceProviderService {
  public List<ServiceProvider> findAllServiceProvider();
  public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
  public List<ServiceProvider> findByLBCAndServiceKey(String lbcCode, String serviceKeys);
  public ServiceProvider findServiceProviderById(Long id);
}
