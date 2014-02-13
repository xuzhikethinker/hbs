package com.hbs.common.sorting;

public class StringUtil {
  public static boolean isNullOrEmpty(String stringValue) {
    return stringValue == null || stringValue.trim().length() == 0;
  }
  
  public static boolean isNotNullNorEmpty(String stringValue) {
    return !isNullOrEmpty(stringValue);
  }
  
  public static String replaceAll(String str, String src, String dest) {
    if (str == null || str.length() == 0 || src == null || src.length() == 0 || dest == null || str.length() < src.length()) {
      return str;
    }
    StringBuffer sb = new StringBuffer();
    int strL = str.length();
    int srcL = src.length();
    int compareL = strL - srcL + 1;
    boolean equals = false;
    int position = 0;
    for (int i = 0; i < compareL; i++) {
      equals = false;
      if (str.charAt(i) == src.charAt(0)) {
        position = i + 1;
        if (srcL == 1) {
          equals = true;
        }
        for (int j = 1; j < srcL; position++, j++) {
          if (str.charAt(position) == src.charAt(j)) {
            equals = true;
          } else {
            equals = false;
            break;
          }
        }
        if (equals) {
          sb.append(dest);
          i += srcL - 1;
        } else {
          sb.append(str.charAt(i));
        }
      } else {
        sb.append(str.charAt(i));
      }
    }
    if (!equals) {
      for (int i = compareL; i < strL; i++) {
        sb.append(str.charAt(i));
      }
    } else {
      for (int i = position; i < strL; i++) {
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }
}
