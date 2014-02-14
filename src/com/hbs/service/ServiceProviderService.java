package com.hbs.service;

import com.hbs.domain.service.provider.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {
  public List<ServiceProvider> findAllServiceProvider();
  public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider);
  public List<ServiceProvider> findByLBCAndServiceKey(String lbcCode, String serviceKeys);
  public ServiceProvider findServiceProviderById(Long id);
}
