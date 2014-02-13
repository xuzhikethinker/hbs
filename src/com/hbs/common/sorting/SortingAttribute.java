package com.hbs.common.sorting;

public class SortingAttribute {
  private String attributeName;
  private boolean isAscending = true;
  private boolean isNullBiggest = false;

  public SortingAttribute() {
    super();
  }

  public SortingAttribute(String attributeName) {
    this.attributeName = attributeName;
  }

  public SortingAttribute(String attributeName, boolean isAscending) {
    this.attributeName = attributeName;
    this.isAscending = isAscending;
  }

  public SortingAttribute(String attributeName, boolean isAscending,
      boolean isNullBiggest) {
    this.attributeName = attributeName;
    this.isAscending = isAscending;
    this.isNullBiggest = isNullBiggest;
  }

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public boolean isAscending() {
    return isAscending;
  }

  public void setAscending(boolean isAscending) {
    this.isAscending = isAscending;
  }

  public boolean isNullBiggest() {
    return isNullBiggest;
  }

  public void setNullBiggest(boolean isNullBiggest) {
    this.isNullBiggest = isNullBiggest;
  }

}

