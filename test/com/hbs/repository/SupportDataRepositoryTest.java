package com.hbs.repository;

import com.hbs.domain.support.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SupportDataRepositoryTest {
    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void getProvice(){
        List<Province> provinceList = locationRepository.findAll();
        System.out.println("province list = "+provinceList.size());
    }
}
