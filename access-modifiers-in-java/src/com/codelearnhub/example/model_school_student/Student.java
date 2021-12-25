package com.codelearnhub.example.model_school_student;

import com.codelearnhub.example.model_person_employee.Person;

public class Student extends Person {

    public static void main(String[] args) {

        Person person = new Person();

        /* We can only access and modify
         * name, as it is public
         */
        person.name = "John";

        // The next 2 assignments won't
        // compile, since we are on a different package

        //person.surname = "Smith";
        //person.address = "Thiseos 100, Kallithea";

        // You can only set them
        // through setters

        /* This will never compile when
         * it is run in a class
         * other than Person
         */

        //person.ID = "HJ567900";

        // Let's try for student

        Student student = new Student();

        // No problem setting this
        student.name = "John";

        // Now the surname can be set directly
        // as the its access is protected

        student.surname = "Smith";

        // For the other 2 members
        // we need setters and getters
        // to modify and access them

    }
}
