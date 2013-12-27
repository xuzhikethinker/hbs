package com.hbs.domain.community;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hbs.domain.common.PersistenceDomain;

//@Entity
//@Table(name = "HBS_COMMUNITY_LBC_ASSO")
public class CommunityLifeBusinessCircleAsso extends PersistenceDomain {

	private static final long serialVersionUID = 1L;
	@Basic
	@Column(name = "LB_CIRCLE_CODE", nullable = false)
	private String circleCode;

	@Basic
	@Column(name = "SEARCH_ORDER", nullable = false)
	private int searchOrder;// 用于排序，即前面的圈子的结果先显示，community管理员需要指定检索圈的顺序。0是其所属商务圈

	@Basic
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public int getSearchOrder() {
		return searchOrder;
	}

	public void setSearchOrder(int searchOrder) {
		this.searchOrder = searchOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
