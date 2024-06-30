package com.example.demo1;

public class Child extends Person{
    public Person parent;

    public Child(Person parent) {
        this.parent = parent;
    }

    public Child( String name, Person parent) {
        super(name);
        this.parent = parent;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }
    @Override
    public String work(){
        return (this.getName() + " is child of " + parent.getName());
    }
}
