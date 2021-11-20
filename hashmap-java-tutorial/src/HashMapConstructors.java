import java.util.HashMap;

public class HashMapConstructors {

    public static void main(String[] args) {

        noParametersConstructor();

        initialCapacityConstructor();

        initialCapacityAndLoadFactorConstructor();

        otherMapConstructorConstructor();

    }

    public static void noParametersConstructor(){

        /* Initialize a hashmap with the no-parameters constructor constructor
         *  Note that the type parameters cannot be primitive types
         */
        HashMap<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1,"Giorgos");
        namesMap.put(2,"Dimitris");
        namesMap.put(3,"Giannis");
        namesMap.put(4,"Nikolaos");
        namesMap.put(5,"Akis");
        // Print all the entries in the map

        System.out.println("Printing all the entries - no argument constructor");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();
    }

    public static void initialCapacityConstructor() {

        /* Initialize a hashmap with the constructor taking the initialCapacity
         * Hadn't we set the initial capacity, the constructor would resize after the 12th element ( 0.75 load factor * 16 initial capacity = 12 )
         */
        HashMap<Integer, String> numbersMap = new HashMap<>(100);


        // Now it will resize after the 75th element has been instered ( 0.75 load factor * 100 initial capacity = 75 )
        for (int i = 0; i < 100; i++)
            numbersMap.put(i, "A" + i);
    }

    public static void initialCapacityAndLoadFactorConstructor() {

        /* Initialize a hashmap with the constructor taking the initialCapacity and the loadFactor
         * Hadn't we set the initial capacity, the constructor would resize after the 12th element (0.75 load factor * 16 initial capacity = 12 )
         * Now it will resize after the 90th element has been inserted (0.9 load factor * 100 initial capacity)
         */
        HashMap<Integer, String> numbersMap = new HashMap<Integer, String>(100,0.9f);

        for (int i = 0; i < 100; i++)
            numbersMap.put(i, "A" + i);
    }

    public static void otherMapConstructorConstructor() {
        // Here is the map we used in the first example

        HashMap<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1,"Giorgos");
        namesMap.put(2,"Dimitris");
        namesMap.put(3,"Giannis");
        namesMap.put(4,"Nikolaos");
        namesMap.put(5,"Akis");

        // Now we create a new HashMap by using the namesMap HashMap
        HashMap<Integer, String> newNamesMap =  new HashMap<>(namesMap);

        // We fill it with more entries
        newNamesMap.put(6, "Petros");
        newNamesMap.put(7, "Panagiotis");

        //Print the result
        System.out.println("Printing all the entries - using the constructor accepting other map");
        newNamesMap.entrySet().forEach(System.out::println);

    }


}
