import java.util.*;
import java.util.stream.Collectors;

public class HashMapAccess {

    public static void main(String[] args) {

        System.out.println("get()");
        get();
        System.out.println();

        System.out.println("getOrDefault()");
        getOrDefault();
        System.out.println();

        System.out.println("keySet()");
        keySet();
        System.out.println();

        System.out.println("entrySet()");
        entrySet();
        System.out.println();

        System.out.println("values()");
        values();
        System.out.println();

    }



    public static void get(){

        /* get(Object key)
         * returns tha value given a specific key
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        // This will print Sofoklis as there is a mapping for key 1
        System.out.println(namesMap.get(1));

        // This will print null as there isn't a mapping for key 5
        System.out.println(namesMap.get(5));

    }

    public static void getOrDefault(){

        /* getOrDefault(Object key, V defaultValue)
         * returns the value given a specific key, and if this key does not exist, returns the defaultValue
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        // This will print Sofoklis as there is a mapping for key 2
        System.out.println(namesMap.getOrDefault(2,"God"));

        // This will print God as there isn't a mapping for key 10
        System.out.println(namesMap.getOrDefault(10,"God"));

    }

    public static void keySet(){
        /* keySet()
         * returns all the keys that exist in this hashmap
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        // This will return all the keys that exist in the hashmap
        System.out.println("Keys in the hashmap:");
        namesMap.keySet().forEach(System.out::println);
        System.out.println();

        // This will filter all the keys > 1
        System.out.println("Mappings of keys with value > 1 in this map : ");
        namesMap.keySet().stream()
                .filter(k -> k > 1)
                .map(namesMap::get)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println();
    }

    public static void entrySet(){
        /* entrySet()
         * returns all the entries of the hashmap
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");

        // Traversing the entries before java 8
        for (Map.Entry entry : namesMap.entrySet()){
            //actions
        }
        System.out.println();

        // Traversing the entries - Java 8
        System.out.println("Entries in the hashmap:");
        namesMap.entrySet().forEach(System.out::println);
        System.out.println();

        // This will filter all the entries whose value starts with A and then return the key of these entries
        // and then print them
        System.out.println("Keys with value starting with A in this map : ");

        namesMap.entrySet().stream()
                .filter(x -> x.getValue().startsWith("A"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

    }

    public static void values(){
        /* values()
         * returns all the values as a collection
         */
        HashMap<Integer, String> namesMap = new HashMap<>();

        namesMap.put(1, "Sofoklis");
        namesMap.put(2, "Platonas");
        namesMap.put(3, "Aristotelis");
        namesMap.put(4, "Georgios");

        // Getting all the values as a Collection
        Collection<String> values = namesMap.values();

        //print all the values
        System.out.println("Values: ");
        values.forEach(System.out::println);
        System.out.println();

        // Note that if we put/remove an entry, the values collection will also be updated
        namesMap.remove(4);

        // values collection after removal of key 4
        System.out.println("Values after removal of key 4: ");
        values.forEach(System.out::println);

    }
}
