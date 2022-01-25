package com.xq.demo;

import lombok.Data;

@Data
public class Person<T> {

    private T stu;
    private String name;
}


