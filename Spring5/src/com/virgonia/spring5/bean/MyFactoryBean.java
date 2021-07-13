package com.virgonia.spring5.bean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setcName("数据库");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
