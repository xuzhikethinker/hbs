package com.hbs.domain.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo {
	@Column(name = "CONTRACT_NAME")
	private String contractPerson;

	@Column(name = "CONTRACT_PHONE")
	private String contractPhone;

	@Column(name = "EMAIL_ADDR")
	private String emailAddr;

	@Column(name = "QQ_NUMBER")
	private String qqNum;

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

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

}
