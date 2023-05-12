package com.youlearncode.bytes.streams;

import com.youlearncode.entities.Person;
import com.youlearncode.tools.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStream {
  
  public static void readUsingObjectInputStream() {
    // Note that if save fails, it will throw an Exception.
    if (!Helper.saveObjectToFile(new Person("John", 25))) throw new RuntimeException(Person.class.getName() + " not saved!");
    readObjectFromFile();
  }
  
  private static void readObjectFromFile() {
    Person person;
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(Helper.getObjectFilePath()))) {
      person = (Person) in.readObject();
      System.out.println(person);
    }
    catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
  }
}
