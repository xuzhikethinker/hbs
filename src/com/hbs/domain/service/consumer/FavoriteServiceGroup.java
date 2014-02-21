package com.hbs.domain.service.consumer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "HBS_CONSUMER_FAVORITE_SERVICE_GROUP")
public class FavoriteServiceGroup extends AbstractPersistable<Long> {

  private static final long serialVersionUID = 1L;
  @Basic
  @Column(name = "GROUP_NAME", nullable = false)
  private String groupName;
  
  @Basic
  @Column(name = "DESCRIPTION", nullable = true)
  private String description;
  
  @Basic
  @Column(name = "DISP_SEQ", nullable = false)
  private int displayOrder;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
  @JoinColumn(name = "USER_ID")
  private Consumer consumer;

  @OneToMany(mappedBy = "favoriteServiceGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<FavoriteServiceItem> favoriteServiceItemList = new ArrayList<FavoriteServiceItem>();

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(int displayOrder) {
    this.displayOrder = displayOrder;
  }

  public Consumer getConsumer() {
    return consumer;
  }

  public void setConsumer(Consumer consumer) {
    this.consumer = consumer;
  }

  public List<FavoriteServiceItem> getFavoriteServiceItemList() {
    return favoriteServiceItemList;
  }

  public void setFavoriteServiceItemList(List<FavoriteServiceItem> favoriteServiceItemList) {
    this.favoriteServiceItemList = favoriteServiceItemList;
  }

}
