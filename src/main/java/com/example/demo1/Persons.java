package com.example.demo1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Persons {
    private String parentText;
    private String childText;

    public Persons(String parentText, String childText) {
        this.parentText = parentText;
        this.childText = childText;
    }

    public String getParentText() {
        return parentText;
    }

    public void setParentText(String parentText) {
        this.parentText = parentText;
    }

    public String getChildText() {
        return childText;
    }

    public void setChildText(String childText) {
        this.childText = childText;
    }
}
