import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForEach {

    public static void main(String[] args) {

    }


    static void forEachArray(){
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        for (int i : numbers) {
            System.out.println(i);
        }

        String[] clh = new String[]{"Code", "Learn", "Hub"};

        for (String s : clh) {
            s = s.toUpperCase();
        }

        for (String s : clh) {
            System.out.println(s);
        }
    }

    static void forEachCollection(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer number : numbers) {
            System.out.println(number);
        }

        Set<String> clh = Set.of("C", "L", "H");
        for (String s : clh) {
            System.out.println(s);
        }
    }

    static void forEachMap(){
        Map<Integer, String> map = Map.of(1, "C", 2, "L", 3, "H");
        System.out.println("Printing keys:");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("Printing values:");
        for (String s : map.values()) {
            System.out.println(s);
        }

    }

    static void concurrentModification(){
        List<String> s = new ArrayList<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        for (String s1 : s) {
            s.remove(s1);
        }
    }
}
