package com.hbs.domain.common;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 14-2-17.
 * 联系方式，主要定义QQ/MSN/Email/微信/微博/飞信/阿里旺旺等等各种方式
 */
@Entity
@DiscriminatorColumn(name="DISCRIMINATOR",discriminatorType= DiscriminatorType.STRING)
@Table(name = "HBS_CONTACT_METHOD")
public abstract class ContactMethod extends AbstractPersistable<Long> {
    private String type;
    private String value;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
