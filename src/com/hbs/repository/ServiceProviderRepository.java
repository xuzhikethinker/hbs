package com.hbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbs.domain.service.provider.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
  public List<ServiceProvider> findByLBCAndServiceKey(String lbcCode, String serviceKeys);
}
