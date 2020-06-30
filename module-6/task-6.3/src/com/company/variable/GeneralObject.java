package com.company.variable;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GeneralObject {

    protected Map<String, String> childrenElements = new LinkedHashMap<>();

    public Map<String, String> getChildrenElements(){
        return childrenElements;
    }
}
