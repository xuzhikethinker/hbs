package com.hbs.repository;

import com.hbs.domain.service.provider.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    @Query("select u from ServiceProvider u")
  public List<ServiceProvider> findByLBCAndServiceKey(String lbcCode, String serviceKeys);
}
