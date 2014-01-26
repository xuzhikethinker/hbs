package com.hbs.webapp.view.criteria;

import java.io.Serializable;

/**
 * Created by Administrator on 14-1-25.
 */
public class LBCSearchCriteria implements Serializable {
    private String provinceCode;
    private String cityCode;
    private String districtCode;
    private String lbcCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getLbcCode() {
        return lbcCode;
    }

    public void setLbcCode(String lbcCode) {
        this.lbcCode = lbcCode;
    }
}
