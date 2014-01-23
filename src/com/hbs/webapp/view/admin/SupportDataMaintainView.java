package com.hbs.webapp.view.admin;

import com.hbs.domain.support.Province;
import com.hbs.service.SupportDataService;
import com.hbs.webapp.view.BaseView;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "supportDataMaintainView")
@ViewScoped
public class SupportDataMaintainView extends BaseView {
    @ManagedProperty(value = "#{supportDataService}")
    private SupportDataService supportDataService;
    private List<Province> provinceList = new ArrayList<Province>();

    public SupportDataService getSupportDataService() {
        return supportDataService;
    }

    public void setSupportDataService(SupportDataService supportDataService) {
        this.supportDataService = supportDataService;
    }

    public SupportDataMaintainView(){

    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    @Override
    public void loadData() {
        provinceList = this.supportDataService.findAllProvince();
    }
}
