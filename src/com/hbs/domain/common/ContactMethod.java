package com.hbs.domain.common;

import javax.persistence.Entity;

/**
 * Created by Administrator on 14-2-17.
 * 联系方式，主要定义QQ/MSN/Email/微信/微博/飞信/阿里旺旺等等各种方式
 */
@Entity
public class ContactMethod extends PersistenceDomain {
    private String type;
    private String value;
    private String description;

    private ContactInfo contactInfo;
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

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
