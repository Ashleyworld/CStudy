package org.example.test1;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Person implements Serializable {

    public Person() {
    }

    private String name;
    private String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{\n" +
                "name='" + name + "\'\n" +
                ", gender='" + gender + "\'\n" +
                '}';
    }
}


