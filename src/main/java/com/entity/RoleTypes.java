package com.entity;


public enum RoleTypes {
    USER("USER"),
    ADMIN("ADMIN"),
    ANONYM("ANONYM"),
    PRE_AUTH_USER("PRE_AUTH_USER");


    String roleType;

    private RoleTypes(String roleType) {
        this.roleType = roleType;
    }

    public String getUserProfileType() {
        return roleType;
    }
}
