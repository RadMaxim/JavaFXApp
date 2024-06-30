package com.example.demo1;

public class Person {
    private static Integer count = 0;
    private Integer id;
    private String name;

    public Person(String name) {
        this.id = ++count;
        this.name = name;
        System.out.println(count);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }
    public String work(){
        return ("Person " + name + " works");
    }

}
