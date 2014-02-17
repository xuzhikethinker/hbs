package com.hbs.webapp.view;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.service.ServiceItem;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "serviceMaintainView")
@ViewScoped
public class ServiceMaintainView extends BaseView {
  private static Logger logger = Logger.getLogger(ServiceMaintainView.class);

  private List<ServiceCategory> serviceCategoryList = new ArrayList<ServiceCategory>();
  private List<ServiceItem> serviceItemList = new ArrayList<ServiceItem>();
  private String selectedServiceCategoryCode = "";

  public List<ServiceCategory> getServiceCategoryList() {
    return serviceCategoryList;
  }

  public void setServiceCategoryList(List<ServiceCategory> serviceCategoryList) {
    this.serviceCategoryList = serviceCategoryList;
  }

  public List<ServiceItem> getServiceItemList() {
    return serviceItemList;
  }

  public void setServiceItemList(List<ServiceItem> serviceItemList) {
    this.serviceItemList = serviceItemList;
  }

  public String getSelectedServiceCategoryCode() {
    return selectedServiceCategoryCode;
  }

  public void setSelectedServiceCategoryCode(String selectedServiceCategoryCode) {
    this.selectedServiceCategoryCode = selectedServiceCategoryCode;
  }

  @Override
  public void loadData() {
    serviceCategoryList = this.supportDataService.findAllService();
  }

  public void loadServiceItemListFromCategoryCode() {
    logger.info("ServiceMaintainView.loadServiceItemListFromCategoryCode");
    serviceItemList = new ArrayList<ServiceItem>();
    for (ServiceCategory category : this.serviceCategoryList) {
      if (category.getId().toString().equalsIgnoreCase(this.getSelectedServiceCategoryCode())) {
        serviceItemList = category.getServiceItemList();
        break;
      }
    }
  }

  public void editServiceCategory(RowEditEvent event) {
    logger.info("ServiceMaintainView.editServiceCategory");
    ServiceCategory category = (ServiceCategory) event.getObject();
    FacesMessage msg = new FacesMessage("更新产品类别", category.getCategoryName() + " 产品类别成功更新");
    supportDataService.saveServiceCategory(category);
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

  public void editServiceItem(RowEditEvent event) {
    logger.info("ServiceMaintainView.editServiceItem");
    ServiceItem serviceItem = (ServiceItem) event.getObject();
    ServiceCategory category = serviceItem.getServiceCategory();
    FacesMessage msg = new FacesMessage("更新产品单元", category.getCategoryName() + " 产品单元成功更新");
    supportDataService.saveServiceCategory(category);
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

}
