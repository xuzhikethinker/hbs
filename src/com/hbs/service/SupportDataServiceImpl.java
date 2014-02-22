package com.hbs.service;

import com.hbs.domain.common.News;
import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.support.Province;
import com.hbs.repository.LocationRepository;
import com.hbs.repository.NewsRepository;
import com.hbs.repository.ServiceInfoRepository;
import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("supportDataService")
public class SupportDataServiceImpl extends AbstractBaseService implements SupportDataService {


    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ServiceInfoRepository serviceInfoRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    @Cacheable("provinces")
    public List<Province> findAllProvince() {
        return locationRepository.findAll();
    }

    @Cacheable("activeProvinces")
    public List<Province> findProvinceWithLBCList() {
        List<Province> activeProviceList = new ArrayList<Province>();
        for (Province province : this.findAllProvince()) {
            if (province.isContainActiveCity()) {
                activeProviceList.add(province);
            }
        }
        return activeProviceList;
    }

    @Override
    @Cacheable("services")
    public List<ServiceCategory> findAllService() {
        EasyCriteria<ServiceCategory> easyCriteria = EasyCriteriaFactory.createQueryCriteria(this.getEntityManager(), ServiceCategory.class);
        List<ServiceCategory> results = easyCriteria.getResultList();
        return serviceInfoRepository.findOrderByDisplaySeq();
    }

    @Override
    @Cacheable("provinceMap")
    public Map<String, Province> getProvinceMap() {
        Map<String, Province> provinceMap = new HashMap<String, Province>();
        for (Province province : findAllProvince()) {
            provinceMap.put(province.getProvinceCode(), province);
        }
        return provinceMap;
    }

    @Override
//    @CacheEvict(value="provinces",allEntries=true)setCityName
    @Caching(evict = {@CacheEvict(value = "provinces", allEntries = true), @CacheEvict(value = "provinceMap", allEntries = true)})
    public void saveProvice(Province province) {
        locationRepository.saveAndFlush(province);
    }

    @Override
    @Caching(evict = {@CacheEvict(value = "services", allEntries = true)})
    public void saveServiceCategory(ServiceCategory category) {
        serviceInfoRepository.saveAndFlush(category);
    }

    public void saveSystemNews(News news){
        newsRepository.saveAndFlush(news);
    }

    public News findNewsById(Long id){
        return newsRepository.findOne(id);
    }
}
