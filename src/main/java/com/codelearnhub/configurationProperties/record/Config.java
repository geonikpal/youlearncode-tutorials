package com.codelearnhub.configurationProperties.record;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app")
public record Config(char c,
                     int i,
                     double d,
                     String str,
                     Person person,
                     String[] array,
                     List<Person> personList,
                     Map<String, Person> personMap
) {
    public record Person(String name, String surname){}
}
