/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hbs.service;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.repository.ServiceInfoRepository;
import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author develop
 */
@Service("serviceInfoService")
public class ServiceInfoServiceImpl extends AbstractBaseService implements ServiceInfoService {

    @Autowired
    ServiceInfoRepository serviceInfoRepository;
    
    @Override
    @Cacheable(value="serviceCategoryCache")
    public List<ServiceCategory> findAllServiceCategory() {
        EasyCriteria<ServiceCategory> easyCriteria = EasyCriteriaFactory.createQueryCriteria(this.getEntityManager(), ServiceCategory.class);
        List<ServiceCategory> results = easyCriteria.getResultList();
        return serviceInfoRepository.findAll();
    }
    
}
