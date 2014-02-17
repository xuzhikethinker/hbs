package com.hbs.webapp.view;

import com.hbs.domain.service.provider.ServiceProvider;
import com.hbs.domain.support.Province;
import com.hbs.webapp.view.admin.SupportDataMaintainView;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="serviceProviderMaintainView")
@ViewScoped
public class ServiceProviderMaintainView extends SupportDataMaintainView {
    private static Logger logger = Logger.getLogger(ServiceProviderMaintainView.class);
  private List<ServiceProvider> ServiceProviderList = new ArrayList<ServiceProvider>();
  private ServiceProvider serviceProvider = new ServiceProvider();//用于创建或更新SP
  private List<Province> provinceWithLBCList = new ArrayList<Province>();

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

    public List<Province> getProvinceWithLBCList() {
        return provinceWithLBCList;
    }

    public void setProvinceWithLBCList(List<Province> provinceWithLBCList) {
        this.provinceWithLBCList = provinceWithLBCList;
    }

    @Override
  public void loadData() {
        provinceWithLBCList = this.supportDataService.findProvinceWithLBCList();
  }

    public void loadCityListFromProvinceCode() {
        logger.info("ServiceProviderMaintainView.loadCityListFromProvinceCode");
        loadCityListFromProvinceCode(true);
    }

    public void loadDistrictListFromCityCode() {
        logger.info("ServiceProviderMaintainView.loadDistrictListFromCityCode");
        loadDistrictListFromCityCode(true);
    }
    
  public void saveServiceProvider(){
    
  }

}
