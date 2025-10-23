package com.manuelhg.demo.model;

import lombok.Data;
import lombok.ToString;

@Data //GENERA GETTERS Y SETTERS//
@ToString

public class Student extends Person {

    private String course;

    public Student(String dni, String name, String surname) {
        super(dni, name, surname);
    }

    public Student(String dni, String name, String surname, String course) {
        super(dni, name, surname);
        this.course = this.course;
    }

}
