/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hbs.webapp.view;

import com.hbs.domain.service.ServiceCategory;
import com.hbs.repository.ServiceInfoRepository;
import com.hbs.service.ServiceInfoService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author develop
 */
@ManagedBean(name="homeView")
@RequestScoped
public class HomeView extends BaseView implements Serializable  {
    @ManagedProperty(value="#{serviceInfoService}")
    ServiceInfoService serviceInfoService;

    public ServiceInfoService getServiceInfoService() {
        return serviceInfoService;
    }

    public void setServiceInfoService(ServiceInfoService serviceInfoService) {
        this.serviceInfoService = serviceInfoService;
    }

    
    
    private List<ServiceCategory> allServiceCategoryList;

    private String userName = "";
    private String content = "";
    private int seq;
    
    //@ManagedProperty("#{param.type}") //this works well only for RequestScoped
    private String type;
    public HomeView(){
        //this.userName = "xuzhike";
        Map initParams = this.getCurrentExternalContext().getInitParameterMap();
        System.out.println("HomeView init="+this.getCurrentExternalContext().getInitParameterMap());
    }
    
    public String loadData(){
        System.out.println("HomeView loadData type="+type);
        allServiceCategoryList = serviceInfoService.findAllServiceCategory();
        System.out.println("allServiceCategoryList = "+allServiceCategoryList.size());
        return null;
    }
  
    public String getOutcome(){
        System.out.println("HomeView getOutcome seq="+seq);
        return "sp_content";
    }
       @PostConstruct
   public void reset()
   {
       FacesContext fc = FacesContext.getCurrentInstance();
       System.out.println("HomeView reset type="+type);
       this.content = "这是最新测试结果，type="+type;
   }
   
//   public void retrieveType(ComponentSystemEvent event){
// 
//	FacesContext fc = FacesContext.getCurrentInstance();
//        String v = (String)fc.getExternalContext().getRequestMap().get("type");
//        System.out.println("retrieveType = "+v);
//  }	

    public String getUserName() {
        System.out.println("getUserName = "+userName);
        return userName;
    }
    
    public String getServiceProviderCode(){
        System.out.println("getUserName, seq = "+seq);
        return "sp_content";
    }

    public void setUserName(String userName) {
        System.out.println("setUserName = "+userName);
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        System.out.println("setContent = "+content);
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        System.out.println("setType = "+type);
        this.type = type;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public List<ServiceCategory> getAllServiceCategoryList() {
        return allServiceCategoryList;
    }

    public void setAllServiceCategoryList(List<ServiceCategory> allServiceCategoryList) {
        this.allServiceCategoryList = allServiceCategoryList;
    }
}
