package com.hbs.common.sorting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class SortingComparator implements Comparator {
  private List sortingAttributeList;
  private boolean isNullBiggest = false;
  private boolean isCaseInsensitiveOrder = false;
  private Comparator comparator = null;

  public SortingComparator(List sortingAttributeList) {
    this.sortingAttributeList = sortingAttributeList;
  }

  public SortingComparator(List sortingAttributeList, boolean isNullBiggest) {
    this.sortingAttributeList = sortingAttributeList;
    this.isNullBiggest = isNullBiggest;
  }

  public SortingComparator(List sortingAttributeList, boolean isNullBiggest, boolean isCaseInsensitiveOrder) {
    this(sortingAttributeList, isNullBiggest);
    this.isCaseInsensitiveOrder = isCaseInsensitiveOrder;
    if (this.isCaseInsensitiveOrder) {
      comparator = String.CASE_INSENSITIVE_ORDER;
    }
  }

  public int compare(Object obj1, Object obj2) {
    for (Iterator iter = sortingAttributeList.iterator(); iter.hasNext();) {
      SortingAttribute sortingAttribute = (SortingAttribute) iter.next();
      Object attributeValue1 = ReflectionUtil.getAttributeValue(sortingAttribute.getAttributeName(), obj1);
      Object attributeValue2 = ReflectionUtil.getAttributeValue(sortingAttribute.getAttributeName(), obj2);
      boolean isAttributeNullBiggest = sortingAttribute.isNullBiggest();

      int result = 0;
      if (null == attributeValue1 && null == attributeValue2) {
        result = 0;
      } else if (null == attributeValue1) {
        if (isAttributeNullBiggest || isNullBiggest) {
          result = 1;
        } else {
          result = -1;
        }
      } else if (null == attributeValue2) {
        if (isAttributeNullBiggest || isNullBiggest) {
          result = -1;
        } else {
          result = 1;
        }
      } else if (attributeValue1 instanceof Comparable) {
        // To do
        if (isCaseInsensitiveOrder && attributeValue1 instanceof String) {
          result = comparator.compare(attributeValue1, attributeValue2);
        } else {
          result = ((Comparable) attributeValue1).compareTo(attributeValue2);
        }
      }

      // To do
      if (0 == result) {
        continue;
      }

      if (sortingAttribute.isAscending()) {
        return result;
      } else {
        return 0 - result;
      }
    }
    return 0;
  }

}
