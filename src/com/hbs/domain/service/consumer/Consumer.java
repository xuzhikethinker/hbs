package com.hbs.domain.service.consumer;

import com.hbs.domain.service.AbstractUserInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 注册用户基本信息，包括用户的城市，小区等详细地址，联系电话，便于订单确认和递送
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_CONSUMER_INFO")
public class Consumer extends AbstractUserInfo {

    private static final long serialVersionUID = 1L;

    @Basic
    @Column(name = "USER_NAME", nullable = true)
    private String userName;// 用户真实名字

    @Basic
    @Column(name = "SEX", nullable = true)
    private int sex;// 性别,1=MAN, 0=FEMAIL

    @Basic
    @Column(name = "COMMUNITY_CODE", nullable = true)
    private String communityCode;// 用户所在小区，可为空；如果用户不是住在小区，则需要用户选择最近的小区或生活商业圈，当然，系统最好提供一些大家比较熟知的地点或建筑或政府办公大楼或楼盘等来供非小区用户选择


    @OneToMany(mappedBy = "orderOwner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "USER_ID")
    private List<ServiceOrder> serviceOrderList = new ArrayList<ServiceOrder>();

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FavoriteServiceGroup> myFavoriteGroups = new ArrayList<FavoriteServiceGroup>();

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConsumerContactMethod> contactMethodList = new ArrayList<ConsumerContactMethod>();

    public Consumer() {
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

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

    public List<FavoriteServiceGroup> getMyFavoriteGroups() {
      return myFavoriteGroups;
    }

    public void setMyFavoriteGroups(List<FavoriteServiceGroup> myFavoriteGroups) {
      this.myFavoriteGroups = myFavoriteGroups;
    }

    public List<ConsumerContactMethod> getContactMethodList() {
        return contactMethodList;
    }

    public void setContactMethodList(List<ConsumerContactMethod> contactMethodList) {
        this.contactMethodList = contactMethodList;
    }
}
