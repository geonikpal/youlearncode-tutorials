import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaOperator {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Giannis", "Dimitris", "Akis");
        names = names.stream()
                .filter(name -> name.startsWith("A")) // Here we use a Lambda function
                .map(String::toLowerCase)// Here we use method reference
                .collect(Collectors.toList());
        // This will print only the names that start with A after converting to lowercase
        names.forEach(System.out::println);
    }
}
