package com.hbs.repository;

import com.hbs.domain.service.consumer.Consumer;
import com.hbs.domain.service.consumer.ConsumerContactMethod;
import com.hbs.repository.ConsumerRepository;

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
public class ConsumerRepositoryTest {
    @Autowired
    ConsumerRepository consumerRepository;

    @Test
    public void testSaveConsumer(){
        Consumer consumer = new Consumer();
        consumer.setLoginAccount("xuzhike");
        consumer.setLoginPassword("pwd");
        List<ConsumerContactMethod> consumerContactMethods = new ArrayList<ConsumerContactMethod>();
        ConsumerContactMethod method1 = new ConsumerContactMethod();
        method1.setType("QQ");
        method1.setValue("111111111");
        method1.setConsumer(consumer);

        ConsumerContactMethod method2 = new ConsumerContactMethod();
        method2.setType("Email");
        method2.setValue("abc@163.com");
        method2.setConsumer(consumer);
        consumerContactMethods.add(method1);
        consumerContactMethods.add(method2);

        consumer.setContactMethodList(consumerContactMethods);

        consumerRepository.saveAndFlush(consumer);
    }

    @Test
    public void testFindConsumerById(){
        Consumer consumer = consumerRepository.findOne(7l);
        System.out.println(consumer);
    }
}
