/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hbs.repository;

import com.hbs.domain.service.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author develop
 */
public interface ServiceInfoRepository extends JpaRepository<ServiceCategory, Long> {
    @Query("select u from ServiceCategory u order by u.displaySeq asc ")
    public List<ServiceCategory> findOrderByDisplaySeq();
}
