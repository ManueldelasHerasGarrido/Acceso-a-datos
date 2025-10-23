package com.manuelhg.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data //GENERA GETTERS Y SETTERS//
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Person {
    private String dni;
    private String name;
    private String surname;


//    public Person(String dni, String name, String surname) {
//        this.dni = dni;
//        this.name = name;
//        this.surname = surname;
//    }
//
//    public String getDni() {
//        return dni;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }


}

