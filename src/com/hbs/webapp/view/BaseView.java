/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbs.webapp.view;

import com.hbs.service.ServiceProviderService;
import com.hbs.service.SupportDataService;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * 
 * @author develop
 */
public abstract class BaseView {
    @ManagedProperty(value = "#{supportDataService}")
    protected SupportDataService supportDataService;
    
    @ManagedProperty(value = "#{serviceProviderService}")
    protected ServiceProviderService serviceProviderService;

    public SupportDataService getSupportDataService() {
        return supportDataService;
    }

    public void setSupportDataService(SupportDataService supportDataService) {
        this.supportDataService = supportDataService;
    }
    
    public ServiceProviderService getServiceProviderService() {
      return serviceProviderService;
    }

    public void setServiceProviderService(ServiceProviderService serviceProviderService) {
      this.serviceProviderService = serviceProviderService;
    }

    protected FacesContext getCurrentFacesContext() {
    return FacesContext.getCurrentInstance();
  }

    public abstract void loadData();

  /**
   * 可以通过ExternalContext获取requestMap等，getRequestParameterMap()
   * 
   * @return
   */
  protected ExternalContext getCurrentExternalContext() {
    return this.getCurrentFacesContext().getExternalContext();
  }

  protected ServletContext getServletContext() {
    return (ServletContext) this.getCurrentExternalContext().getContext();
  }

  protected String getInitParamValueByKey(String name) {
    return this.getCurrentExternalContext().getInitParameter(name);
  }
}
