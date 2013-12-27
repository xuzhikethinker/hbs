/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hbs.service;

import com.hbs.domain.service.ServiceCategory;
import java.util.List;

/**
 *
 * @author develop
 */
public interface ServiceInfoService {
    public List<ServiceCategory> findAllServiceCategory();
}
