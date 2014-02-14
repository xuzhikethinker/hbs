package com.hbs.webapp.view;

import com.hbs.domain.service.provider.ServiceProvider;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderMaintainView extends BaseView {

  private List<ServiceProvider> ServiceProviderList = new ArrayList<ServiceProvider>();
  private ServiceProvider serviceProvider = new ServiceProvider();//用于创建或更新SP

  public List<ServiceProvider> getServiceProviderList() {
    return ServiceProviderList;
  }

  public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
    ServiceProviderList = serviceProviderList;
  }

  public ServiceProvider getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(ServiceProvider serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public void loadData() {
//    ServiceProviderList = this.serviceProviderService.findAllServiceProvider();
  }
  
  public void saveServiceProvider(){
    
  }

}
