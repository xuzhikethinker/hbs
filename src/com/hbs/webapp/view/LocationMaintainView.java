package com.hbs.webapp.view;

import com.hbs.criteria.LBCSearchCriteria;
import com.hbs.domain.support.City;
import com.hbs.domain.support.District;
import com.hbs.domain.support.LifeBusinessCircle;
import com.hbs.domain.support.Province;
import com.hbs.dto.CityDTO;
import com.hbs.dto.DistrictDTO;
import com.hbs.dto.LifeBusinessCircleDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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

    public void loadCityListFromProvinceCode() {
        logger.info("SupportDataMaintainView.loadCityListFromProvinceCode");
        loadCityListFromProvinceCode(false);
    }

    protected void loadCityListFromProvinceCode(boolean containLBC) {
        districtList = new ArrayList<District>();
        lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
        cityList = new ArrayList<City>();
        lbcSearchCriteria.setCityCode(null);
        lbcSearchCriteria.setDistrictCode(null);
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        if (StringUtils.isNotEmpty(provinceCode)) {
            if (containLBC) {
                cityList.addAll(this.supportDataService.getProvinceMap().get(provinceCode).getCityWithLBCList());
            } else {
                cityList.addAll(this.supportDataService.getProvinceMap().get(provinceCode).getCities());
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
        loadDistrictListFromCityCode(false);
    }

    protected void loadDistrictListFromCityCode(boolean containLBC) {
        districtList = new ArrayList<District>();
        lifeBusinessCircleList = new ArrayList<LifeBusinessCircle>();
        String provinceCode = this.lbcSearchCriteria.getProvinceCode();
        String cityCode = this.lbcSearchCriteria.getCityCode();
        lbcSearchCriteria.setDistrictCode(null);
        if (StringUtils.isNotEmpty(provinceCode)) {
            Province province = this.supportDataService.getProvinceMap().get(provinceCode);
            if (containLBC) {
                this.districtList.addAll(province.getCityFromCode(cityCode).getDistrictWithLBCList());
            } else {
                this.districtList.addAll(province.getCityFromCode(cityCode).getDistrictList());
            }
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
        LifeBusinessCircle lbc = (LifeBusinessCircle) event.getObject();
        District district = lbc.getDistrict();
        City city = district.getCity();
        Province province = city.getProvince();
        supportDataService.saveProvice(province);
    }

}
