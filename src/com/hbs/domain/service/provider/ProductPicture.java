package com.hbs.domain.service.provider;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * 服务提供商为服务上传的图片
 *
 * @author develop
 *
 */
@Entity
@Table(name = "HBS_SP_PRODUCT_PIC")
public class ProductPicture extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "PIC_STORED_NAME", nullable = false)
    private String storedFileName;// 系统更改的文件名字，不包含中文名

    @Basic
    @Column(name = "PIC_ORIGINAL_NAME", nullable = false)
    private String originalFileName;// 原始名字，用于显示，只存于数据库，不存在文件夹

    @Basic
    @Column(name = "PICTURE_DESC", nullable = true)
    private String picDescription;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    // 可选属性optional=false,表示company不能为空
    @JoinColumn(name = "SERVICE_PROVIDER_ID")
    private ServiceProvider serviceProvider;

    public ProductPicture() {
    }

    public String getStoredFileName() {
        return storedFileName;
    }

    public void setStoredFileName(String storedFileName) {
        this.storedFileName = storedFileName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getPicDescription() {
        return picDescription;
    }

    public void setPicDescription(String picDescription) {
        this.picDescription = picDescription;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

}
