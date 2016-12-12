package com.jaitra.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.StringUtils;
 
public class BeanCopy extends BeanUtilsBean {
 
    private boolean copyNulls = true;
    private boolean copyBlankStrings = true;
    private List<String> ignoreList;
    private List<String> explicitList;
 
    public BeanCopy() {
    }
 
    public BeanCopy(boolean copyNulls, boolean copyBlankStrings) {
        this.copyNulls = copyNulls;
        this.copyBlankStrings = copyBlankStrings;
    }
 
    public BeanCopy(boolean copyNulls, boolean copyBlankStrings, String[] propertiesToIgnore,
            String[] explicitProperties) {
        this.copyNulls = copyNulls;
        this.copyBlankStrings = copyBlankStrings;
        if (propertiesToIgnore != null) {
            ignoreList = Arrays.asList(propertiesToIgnore);
        }
        if (explicitProperties != null) {
            explicitList = Arrays.asList(explicitProperties);
        }
    }
 
    @Override
    public void copyProperty(Object bean, String name, Object value) throws IllegalAccessException,
            InvocationTargetException {
        if (explicitList != null) {
            if (!explicitList.contains(name)) {
                return;
            }
        } else if (ignoreList != null) {
            if (ignoreList.contains(name)) {
                return;
            }
        }
        if (!copyNulls && (value == null)) {
            return;
        }
        if (!copyBlankStrings && (value instanceof String)) {
            String strVal = (String) value;
            if (StringUtils.isBlank(strVal)) {
                return;
            }
        }
        super.copyProperty(bean, name, value);
    }
 
}