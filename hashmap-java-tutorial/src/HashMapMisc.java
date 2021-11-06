import java.util.HashMap;

public class HashMapMisc {

    public static void main(String[] args) {

        HashMap<String, String> countriesCapitalsMap = new HashMap<>();
        countriesCapitalsMap.put("Greece", "Athens");
        countriesCapitalsMap.put("Spain", "Madrid");
        countriesCapitalsMap.put("Italy", "Rome");

        /* containsKey(K key)
         *  returns true if the key exists in the map
         */
        System.out.println("Entry with key Greece exists?");
        System.out.println(countriesCapitalsMap.containsKey("Greece"));
        System.out.println();

        System.out.println("Entry with key Germany exists?");
        System.out.println(countriesCapitalsMap.containsKey("Germany"));
        System.out.println();

        /* containsValue(V key)
         *  returns true if the value exists in the map
         */
        System.out.println("Entry with value Athens exists?");
        System.out.println(countriesCapitalsMap.containsValue("Athens"));
        System.out.println();

        System.out.println("Entry with value Berlin exists?");
        System.out.println(countriesCapitalsMap.containsValue("Berlin"));
        System.out.println();

        /* isEmpty()
         * returns true if the HashMap has no entries
         */

        // Will return false
        countriesCapitalsMap.isEmpty();

        // Will return true
        new HashMap<>().isEmpty();

        /* size()
         * returns the number of entries in the HashMap
         */

        // Will return 3
        countriesCapitalsMap.size();

        // HashMap forEach
        countriesCapitalsMap.forEach((k,v) -> System.out.println("Key is: "+ k + ", Value is: " + v));

    }
}
