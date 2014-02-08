package com.hbs.webapp.dto;

import com.hbs.domain.support.District;

import java.io.Serializable;

/**
 * Created by Administrator on 14-1-26.
 */
public class DistrictDTO extends CityDTO implements Serializable {
    protected String districtName;
    protected String districtCode;
    protected String description;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public District convertToDistrict() {
        District district = new District();
        district.setCityCode(cityCode);
        district.setDistrictCode(districtCode);
        district.setDistrictName(districtName);
        district.setDescription(description);
        return district;
    }
}
