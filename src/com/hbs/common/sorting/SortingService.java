package com.hbs.common.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class SortingService {
  private SortingService() {
  }

  @SuppressWarnings("unchecked")
  public static Collection sortBySequence(Collection objectCollection, boolean isAscending) {
    return sortBySingleAttribute(objectCollection, "sequence", isAscending);
  }

  @SuppressWarnings("unchecked")
  public static Collection sortBySingleAttribute(Collection objectCollection, String attributeName, boolean isAscending) {
    ArrayList<SortingAttribute> sortingAttributeList = new ArrayList<SortingAttribute>();
    SortingAttribute sa = new SortingAttribute();
    sa.setAscending(isAscending);
    sa.setAttributeName(attributeName);
    sortingAttributeList.add(sa);
    return sortByAttributeList(objectCollection, sortingAttributeList);
  }

  @SuppressWarnings("unchecked")
  public static Collection sortByAttributeList(Collection objectCollection, List sortingAttributeList) {
    return sortByAttributeList(objectCollection, sortingAttributeList, false, false);
  }

  @SuppressWarnings("unchecked")
  public static Collection sortByAttributeList(Collection objectCollection, List sortingAttributeList, boolean isNullBiggest) {
    return sortByAttributeList(objectCollection, sortingAttributeList, isNullBiggest, false);
  }

  @SuppressWarnings("unchecked")
  public static Collection sortByAttributeList(Collection objectCollection, List sortingAttributeList, boolean isNullBiggest,
      boolean isCaseInsensitiveOrder) {
    Object[] objects = sortByAttributeList(objectCollection.toArray(), sortingAttributeList, isNullBiggest, isCaseInsensitiveOrder);
    List<Object> newSortedList = Arrays.asList(objects);
    objectCollection.clear();
    objectCollection.addAll(newSortedList);
    return newSortedList;
  }

  @SuppressWarnings("unchecked")
  public static Object[] sortByAttributeList(Object[] objects, List sortingAttributeList, boolean isNullBiggest, boolean isCaseInsensitiveOrder) {
    Arrays.sort(objects, new SortingComparator(sortingAttributeList, isNullBiggest, isCaseInsensitiveOrder));
    return objects;
  }

  @SuppressWarnings("unchecked")
  public static Collection sortByAttributeList(Collection objectCollection, String orderByAttributeName) {
    sortByAttributeList(objectCollection, constructSortingAttributes(orderByAttributeName, true));
    return objectCollection;
  }

  public static void sortByAttributeList(Collection objectCollection, String orderByAttributeName, boolean isNullBiggest) {
    sortByAttributeList(objectCollection, constructSortingAttributes(orderByAttributeName, true), isNullBiggest);
  }

  public static List<SortingAttribute> constructSortingAttributes(String attributeName, boolean isOrderByAscending) {
    List<SortingAttribute> result = new ArrayList<SortingAttribute>();
    result.add(new SortingAttribute(attributeName, isOrderByAscending));
    return result;
  }

  public static List<SortingAttribute> constructSortingAttributes(boolean isOrderByAscending, String... attributeNames) {
    List<SortingAttribute> sortingAttributes = new ArrayList<SortingAttribute>();
    for (String attributeName : attributeNames) {
      SortingAttribute sortingAttribute = new SortingAttribute();
      sortingAttribute.setAscending(isOrderByAscending);
      sortingAttribute.setAttributeName(attributeName);
      sortingAttributes.add(sortingAttribute);
    }
    return sortingAttributes;
  }
  
  public static Collection<?> sortByAttributeList(Collection<?> objectCollection, boolean isNullBiggest, boolean isOrderByAscending,
      String... attributeNames) {
    return sortByAttributeList(objectCollection, constructSortingAttributes(isOrderByAscending, attributeNames), isNullBiggest);
  }
}

