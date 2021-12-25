package com.codelearnhub.example.model_person_employee;

public class Person {

     public String name;
     protected String surname;
     String address;
     private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {

        Person person = new Person();

        // We can modify each member directly
        // since all the members are in the same class
        person.name = "John";
        person.surname = "Smith";
        person.address = "Thiseos 100, Kallithea";
        person.ID = "HJ567900";

        // Then print it
        System.out.println(person.name);
        System.out.println(person.surname);
        System.out.println(person.address);
        System.out.println(person.ID);

    }
}
