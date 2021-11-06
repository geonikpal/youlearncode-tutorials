import java.util.HashMap;

public class HashMapRemove {

    public static void main(String[] args) {

        System.out.println("remove()");
        remove();
        System.out.println();

        System.out.println("removeWithValue()");
        removeWithValue();
        System.out.println();

        System.out.println("clear()");
        clear();
    }

    public static void remove(){

        /* remove(K key)
         * This method removes an entry based on the key provided.
         * It returns the value of the mapping tha was removed
         */

        HashMap<String, String> countriesCapitalsMap = new HashMap<>();
        countriesCapitalsMap.put("Greece", "Athens");
        countriesCapitalsMap.put("Spain", "Madrid");
        countriesCapitalsMap.put("Italy", "Rome");

        System.out.println("Initial Map:");
        countriesCapitalsMap.entrySet().forEach(System.out::println);
        System.out.println();

        //Will return Athens
        countriesCapitalsMap.remove("Greece");

        System.out.println("Map after removal of Greece:");
        countriesCapitalsMap.entrySet().forEach(System.out::println);
        System.out.println();

    }

    public static void removeWithValue(){

        /* remove(K key, V Value)
         * This method removes an entry based on the key provided,
         * only if the key is mapped to the given value
         */

        HashMap<String, String> countriesCapitalsMap = new HashMap<>();
        countriesCapitalsMap.put("Greece", "Athens");
        countriesCapitalsMap.put("Spain", "Madrid");
        countriesCapitalsMap.put("Italy", "Rome");

        System.out.println("Initial Map:");
        countriesCapitalsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // This will remove Athens and return true
        countriesCapitalsMap.remove("Greece","Athens");

        // This will not remove Italy, since Italy maps to Rome
        countriesCapitalsMap.remove("Italy", "Venice");

        System.out.println("Map after the 2 removals:");
        countriesCapitalsMap.entrySet().forEach(System.out::println);
        System.out.println();

    }

    public static void clear(){

        /* clear()
         * Removes all the entries from a HashMap
         */

        HashMap<String, String> countriesCapitalsMap = new HashMap<>();
        countriesCapitalsMap.put("Greece", "Athens");
        countriesCapitalsMap.put("Spain", "Madrid");
        countriesCapitalsMap.put("Italy", "Rome");
        countriesCapitalsMap.clear();

        //This will print nothing as the HashMap is empty
        countriesCapitalsMap.entrySet().forEach(System.out::println);
    }
}
