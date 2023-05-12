package com.youlearncode.bytes.streams;

import com.youlearncode.entities.Person;
import com.youlearncode.tools.Helper;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStream {
  
  public static void readUsingDataInputStream() {
    if (!Helper.saveDataToFile(new Person("Mike", 44))) throw new RuntimeException(Person.class.getName() + " not saved!");
    try (DataInputStream in = new DataInputStream(new FileInputStream(Helper.getDataFilePath()))) {
      Person person = new Person(in.readUTF(), in.readInt());
      System.out.println(person);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
