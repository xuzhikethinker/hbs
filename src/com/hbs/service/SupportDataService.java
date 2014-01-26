package com.hbs.service;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.support.Province;

import java.util.List;
import java.util.Map;

public interface SupportDataService {
    public List<Province> findAllProvince();
    public List<ServiceCategory> findAllService();
    public Map<String, Province> getProvinceMap();
    public void saveProvice(Province province);
}
