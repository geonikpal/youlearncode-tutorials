package Wildcards_With_Generics;

import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcardsEx {
    public static void main(String[] args)
    {
        List<Integer> l1 = Arrays.asList(20, 30, 40);

        method(l1);


        List<Double> l2 = Arrays.asList(20.5, 30.5, 40.5);

       // method(l2);
    }

    public static void method(List<? super Integer> lists) {
                 System.out.println(lists);
    }
}

