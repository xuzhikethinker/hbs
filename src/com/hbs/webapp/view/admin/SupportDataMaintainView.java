package com.hbs.webapp.view.admin;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.domain.support.City;
import com.hbs.domain.support.Province;
import com.hbs.webapp.dto.CityDTO;
import com.hbs.webapp.dto.DistrictDTO;
import com.hbs.webapp.view.BaseView;
import com.hbs.webapp.view.criteria.LBCSearchCriteria;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    private List<ServiceCategory> serviceCategoryList = new ArrayList<ServiceCategory>();
    private CityDTO cityDTO = new CityDTO();
    private DistrictDTO districtDTO = new DistrictDTO();

    public SupportDataMaintainView(){

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

    @Override
    public void loadData() {
        logger.info("SupportDataMaintainView.loadData");
        provinceList = this.supportDataService.findAllProvince();
        serviceCategoryList = this.supportDataService.findAllService();
    }

    public void loadCityListFromProvinceCode(){
        logger.info("SupportDataMaintainView.loadCityListFromProvinceCode");
        cityList = new ArrayList<City>();
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        if(StringUtils.isNotEmpty(provinceCode)){
            cityList.addAll(this.supportDataService.getProvinceMap().get(provinceCode).getCities());
        }
    }

    public void addNewCity(ActionEvent actionEvent){
        logger.info("SupportDataMaintainView.addNewCity");
        Province province = this.supportDataService.getProvinceMap().get(cityDTO.getProviceCode());
        province.addCity(cityDTO.convertToCity());
        this.supportDataService.saveProvice(province);
        this.loadData();
        cityDTO = new CityDTO();
        loadCityListFromProvinceCode();
    }

    public void addNewDistrict(ActionEvent actionEvent){
        logger.info("SupportDataMaintainView.addNewDistrict");
        Province province = this.supportDataService.getProvinceMap().get(cityDTO.getProviceCode());
        City city = province.getCityFromCode(cityDTO.getCityCode());
        districtDTO.setCityCode(cityDTO.getCityCode());
        if(city!=null){
            city.addDistrict(districtDTO.convertToDistrict());
        }
        this.supportDataService.saveProvice(province);
        this.loadData();
        cityDTO = new CityDTO();
        districtDTO = new DistrictDTO();
        loadCityListFromProvinceCode();

    }

    public void handleProvinceChange() {
        Province province = this.supportDataService.getProvinceMap().get(cityDTO.getProviceCode());
        cityList = new ArrayList<City>();
        cityList.addAll(province.getCities());
    }


}
