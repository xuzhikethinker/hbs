package com.hbs.webapp.view.admin;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.service.ServiceItem;
import com.hbs.domain.support.City;
import com.hbs.domain.support.District;
import com.hbs.domain.support.LifeBusinessCircle;
import com.hbs.domain.support.Province;
import com.hbs.webapp.dto.CityDTO;
import com.hbs.webapp.dto.DistrictDTO;
import com.hbs.webapp.dto.LifeBusinessCircleDTO;
import com.hbs.webapp.view.BaseView;
import com.hbs.webapp.view.criteria.LBCSearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "supportDataMaintainView")
@ViewScoped
public class SupportDataMaintainView extends BaseView {
    private static Logger logger = Logger.getLogger(SupportDataMaintainView.class);

    private LBCSearchCriteria lbcSearchCriteria = new LBCSearchCriteria();
    private List<Province> provinceList = new ArrayList<Province>();
    private List<City> cityList = new ArrayList<City>();
    private List<District> districtList = new ArrayList<District>();
    private List<ServiceCategory> serviceCategoryList = new ArrayList<ServiceCategory>();
    private List<LifeBusinessCircle> lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
    private CityDTO cityDTO = new CityDTO();
    private DistrictDTO districtDTO = new DistrictDTO();
    private LifeBusinessCircleDTO lbcDTO = new LifeBusinessCircleDTO();
    private String selectedServiceCategoryCode = "";
    private List<ServiceItem> serviceItemList = new ArrayList<ServiceItem>();

    public SupportDataMaintainView() {

    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public List<ServiceCategory> getServiceCategoryList() {
        return serviceCategoryList;
    }

    public void setServiceCategoryList(List<ServiceCategory> serviceCategoryList) {
        this.serviceCategoryList = serviceCategoryList;
    }

    public LBCSearchCriteria getLbcSearchCriteria() {
        return lbcSearchCriteria;
    }

    public void setLbcSearchCriteria(LBCSearchCriteria lbcSearchCriteria) {
        this.lbcSearchCriteria = lbcSearchCriteria;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public DistrictDTO getDistrictDTO() {
        return districtDTO;
    }

    public void setDistrictDTO(DistrictDTO districtDTO) {
        this.districtDTO = districtDTO;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<LifeBusinessCircle> getLifeBusinessCircleList() {
        return lifeBusinessCircleList;
    }

    public void setLifeBusinessCircleList(List<LifeBusinessCircle> lifeBusinessCircleList) {
        this.lifeBusinessCircleList = lifeBusinessCircleList;
    }

    public LifeBusinessCircleDTO getLbcDTO() {
        return lbcDTO;
    }

    public void setLbcDTO(LifeBusinessCircleDTO lbcDTO) {
        this.lbcDTO = lbcDTO;
    }

    public String getSelectedServiceCategoryCode() {
        return selectedServiceCategoryCode;
    }

    public void setSelectedServiceCategoryCode(String selectedServiceCategoryCode) {
        this.selectedServiceCategoryCode = selectedServiceCategoryCode;
    }

    public List<ServiceItem> getServiceItemList() {
        return serviceItemList;
    }

    public void setServiceItemList(List<ServiceItem> serviceItemList) {
        this.serviceItemList = serviceItemList;
    }

    @Override
    public void loadData() {
        logger.info("SupportDataMaintainView.loadData");
        provinceList = this.supportDataService.findAllProvince();
        serviceCategoryList = this.supportDataService.findAllService();
    }

    public void loadCityListFromProvinceCode() {
        logger.info("SupportDataMaintainView.loadCityListFromProvinceCode");
        districtList = new ArrayList<District>();
        lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
        cityList = new ArrayList<City>();
        lbcSearchCriteria.setCityCode(null);
        lbcSearchCriteria.setDistrictCode(null);
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        if (StringUtils.isNotEmpty(provinceCode)) {
            cityList.addAll(this.supportDataService.getProvinceMap().get(provinceCode).getCities());
        }
    }

    public void loadServiceItemListFromCategoryCode(){
        logger.info("SupportDataMaintainView.loadServiceItemListFromCategoryCode");
        serviceItemList = new ArrayList<ServiceItem>();
        for(ServiceCategory category:this.serviceCategoryList){
            if(category.getId().toString().equalsIgnoreCase(this.getSelectedServiceCategoryCode())){
                serviceItemList = category.getServiceItemList();
                break;
            }
        }
    }

    public void loadLBCFromDistrictCode() {
        logger.info("SupportDataMaintainView.loadLBCFromDistrictCode");
        lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        String cityCode = this.lbcSearchCriteria.getCityCode();
        if (StringUtils.isNotEmpty(provinceCode)) {
            Province province = this.supportDataService.getProvinceMap().get(provinceCode);
            City city = province.getCityFromCode(cityCode);
            if (city != null) {
                District district = city.getDistrictFromCode(this.lbcSearchCriteria.getDistrictCode());
                if (district != null) {
                    this.lifeBusinessCircleList.addAll(district.getLifeBusinessCicles());
                }
            }
        }
    }

    public void loadDistrictListFromCityCode() {
        logger.info("SupportDataMaintainView.loadDistrictListFromCityCode");
        districtList = new ArrayList<District>();
        lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        String cityCode = this.lbcSearchCriteria.getCityCode();
        lbcSearchCriteria.setDistrictCode(null);
        if (StringUtils.isNotEmpty(provinceCode)) {
            Province province = this.supportDataService.getProvinceMap().get(provinceCode);
            this.districtList.addAll(province.getCityFromCode(cityCode).getDistrictList());
        }
    }

    public void addNewCity(ActionEvent actionEvent) {
        logger.info("SupportDataMaintainView.addNewCity");
        Province province = this.supportDataService.getProvinceMap().get(cityDTO.getProviceCode());
        province.addCity(cityDTO.convertToCity());
        this.supportDataService.saveProvice(province);
        this.loadData();
        cityDTO = new CityDTO();
        loadCityListFromProvinceCode();
    }

    public void addNewDistrict(ActionEvent actionEvent) {
        logger.info("SupportDataMaintainView.addNewDistrict");
        Province province = this.supportDataService.getProvinceMap().get(lbcSearchCriteria.getProvinceCode());
        City city = province.getCityFromCode(lbcSearchCriteria.getCityCode());
        districtDTO.setCityCode(lbcSearchCriteria.getCityCode());
        if (city != null) {
            city.addDistrict(districtDTO.convertToDistrict());
        }
        this.supportDataService.saveProvice(province);
        this.loadData();
        cityDTO = new CityDTO();
        districtDTO = new DistrictDTO();
        loadCityListFromProvinceCode();

    }

    public void addNewLifeBusinessCircle() {
        logger.info("SupportDataMaintainView.addNewLifeBusinessCircle");
        Province province = this.supportDataService.getProvinceMap().get(lbcSearchCriteria.getProvinceCode());
        City city = province.getCityFromCode(lbcSearchCriteria.getCityCode());

        if (city != null) {
            District district = city.getDistrictFromCode(lbcSearchCriteria.getDistrictCode());
            if (district != null) {
                this.lbcDTO.setDistrictCode(district.getDistrictCode());
                district.addLifeBusinessCircle(lbcDTO.convertToLifeBusinessCircle());
            }
        }
        this.supportDataService.saveProvice(province);
        this.loadData();
        cityDTO = new CityDTO();
        districtDTO = new DistrictDTO();
        lbcDTO = new LifeBusinessCircleDTO();
        loadCityListFromProvinceCode();
    }

    public void handleProvinceChange() {
        Province province = this.supportDataService.getProvinceMap().get(cityDTO.getProviceCode());
        cityList = new ArrayList<City>();
        cityList.addAll(province.getCities());
    }
    
    public void editProvince(RowEditEvent event) {
      logger.info("SupportDataMaintainView.editProvince");
      Province province = (Province) event.getObject();
      supportDataService.saveProvice(province);
  }
    
    public void editCity(RowEditEvent event) {
      logger.info("SupportDataMaintainView.editCity");
      City city = (City) event.getObject();
      Province province = city.getProvince();
      supportDataService.saveProvice(province);
  }
    
    public void editDistrict(RowEditEvent event) {
      logger.info("SupportDataMaintainView.editDistrict");
      District district = (District) event.getObject();
      City city = district.getCity();
      Province province = city.getProvince();
      supportDataService.saveProvice(province);
  }    
    
    
    public void editLifeBusinessCircle(RowEditEvent event) {
      logger.info("SupportDataMaintainView.editLifeBusinessCircle");
      LifeBusinessCircle lbc = (LifeBusinessCircle)event.getObject();
      District district = lbc.getDistrict();
      City city = district.getCity();
      Province province = city.getProvince();
      supportDataService.saveProvice(province);
  } 
    

    public void editServiceCategory(RowEditEvent event) {
        logger.info("SupportDataMaintainView.editServiceCategory");
        ServiceCategory category = (ServiceCategory) event.getObject();
        FacesMessage msg = new FacesMessage("更新产品类别", category.getCategoryName() + " 产品类别成功更新");
        supportDataService.saveServiceCategory(category);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void editServiceItem(RowEditEvent event) {
      logger.info("SupportDataMaintainView.editServiceItem");
      ServiceItem serviceItem = (ServiceItem)event.getObject();
      ServiceCategory category = serviceItem.getServiceCategory();
      FacesMessage msg = new FacesMessage("更新产品单元", category.getCategoryName() + " 产品单元成功更新");
      supportDataService.saveServiceCategory(category);
      FacesContext.getCurrentInstance().addMessage(null, msg);
  }
}
