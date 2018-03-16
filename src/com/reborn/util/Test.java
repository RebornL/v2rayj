package com.reborn.util;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test {

    private final int testInt;
    private final String testString;
    private final StringProperty lastName;
    //StringProperty很神奇，被final修饰还可以有setter方法

    public Test(){
        this.testInt = 1;
        this.testString = "nothing";
        this.lastName = new SimpleStringProperty("lastName");
    }

    public Test(int testInt, String testString, String lastName) {
        this.testInt = testInt;
        this.testString = testString;
        this.lastName = new SimpleStringProperty(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}
