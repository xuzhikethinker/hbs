package com.hbs.domain.support;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "HBS_PROVINCE")
public class Province extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "PROVIDER_NAME", nullable = false)
    private String provinceName;

    @Basic
    @Column(name = "PROVIDER_CODE", nullable = false)
    private String provinceCode;

    public Province() {
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

}
