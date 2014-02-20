package com.hbs.repository;

import com.hbs.domain.service.provider.ProviderContactMethod;
import com.hbs.domain.service.provider.ServiceProvider;
import com.hbs.repository.ServiceProviderRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-2-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ServiceProviderRepositoryTest {
    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @Test
    public  void saveServiceProvider(){
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setLoginAccount("account");
        serviceProvider.setLoginPassword("pwd");
        serviceProvider.setProviderName("name");
        serviceProvider.setProviderCode("code");

        List<ProviderContactMethod> providerContactMethods = new ArrayList<ProviderContactMethod>();
        ProviderContactMethod method1 = new ProviderContactMethod();
        method1.setType("QQ");
        method1.setValue("2222222");
        method1.setServiceProvider(serviceProvider);

        ProviderContactMethod method2 = new ProviderContactMethod();
        method2.setType("Email");
        method2.setValue("abc@qq.com");
        method2.setServiceProvider(serviceProvider);
        providerContactMethods.add(method1);
        providerContactMethods.add(method2);

        serviceProvider.setContactMethodList(providerContactMethods);

        serviceProviderRepository.saveAndFlush(serviceProvider);
    }
}
