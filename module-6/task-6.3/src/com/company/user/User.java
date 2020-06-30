package com.company.user;

import com.company.variable.GeneralObject;

public class User extends GeneralObject {
    private String accessLevel;
    private String password;

    public User(){
    }

    public User setAccessLevel(String value){
        this.accessLevel = value;
        ChildrenElements.ACCESS_LEVEL.setName(value);
        return this;
    }

    public User setLogin(String value){
        ChildrenElements.LOGIN.setName(value);
        return this;
    }

    public User setPassword(String value){
        this.password = value;
        ChildrenElements.PASSWORD.setName(value);
        return this;
    }

    public String getAccessLevel(){
        return this.accessLevel;
    }

    public String getPassword(){
        return this.password;
    }

    public User createChildrenElements(){
        for(User.ChildrenElements value : User.ChildrenElements.values()) {
            childrenElements.put(value.toString(), value.getName());
        }
        return this;
    }

    private enum ChildrenElements {
        ACCESS_LEVEL(""),
        LOGIN(""),
        PASSWORD("");

        private String value;

        ChildrenElements(String value){
            this.value = value;
        }

        void setName(String value){
            this.value = value;
        }

        String getName(){
            return this.value;
        }
    }
}
