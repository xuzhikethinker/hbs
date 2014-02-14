package com.hbs.dto;

import com.hbs.domain.support.LifeBusinessCircle;

import java.io.Serializable;

/**
 * Created by Administrator on 14-1-30.
 */
public class LifeBusinessCircleDTO extends DistrictDTO implements Serializable {
    private String lbcCode;
    private String lbcName;

    public String getLbcCode() {
        return lbcCode;
    }

    public void setLbcCode(String lbcCode) {
        this.lbcCode = lbcCode;
    }

    public String getLbcName() {
        return lbcName;
    }

    public void setLbcName(String lbcName) {
        this.lbcName = lbcName;
    }

    public LifeBusinessCircle convertToLifeBusinessCircle(){
        LifeBusinessCircle circle = new LifeBusinessCircle();
        circle.setDescription(this.description);
        circle.setCircleCode(this.lbcCode);
        circle.setCircleName(this.lbcName);
        circle.setDistrictCode(this.districtCode);
        return circle;
    }
}
