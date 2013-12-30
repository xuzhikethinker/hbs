package com.hbs.domain.community;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hbs.domain.common.Address;
import com.hbs.domain.common.PersistenceDomain;
import com.hbs.domain.support.LifeBusinessCircle;

/**
 * 住宅小区基本信息，它有自己所属的生活/商业圈，同时它也可以关联附近的生活/商业圈。
 * 
 * @author develop
 * 
 */
//@Entity
//@Table(name = "HBS_COMMUNITY_INFO")
public class CommunityInfo extends PersistenceDomain {

	private static final long serialVersionUID = 1L;
	@Basic
	@Column(name = "COMMUNITY_NAME", nullable = false)
	private String communityName;

	@Basic
	@Column(name = "COMMUNITY_CODE", nullable = false)
	private String communityCode;

	@Embedded
	private Address address;

	@Basic
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@Basic
	@Column(name = "KEYWORDS", nullable = true)
	private String keywords;

	@OneToOne
	@JoinColumn(name="LBC_CODE")
	private LifeBusinessCircle ownerLifeBusinessCircle;// 所属生活/商业圈

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMUNITY_ID")
	private List<CommunityLifeBusinessCircleAsso> associatedLifeBusinessCircles = new ArrayList<CommunityLifeBusinessCircleAsso>();

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public LifeBusinessCircle getOwnerLifeBusinessCircle() {
		return ownerLifeBusinessCircle;
	}

	public void setOwnerLifeBusinessCircle(LifeBusinessCircle ownerLifeBusinessCircle) {
		this.ownerLifeBusinessCircle = ownerLifeBusinessCircle;
	}

	public List<CommunityLifeBusinessCircleAsso> getAssociatedLifeBusinessCircles() {
		return associatedLifeBusinessCircles;
	}

	public void setAssociatedLifeBusinessCircles(
			List<CommunityLifeBusinessCircleAsso> associatedLifeBusinessCircles) {
		this.associatedLifeBusinessCircles = associatedLifeBusinessCircles;
	}

}
