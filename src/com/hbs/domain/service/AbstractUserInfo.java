package com.hbs.domain.service;

import com.hbs.domain.common.Address;
import com.hbs.domain.common.PersistenceDomain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by Administrator on 14-2-18.
 */
@MappedSuperclass
public abstract class AbstractUserInfo extends PersistenceDomain {
    @Basic
    @Column(name = "LOGIN_ACCOUNT", nullable = false)
    private String loginAccount;// 登录账号

    @Basic
    @Column(name = "LOGIN_PASSWORD", nullable = false)
    private String loginPassword;// 登录密码

    @Embedded
    private Address address;// 联系地址

    @Column(name = "CONTRACT_NAME")
    private String contractPerson;

    @Column(name = "CONTRACT_PHONE")
    private String contractPhone;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(String contractPerson) {
        this.contractPerson = contractPerson;
    }

    public String getContractPhone() {
        return contractPhone;
    }

    public void setContractPhone(String contractPhone) {
        this.contractPhone = contractPhone;
    }
}
