package com.hbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbs.domain.service.provider.ServiceProvider;
import com.hbs.repository.ServiceProviderRepository;

@Service("serviceProviderService")
public class ServiceProviderServiceImpl extends AbstractBaseService implements ServiceProviderService {

  @Autowired
  private ServiceProviderRepository serviceProviderRepository;

  @Override
  public List<ServiceProvider> findAllServiceProvider() {
    return serviceProviderRepository.findAll();
  }

  @Override
  public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
    return serviceProviderRepository.saveAndFlush(serviceProvider);
  }

  public List<ServiceProvider> findByLBCAndServiceKey(String lbcCode, String serviceKeys) {
    return serviceProviderRepository.findByLBCAndServiceKey(lbcCode, serviceKeys);
  }

  public ServiceProvider findServiceProviderById(Long id) {
    return serviceProviderRepository.findOne(id);
  }
}
