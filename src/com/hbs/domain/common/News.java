package com.hbs.domain.common;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HBS_NEWS")
public class News extends PersistenceDomain {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "NEWS_TITLE", nullable = false)
    private String title;

    @Basic
    @Column(name = "NEWS_CONTENTS", nullable = false)
    private String contents;

    @Basic
    @Column(name = "NEWS_FROM_DATE", nullable = true)
    private Date validDateFrom;

    @Basic
    @Column(name = "NEWS_TO_DATE", nullable = true)
    private Date validDateTo;

    @Basic
    @Column(name = "NEWS_AUTHOR", nullable = false)
    private String author;

    @Basic
    @Column(name = "NEWS_SOURCE", nullable = false)
    private String source;

    @Basic
    @Column(name = "NEWS_TYPE", nullable = false)
    private String newsType;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getValidDateFrom() {
        return validDateFrom;
    }

    public void setValidDateFrom(Date validDateFrom) {
        this.validDateFrom = validDateFrom;
    }

    public Date getValidDateTo() {
        return validDateTo;
    }

    public void setValidDateTo(Date validDateTo) {
        this.validDateTo = validDateTo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
