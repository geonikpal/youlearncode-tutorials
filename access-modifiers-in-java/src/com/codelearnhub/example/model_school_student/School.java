package com.codelearnhub.example.model_school_student;

import com.codelearnhub.example.model_person_employee.Person;

/**
 * Case of non-related class, in different package
 */
public class School {

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

        /*
         * You can only set them
         * through setters and
         * access them through getters
         */

        /*
         * This will never compile when
         * it is run in a class
         * other than Person
        */

        //person.ID = "HJ567900";

        //Let's try for student

        Student student = new Student();

        // This will always work
        student.name = "John";

        /*
         * Since the class School is
         * not a subclass of Person,
         * whatever applies to Person,
         * applies to Student
         */

         //As before, these won't compile

         // student.surname = "Smith";
         // student.address = "Thiseos 100, Kallithea";
         // student.ID = "HJ567900";

        /*
         * You can only set them
         * through setters and
         * access them through getters
         */

    }
}
