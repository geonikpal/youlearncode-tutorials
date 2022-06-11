import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ListToArray {

    private static final List<Person> authors = Arrays.asList(
            new Person("G", "P"),
            new Person("D", "T"),
            new Person("I", "M")
    );

    public static void main(String[] args) {
        forLoop();
    }

    static void listToArray(){
        List<String> names = Arrays.asList(
                "Georgios",
                "Nikolaos",
                "Dimitrios",
                "Ioannis"
        );
        Object[] namesArray = names.toArray();
    }

    static void listToArray1(){
        List<String> names = Arrays.asList(
                "Georgios",
                "Nikolaos",
                "Dimitrios",
                "Ioannis"
        );
        String[] namesArray = names.toArray(new String[0]);
    }

    static void listToArray2(){
        List<String> names = Arrays.asList(
                "Georgios",
                "Nikolaos",
                "Dimitrios",
                "Ioannis"
        );
//      String[] namesArray = names.toArray(String[]::new);
        String[] namesArray = names.toArray(i -> new String[0]);
    }

    static void shallow(){
         Person[] authorsArray = authors.toArray(Person[]::new);
         authors.get(0).setName("X");
         System.out.println(authorsArray[0]);

    }

    static void forLoop(){
        Person[] authorsArray = new Person[authors.size()];
        for (var i = 0; i < authorsArray.length; i++) {
            authorsArray[i] = new Person(authors.get(i));
        }
        //Change a value in list
        authors.get(0).setName("Hello");
        System.out.println(authorsArray[0]);
        // Change a value in array
        authorsArray[2].setName("World");
        System.out.println(authors.get(2));

    }

    static void forLoopPrimitive() {
        List<Integer> numbers =  Arrays.asList(1, 2, 3, 4, 5);
        int[] numbersArray = new int[numbers.size()];
        for (var i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = numbers.get(i);
        }
    }

    static void forEachLoop(){
        Person[] authorsArray = new Person[authors.size()];
        int i = 0;
        for(var person : authors){
            authorsArray[i] = new Person(authors.get(i));
            i++;
        }

    }

    static void whileLoop(){
        Person[] authorsArray = new Person[authors.size()];
        int i = 0;
        Iterator<Person> it = authors.iterator();
        while (it.hasNext()){
            authorsArray[i] = new Person(it.next());
            i++;
        }
    }

    static void java8forEach(){
        Person[] authorsArray = new Person[authors.size()];
        AtomicInteger i = new AtomicInteger(0);
        authors.forEach(name -> {
            authorsArray[i.get()] = new Person(authors.get(i.get()));
            i.incrementAndGet();
        });
    }


    private static class Person {
        private String name;
        private String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Person(Person other){
            this.name = other.name;
            this.surname = other.surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }

}
