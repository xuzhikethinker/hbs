package com.hbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbs.domain.service.provider.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

}
