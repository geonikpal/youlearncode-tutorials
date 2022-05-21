import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaExpression {

    private static void oneLineLambda(){
        // A Lambda that accepts no parameters and returns nothing
        Runnable runnable = () -> System.out.println("Hello World");
        // A Lambda that accepts no parameters and returns an empty string
        Supplier<String> emptyStringFunction = () -> "";
        // A Lambda that accepts one parameter and returns nothing
        Consumer<String> printString = (aString) -> System.out.println(aString);
        // When we have only one parameter, the parenthesis are optional
        // so the above can be written as
        Consumer<String> printString_ = aString -> System.out.println(aString);
        // At least two parameters lambda that returns nothing,
        // and just prints the 2 strings concatenated
        BiConsumer<String, String> printStringsConcatenated = (s1, s2) -> System.out.println(s1 + s2);
        // At least two parameters lambda expression that returns two concatenated strings
        BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
        // A 4-parameters lambda that returns a value could be written as follows:
//        (s1, s2, s3, s4) -> s1 + s2.toUpperCase() + s3.toLowerCase() + s4;
    }

    private static void multiLineLambda(){
        // A Lambda that accepts no parameters and returns nothing
        Runnable runnable = () -> {
            System.out.println("Hello World");
            System.out.println("Code Learn Hub");
        };
        // A Lambda that accepts no parameters and returns an empty string
        Supplier<String> emptyStringFunction = () -> {
            System.out.println("Hello World");
            return "";
        };
        // A Lambda that accepts one parameter and returns nothing
        Consumer<String> printString = aString -> {
            aString = aString.toUpperCase();
            System.out.println(aString);
        };
        // At least two parameters lambda that returns nothing,
        // and just prints the 2 strings concatenated
        BiConsumer<String, String> printStringsConcatenated = (s1, s2) -> {
            System.out.println("Inside Lambda");
            System.out.println(s1 + s2);
        };
        // At least two parameters lambda expression that returns two concatenated strings
        // With "Hello" at the end
        BinaryOperator<String> concat = (s1, s2) -> {
            String sNew = s1 + s2;
            sNew = sNew.concat("Hello");
            return sNew;
        };
    }

    private static void methodReference(){
        Consumer<String> printString = System.out::println;
        BiConsumer<String, String> printStringsConcatenated = LambdaExpression::printConcatenatedStrings;
        BinaryOperator<String> concat = String::concat;
    }

    private static void printConcatenatedStrings(String s1, String s2){
        System.out.println(s1 + s2);
    }
}
