import java.util.HashMap;

public class HashMapPut {

    public static void main(String[] args) {
        System.out.println("put()");
        put();
        System.out.println("putAll()");
        putAll();
        System.out.println("putIfAbsent()");
        putIfAbsent();
    }

    public static void put(){

        HashMap<Integer, String> namesMap = new HashMap<>();

        /* put( K key, V value) inserts entries in the map
         * by providing the key and the value, the ordering is
         * preserved
         * It returns the value of the mapping
         */
        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        //print the result
        System.out.println("HashMap after calling 3 times the put() method : ");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();

        // If key already exists, it will be replaced
        namesMap.put(2,"Periklis");

        System.out.println("HashMap after calling put method with key 2 -> Periklis : ");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();
    }

    public static void putAll(){
        /* putAll(Map<? extends K,? extends V> m)
         * copies all the entries from one map into another
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        /* put( K key, V value) inserts entries in the map
         * by providing the key and the value, the ordering is
         * preserved
         */

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        HashMap<Integer, String> namesMapFemales = new HashMap<>();

        //Be careful - if the key already exists, it will be replaced, e.g. entry 3
        namesMapFemales.put(4, "Evi");
        namesMapFemales.put(5, "Filio");
        namesMapFemales.put(3, "Anna");

        namesMap.putAll(namesMapFemales);

        //print the result
        System.out.println("HashMap after calling putAll() method : ");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();

    }

    public static void putIfAbsent(){
        /* putIfAbsent(K key, V value)
         * inserts the mapping only if the key is not taken
         * It returns the value
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        /* putIfAbsent(K key, V value) inserts entries in the map
         * by providing the key and the value, the ordering is
         * preserved
         * It returns the value of the mapping
         */
        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        //print the result
        System.out.println("HashMap after calling 3 times the put() method : ");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();

        // This will not be replace the mapping, it already exists
        namesMap.putIfAbsent(2,"Periklis");

        // This will work like put()
        namesMap.putIfAbsent(4,"Leonidas");

        System.out.println("HashMap after calling putIfAbsent() method with key 2 -> Platonas and with key 4 -> Leonidas: ");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();

    }
}
