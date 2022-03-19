import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

    public static void main(String[] args) {

        reduceOneParam();
        reduceTwoParams();
        reduceThreeParams();

    }


    static void reduceOneParam(){
        List<String> clh = Arrays.asList("Code", "Learn", "Hub");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String result = clh.stream().reduce(String::concat).get();
        //exactly the same as above
        // String result = clh.stream().reduce((s1, s2) -> s1.concat(s2)).get());

        int sum = numbers.stream().reduce(Integer::sum).get();
        //exactly the same as above
        // int sum = numbers.stream().reduce((n1, n2) -> n1 + n2).get();

        System.out.println("Reduce on list of strings : " + result);
        System.out.println("Reduce on list of ints : " + sum);
    }

    static void reduceTwoParams(){
        List<String> clh = Arrays.asList("Code", "Learn", "Hub");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String result = clh.stream().reduce("Website:", String::concat);

        int sum = numbers.stream().reduce(100,Integer::sum);

        System.out.println("Reduce on list of strings : " + result);
        System.out.println("Reduce on list of ints : " + sum);
    }

    static void reduceThreeParams(){
        List<Integer> clh = Arrays.asList(1, 2, 3);
        String result = clh.stream()
                    .reduce("String is: ",
                            (firstNumber, secondNumber) -> firstNumber + secondNumber,
                            String::concat
                    );
        System.out.println(result);

    }

}
