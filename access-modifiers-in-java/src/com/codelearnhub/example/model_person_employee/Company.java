package com.codelearnhub.example.model_person_employee;

/**
 * Case of class within the same package
 */
public class Company {


    public static void main(String[] args) {

        Person person = new Person();

        // We can modify members with
        // public,protected and default access
        person.name = "John";
        person.surname = "Smith";
        person.address = "Thiseos 100, Kallithea";


        /*
         *  We cannot modify directly private members,
         *  we can only modify them
         *  through setters
         */

        // This won't compile
        //person.ID = "HJ567900";
        person.setID("HJ567900");

        // Then print it
        System.out.println(person.name);
        System.out.println(person.surname);
        System.out.println(person.address);

        //We can print it only through getter method
        System.out.println(person.getID());

    }
}
