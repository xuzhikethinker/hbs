/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hbs.webapp.view;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * 
 * @author develop
 */
public abstract class BaseView {

  protected FacesContext getCurrentFacesContext() {
    return FacesContext.getCurrentInstance();
  }

  /**
   * 可以通过ExternalContext获取requestMap等，getRequestParameterMap()
   * 
   * @return
   */
  protected ExternalContext getCurrentExternalContext() {
    return this.getCurrentFacesContext().getExternalContext();
  }

  protected ServletContext getServletContext() {
    return (ServletContext) this.getCurrentExternalContext().getContext();
  }

  protected String getInitParamValueByKey(String name) {
    return this.getCurrentExternalContext().getInitParameter(name);
  }
}
