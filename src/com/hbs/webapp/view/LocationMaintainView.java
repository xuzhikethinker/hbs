package com.hbs.webapp.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.hbs.criteria.LBCSearchCriteria;
import com.hbs.domain.support.City;
import com.hbs.domain.support.District;
import com.hbs.domain.support.LifeBusinessCircle;
import com.hbs.domain.support.Province;
import com.hbs.dto.CityDTO;
import com.hbs.dto.DistrictDTO;
import com.hbs.dto.LifeBusinessCircleDTO;

@ManagedBean(name = "locationMaintainView")
@ViewScoped
public class LocationMaintainView extends BaseView {
  private static Logger logger = Logger.getLogger(LocationMaintainView.class);

  protected List<Province> provinceList = new ArrayList<Province>();
  protected List<City> cityList = new ArrayList<City>();
  protected List<District> districtList = new ArrayList<District>();
  protected List<LifeBusinessCircle> lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
  protected LBCSearchCriteria lbcSearchCriteria = new LBCSearchCriteria();
  private CityDTO cityDTO = new CityDTO();
  private DistrictDTO districtDTO = new DistrictDTO();
  private LifeBusinessCircleDTO lbcDTO = new LifeBusinessCircleDTO();
  
  public List<Province> getProvinceList() {
    return provinceList;
  }

  public void setProvinceList(List<Province> provinceList) {
    this.provinceList = provinceList;
  }

  public List<City> getCityList() {
    return cityList;
  }

  public void setCityList(List<City> cityList) {
    this.cityList = cityList;
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

  public LBCSearchCriteria getLbcSearchCriteria() {
    return lbcSearchCriteria;
  }

  public void setLbcSearchCriteria(LBCSearchCriteria lbcSearchCriteria) {
    this.lbcSearchCriteria = lbcSearchCriteria;
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

  public LifeBusinessCircleDTO getLbcDTO() {
    return lbcDTO;
  }

  public void setLbcDTO(LifeBusinessCircleDTO lbcDTO) {
    this.lbcDTO = lbcDTO;
  }

  @Override
  public void loadData() {
    logger.info("LocationMaintainView.loadData");
    provinceList = this.supportDataService.findAllProvince();
  }

}
