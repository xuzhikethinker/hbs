package com.hbs.domain.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "CITY_CODE")
	private String cityCode;// 城市代码，用邮编或电话区号

	@Column(name = "DISTRICT_CODE")
	private String districtCode;// 城市某个区代码，系统自定义

	@Column(name = "LBC_CODE")
	private String lbcCode;// 城市某个生活商业圈代码，系统自定义

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "ADDRESS_LINE")
	private String addressLine;

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

}
