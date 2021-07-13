package com.virgonia.spring5.bean;

public class Course {
    private String cName;

    public void setcName(String cName) {
        this.cName = cName;
    }


    @Override
    public String toString() {
        return cName;
    }



}
