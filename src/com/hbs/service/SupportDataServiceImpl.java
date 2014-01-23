package com.hbs.service;

import com.hbs.domain.support.Province;
import com.hbs.repository.SupportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("supportDataService")
public class SupportDataServiceImpl implements SupportDataService {

    @Autowired
    private SupportDataRepository supportDataRepository;

    @Override
    @Cacheable("provinces")
    public List<Province> findAllProvince() {
        return supportDataRepository.findAll();
    }
}
