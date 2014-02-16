package com.hbs.domain.support;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "HBS_PROVINCE")
public class Province extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "PROVIDER_NAME", nullable = false)
    private String provinceName;

    @Basic
    @Column(name = "PROVIDER_CODE", nullable = false)
    private String provinceCode;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<City> cities = new HashSet<City>();

    public Province() {
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Set<City> getCities() {
        return cities;
    }

    public boolean isContainActiveCity() {
        return CollectionUtils.isNotEmpty(getCityWithLBCList());
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city) {
        city.setProvince(this);
        cities.add(city);
    }

    public City getCityFromCode(String cityCode) {
        for (City ct : cities) {
            if (StringUtils.equalsIgnoreCase(ct.getCityCode(), cityCode)) {
                return ct;
            }
        }
        return new City();
    }

    public List<City> getCityWithLBCList(){
        List<City> activeCityList = new ArrayList<City>();
        for(City city:this.getCities()){
            if(CollectionUtils.isNotEmpty(city.getDistrictWithLBCList())){
                activeCityList.add(city);
            }
        }
        return activeCityList;
    }
}
