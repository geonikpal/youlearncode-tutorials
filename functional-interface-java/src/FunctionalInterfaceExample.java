import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        consumerExample();
        predicateExample();
        useCustomFunctionalInterface();
    }


    public static void predicateExample(){
        Stream.of("Hello", "World!", "Code!", "LEARN!", "hub").
                filter(
                        Predicate.isEqual("Hello")
                        .or(
                                Predicate.not(s -> ((String) s).contains("!"))
                        )
                        .negate()

                )
                .forEach(System.out::println);
    }

    public static void consumerExample(){

        Consumer<String> printer = System.out::println;
        Consumer<String> printAgainWithStars = s -> System.out.println(s+"*");

        Stream.of("C", "L", "H")
                .forEach(printer.andThen(printAgainWithStars));
    }

    private static void useCustomFunctionalInterface(){
        TriFunction<String, String, Integer, String> function = (s1, s2, i1) -> s1 + s2 + i1;
        Stream.of(
                        new Person("Geo", "Pal", 26),
                        new Person("Dim", "Tas", 35),
                        new Person("Ion", "Mak", 30)
                ).map(p -> function.apply(p.name(), p.surname(), p.age()))
                .forEach(System.out::println);

    }

    private record Person(String name, String surname, Integer age){}
}
