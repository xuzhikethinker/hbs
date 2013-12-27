package com.hbs.domain.service.consumer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hbs.domain.common.Address;
import com.hbs.domain.common.ContactInfo;
import com.hbs.domain.common.PersistenceDomain;

/**
 * 注册用户基本信息，包括用户的城市，小区等详细地址，联系电话，便于订单确认和递送
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_USER_INFO")
public class UserInfo extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "LOGIN_ACCOUNT", nullable = false)
    private String loginAccount;// 登录账号

    @Basic
    @Column(name = "LOGIN_PASSWORD", nullable = false)
    private String loginPassword;// 登录密码

    @Basic
    @Column(name = "USER_NAME", nullable = true)
    private String userName;// 用户真实名字

    @Basic
    @Column(name = "SEX", nullable = true)
    private int sex;// 性别,1=MAN, 0=FEMAIL

    @Basic
    @Column(name = "COMMUNITY_CODE", nullable = true)
    private String communityCode;// 用户所在小区，可为空；如果用户不是住在小区，则需要用户选择最近的小区或生活商业圈，当然，系统最好提供一些大家比较熟知的地点或建筑或政府办公大楼或楼盘等来供非小区用户选择

    @Embedded
    private Address address;// 联系地址

    @Embedded
    private ContactInfo contactInfo;// 联系人信息

    @OneToMany(mappedBy = "orderOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "USER_ID")
    private List<ServiceOrder> serviceOrderList = new ArrayList<ServiceOrder>();

    @OneToMany(mappedBy = "favoriteOwner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ServiceFavorite> myFavoriteServices = new ArrayList<ServiceFavorite>();

    public UserInfo() {
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

    public List<ServiceFavorite> getMyFavoriteServices() {
        return myFavoriteServices;
    }

    public void setMyFavoriteServices(List<ServiceFavorite> myFavoriteServices) {
        this.myFavoriteServices = myFavoriteServices;
    }

}
