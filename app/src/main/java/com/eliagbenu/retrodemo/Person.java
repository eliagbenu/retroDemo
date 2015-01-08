package com.eliagbenu.retrodemo;

import java.util.ArrayList;

/**
 * Created by eli on 1/2/15.
 */
public class Person {

    int id;
    String name;
    int account_number;

    public Person(){}

    public Person(String name, Integer account_number) {
        this.name = name;
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return account_number;
    }

}

