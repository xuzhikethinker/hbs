package com.hbs.domain.common;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
public abstract class PersistenceDomain extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	@Embedded
	private ChangeLog changeLog = new ChangeLog();

	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

}
