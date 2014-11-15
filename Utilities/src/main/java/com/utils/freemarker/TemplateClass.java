package com.utils.freemarker;

import org.springframework.stereotype.Component;

/**
 * Created by Rox on 15.11.2014.
 */
@Component
public class TemplateClass {

    private String name;

    private int age;

    public TemplateClass(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
