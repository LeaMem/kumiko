package com.lea.tinyioc.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        //todo: 去重
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValueList;
    }
}
