package com.hbs.domain.support;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<City> cities = new HashSet<City>();

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
