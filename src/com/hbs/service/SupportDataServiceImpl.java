package com.hbs.service;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.support.Province;
import com.hbs.repository.ServiceInfoRepository;
import com.hbs.repository.SupportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("supportDataService")
public class SupportDataServiceImpl implements SupportDataService {

    @Autowired
    private SupportDataRepository supportDataRepository;

    @Autowired
    private ServiceInfoRepository serviceInfoRepository;
    @Override
    @Cacheable("provinces")
    public List<Province> findAllProvince() {
        return supportDataRepository.findAll();
    }

    @Override
    @Cacheable("services")
    public List<ServiceCategory> findAllService() {
        return serviceInfoRepository.findOrderByDisplaySeq();
    }

    @Override
    @Cacheable("provinceMap")
    public Map<String, Province> getProvinceMap() {
        Map<String, Province> provinceMap = new HashMap<String, Province>();
        for(Province province:findAllProvince()){
            provinceMap.put(province.getProvinceCode(),province);
        }
        return provinceMap;
    }

    @Override
//    @CacheEvict(value="provinces",allEntries=true)setCityName
    @Caching(evict = { @CacheEvict(value="provinces",allEntries=true), @CacheEvict(value="provinceMap",allEntries=true) })
    public void saveProvice(Province province) {
        supportDataRepository.saveAndFlush(province);
    }

    @Override
    @Caching(evict = { @CacheEvict(value="services",allEntries=true)})
    public void saveServiceCategory(ServiceCategory category) {
        serviceInfoRepository.saveAndFlush(category);
    }
}
