package com.hbs.repository;

import com.hbs.domain.service.consumer.Consumer;
import com.hbs.domain.service.consumer.ConsumerContactMethod;
import com.hbs.domain.service.consumer.FavoriteServiceGroup;
import com.hbs.domain.service.consumer.FavoriteServiceItem;
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
        
        List<FavoriteServiceGroup> myFavoriteGroups = new ArrayList<FavoriteServiceGroup>();
        FavoriteServiceGroup group1 = new FavoriteServiceGroup();
        group1.setConsumer(consumer);
        group1.setGroupName("group name");
        
        List<FavoriteServiceItem> favoriteServiceItemList = new ArrayList<FavoriteServiceItem>();
        FavoriteServiceItem item1 = new FavoriteServiceItem();
        item1.setFavoriteServiceGroup(group1);
        item1.setServiceProviderCode("AAAAA");
        favoriteServiceItemList.add(item1);
        
        FavoriteServiceItem item2 = new FavoriteServiceItem();
        item2.setFavoriteServiceGroup(group1);
        item2.setServiceProviderCode("BBBBB");
        favoriteServiceItemList.add(item2);
        
        group1.setFavoriteServiceItemList(favoriteServiceItemList);
        myFavoriteGroups.add(group1);
        
        consumer.setMyFavoriteGroups(myFavoriteGroups);
        
        consumerRepository.saveAndFlush(consumer);
    }

    @Test
    public void testFindConsumerById(){
        Consumer consumer = consumerRepository.findOne(7l);
        System.out.println(consumer);
    }
}
