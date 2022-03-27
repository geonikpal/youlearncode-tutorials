
import java.util.*;

public class OptionalExample {

    public static void main(String[] args) {

    }

    static void optionalFilter() {
        Optional<String> opt = Optional.of("hello").filter(x -> x.contains("ell"));
        System.out.println(opt.isEmpty());
        opt = Optional.of("hello").filter(x -> x.contains("g"));
        System.out.println(opt.isEmpty());
    }

    static void optionalMap() {
        Optional<Integer> integerOptional = Optional.of("12").map(Integer::parseInt);
        System.out.println(integerOptional.get());
    }

    static void optionalFlatMap() {
        Optional<Integer> optionalInteger = Optional.of("100").flatMap(
                x -> Optional.of(Integer.parseInt(x)).filter(z -> z > 50)
        );
        System.out.println(optionalInteger.get());

        Optional<Optional<Integer>> wrappedOptional = Optional.of("100").map(
                x -> Optional.of(Integer.parseInt(x)).filter(z -> z > 50)
        );
        System.out.println(optionalInteger.get());
    }

    static void optionalOr(){

        Optional<String> filledOptional = Optional.of("Hello").or(() -> Optional.of("It was empty"));
        System.out.println(filledOptional.get()); // will print "Hello"

        Optional<Object> emptyOptional = Optional.empty().or(() -> Optional.of("It was empty"));
        System.out.println(emptyOptional.get()); // will print "It was empty"

    }

    static void optionalIfPresent(){
        Optional.of("Hello").ifPresent(System.out::println); // will print "Hello"
        Optional.empty().ifPresent(System.out::println); // will print nothing
    }

    static void optionalIfPresentOrElse(){
        Optional.of("Hello")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("It was not present")
                ); // will print "Hello"
        Optional.empty()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("It was not present")
                ); // will print "It was not present"
    }

    static void ofVSofNullable(){
        try {
            Optional.of(null);
        } catch (NullPointerException npe){
            System.out.println("Passed null to .of method");
        }

        Optional.ofNullable(null);
        System.out.println("It worked");

    }

    static void get(){
        Optional.empty().get();
    }

    static void orElse(){
        String res = Optional.of("Hello").orElse(returnDefault());
        System.out.println(res);// res is "Hello"
        res = (String) Optional.empty().orElse(returnDefault());
        System.out.println(res);// res is "Was Empty"
    }

    static void orElseGet(){

        String res = Optional.of("Hello").orElseGet(OptionalExample::returnDefault);
        System.out.println(res);// res is "Hello"
        res = (String) Optional.empty().orElseGet(OptionalExample::returnDefault);
        System.out.println(res);// res is "Default"
    }

    static void orElseThrow(){
        // No arguments
        String res = Optional.of("Hello").orElseThrow();
        System.out.println(res);// res is "Hello"
        try {
            res = (String) Optional.empty().orElseThrow();
        } catch (NoSuchElementException exception){
            exception.printStackTrace();
        }
        String clh =  Optional.of("CodeLearnHub").orElseThrow(IllegalArgumentException::new);
        System.out.println(clh);
        try {
            clh = (String) Optional.empty().orElseThrow(() -> new IllegalArgumentException("You passed null value"));

        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

    }

    private static void nullCheckWithOptionals(){
        List<String> list = null;
        if(Math.random() >= 0.5){
            list = Arrays.asList("Hello", "World");
        }
        list = Optional.ofNullable(list)
                .map(list1 -> list1.stream().map(String::toUpperCase).toList())
                .orElse(Collections.emptyList());
        list.forEach(System.out::println);
    }

    private static void nullCheckWithoutOptionals(){
        List<String> list = null;
        if(Math.random() >= 0.5){
            list = Arrays.asList("Hello", "World");
        }
        if(list != null){
            list = list.stream().map(String::toUpperCase).toList();
        }
        else {
            list = Collections.emptyList();
        }
        list.forEach(System.out::println);
    }

    private static String returnDefault(){
        System.out.println("Returning the default");
        return "Default";
    }
}
