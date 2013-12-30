/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hbs.service;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.repository.ServiceInfoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author develop
 */
@Service("serviceInfoService")
public class ServiceInfoServiceImpl implements ServiceInfoService {

    @Autowired
    ServiceInfoRepository serviceInfoRepository;
    
    @Override
    @Cacheable(value="serviceCategoryCache")
    public List<ServiceCategory> findAllServiceCategory() {
        return serviceInfoRepository.findAll();
    }
    
}
