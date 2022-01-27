package Wildcards_With_Generics;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardsEx {
    public static void main(String[] args){

        List<Integer> l1 = Arrays.asList(20, 30, 40);
        List<Double> l2 = Arrays.asList(20.5, 30.5, 40.5);

        method(l1);
        method(l2);
    }

    private static void method(List<?> lists){

        System.out.println(lists);
    }
}

