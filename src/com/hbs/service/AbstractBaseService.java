package com.hbs.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


public abstract class AbstractBaseService {
  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEntityManagerFactory(EntityManagerFactory emf) {
    this.emf = emf;
  }

  protected EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
  
//  @SuppressWarnings("unchecked")
//  public static <T> EasyCriteria<T> getEasyCriteria(T t){
//    return (EasyCriteria<T>) EasyCriteriaFactory.createQueryCriteria(getEntityManager(), t.getClass());
//  }
}
