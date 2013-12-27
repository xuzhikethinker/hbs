package com.hbs.domain.common;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HBS_TAG")
public class Tag extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "TAG_NAME", nullable = false)
    private String name;

    @Basic
    @Column(name = "TAG_DESC", nullable = true)
    private String description;

    @Basic
    @Column(name = "TAG_SOURCE", nullable = false)
    private String source;

    @Basic
    @Column(name = "TAG_OWNER", nullable = false)
    private String owner;// 区代码或者圈子代码

    public Tag(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
