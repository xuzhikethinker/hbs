package com.hbs.domain.support;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "HBS_LBC_ASSOCIATION")
public class LifeBusinessCircleAssociation extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "MASTER_LBC_CODE", nullable = false)
    private String masterLBCCode;

    @Basic
    @Column(name = "NEIGHBOUR_LBC_CODE", nullable = false)
    private String neighbourLBCCode;

    public LifeBusinessCircleAssociation() {
    }

    public String getMasterLBCCode() {
        return masterLBCCode;
    }

    public void setMasterLBCCode(String masterLBCCode) {
        this.masterLBCCode = masterLBCCode;
    }

    public String getNeighbourLBCCode() {
        return neighbourLBCCode;
    }

    public void setNeighbourLBCCode(String neighbourLBCCode) {
        this.neighbourLBCCode = neighbourLBCCode;
    }

}
