package com.hbs.common.sorting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class ReflectionUtil {

  public static Object getAttributeValue(String attributeNames, Object obj) {
    return getAttributeValue(attributeNames, obj, false);
  }

  public static Object getAttributeValue(String attributeNames, Object obj, boolean isCreateSubObject) {
    Object attributeValue = null;
    // Class attributeValueType = null;
    try {
      String attributeName = attributeNames;
      if (attributeNames.indexOf(".") > 0) {
        attributeName = attributeNames.substring(0, attributeNames.indexOf("."));
      }
      if (null != obj && StringUtil.isNotNullNorEmpty(attributeName)) {
        String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
        Method methodInfo = null;
        try {
          methodInfo = obj.getClass().getMethod("get" + methodName);
        } catch (Exception ex) {
          try {
            methodInfo = obj.getClass().getMethod("is" + methodName);
          } catch (Exception ex2) {
            methodInfo = obj.getClass().getMethod(methodName);
          }
        }

        if (null != methodInfo) {
          // attributeValueType = methodInfo.getReturnType();
          attributeValue = methodInfo.invoke(obj);
        } else {
          throw new Exception("No such attribute [" + attributeName + "] in object [" + obj + "]");
        }
        if (null != attributeValue && attributeNames.indexOf(".") > 0) {
          return getAttributeValue(attributeNames.substring(attributeNames.indexOf(".") + 1), attributeValue, isCreateSubObject);
        }
      }
    } catch (Exception ex) {
    }
    return attributeValue;
  }

  public static void setAttributeValue(String attributeName, Object newAttributeValue, Object topObj, Class<?> clazz) throws Exception {
    try {
      Object obj = topObj;
      if (null != obj && StringUtil.isNotNullNorEmpty(attributeName)) {
        String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
        Method methodInfo = null;
        try {
          methodInfo = obj.getClass().getMethod("set" + methodName, clazz);
        } catch (NoSuchMethodException ex) {
          methodInfo = obj.getClass().getMethod(methodName, clazz);
        }
        if (null != methodInfo) {
          methodInfo.invoke(obj, newAttributeValue);
        } else {
          throw new Exception("No such attribute [" + attributeName + "] in object [" + obj + "]");
        }
      }
    } catch (Exception ex) {
      throw ex;
    }
  }

  public static Object invokeFunction(String attributeName, Object newAttributeValue, Object topObj) throws Exception {
    try {
      Object obj = topObj;
      if (null != obj && StringUtil.isNotNullNorEmpty(attributeName)) {
        Method methodInfo = null;
        try {
          methodInfo = obj.getClass().getMethod(attributeName, newAttributeValue.getClass());
        } catch (Exception ex) {
          methodInfo = obj.getClass().getMethod(attributeName, newAttributeValue.getClass());
        }
        if (null != methodInfo) {
          return methodInfo.invoke(obj, newAttributeValue);
        } else {
          throw new Exception("No such attribute [" + attributeName + "] in object [" + obj + "]");
        }
      }
      return null;
    } catch (Exception ex) {
      throw ex;
    }
  }

  public static String mergeTemplateWithObject(String templateContent, Object object) {
    if (CommonUtil.isNullObject(object) || StringUtil.isNullOrEmpty(templateContent)) {
      return templateContent;
    }
    Method[] methods = object.getClass().getMethods();
    String localContent = templateContent;
    for (Method method : methods) {
      String methodName = method.getName();
      if (methodName.startsWith("get") && methodName.length() > 3 && !methodName.equals("getClass")
          && method.getParameterTypes().length == 0) {
        String propertyName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
        try {
          Object val = method.invoke(object, new Object[] {});
          // convert null to empty string
          if (null == val) {
            val = StringUtils.EMPTY;
          }
          String value = val.toString();
          localContent = StringUtil.replaceAll(localContent, "${" + propertyName + "}", value);
          // add $!{...} place holder case to fit with Velocity behavior.
          localContent = StringUtil.replaceAll(localContent, "$!{" + propertyName + "}", value);
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
      }
    }
    return localContent;
  }

  public static List<Method> getAllPublicGetterMethods(Object bean) {
    Method[] methods = bean.getClass().getMethods();
    List<Method> getters = new ArrayList<Method>();
    for (Method method : methods) {
      String methodName = method.getName();
      if (methodName.indexOf("get") != 0 || methodName.equals("getClass")) {
        continue;
      }
      if (!Modifier.isPublic(method.getModifiers())) {
        continue;
      }
      if (method.getParameterTypes().length != 0) {
        continue;
      }
      getters.add(method);
    }
    return getters;
  }
}
