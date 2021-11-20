import java.util.HashMap;

public class HashMapModify {

    public static void main(String[] args) {

        System.out.println("replace()");
        replace();
        System.out.println();

        System.out.println("replaceWithOldValue()");
        replaceWithOldValue();
        System.out.println();

        System.out.println("replaceAll()");
        replaceAll();
        System.out.println();

        System.out.println("compute()");
        compute();
        System.out.println();

        System.out.println("computeIfPresent()");
        computeIfPresent();
        System.out.println();

        System.out.println("computeIfAbsent()");
        computeIfAbsent();
        System.out.println();

        System.out.println("merge()");
        merge();
        System.out.println();

    }


    public static void replace(){

        /* replace( K key, V value)
         * This method replaces the value provided a specific
         * key is given, and then returns the new value
         */
        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");

        // Let's replace Toyota with Lexus
        carsBrandsMap.replace(2, "Lexus");

        //print the result
        System.out.println("Printing after replace:");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // Let's try to replace a key that isn't in the hashmap
        // this will return null
        String mercedes = carsBrandsMap.replace(5,"Mercedes");

        System.out.println(mercedes);

    }

    public static void replaceWithOldValue(){

        /* replace( K key, V oldValue, V newValue)
         * This method replaces the value provided a specific
         * key is given, but only if the mapping
         */
        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // Let's replace Toyota with Lexus
        System.out.println("Replacing Toyota with Lexus:");
        System.out.println();
        boolean done = carsBrandsMap.replace(2, "Toyota","Lexus");

        System.out.println("Was it successful? "+done);
        System.out.println();

        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        //What if we want to replace Opel, but we make a mistake
        done = carsBrandsMap.replace(3,"Opal","Lamborghini");
        System.out.println("Was it successful? "+done);
        System.out.println();

        //print the result
        System.out.println("After trying to replace Opel with a typo, with Lamborghini:");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

    }

    public static void replaceAll(){

        /* replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
         * This method replaces all the mappings based on the Bifunction
         * provided as a Parameter
         *
         */
        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // Let's say we want to replace the brands with the brand provided + a specific model
        // It accepts the key and the value of the specific entry as parameters and returns the new value
        carsBrandsMap.replaceAll( (key ,value) ->
        {
            switch (value){
                case "BMW" :
                    return value.concat(" M3 GTR");
                case "Toyota" :
                    return value.concat(" Supra");
                case "Opel" :
                    return value.concat(" Astra");
                default :
                    return value;
            }
        });

        // print the result
        System.out.println("HashMap after replaceAll:");
        carsBrandsMap.entrySet().forEach(System.out::println);

    }

    public static void computeIfPresent(){

        // To avoid the null pointer exception to compute() you can use
        /* computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> function)
         * This method can change the value, provided a key and
         * by using a function which accepts the key and the value
         * and returns the new value.
         * This will happen only if the key exists and it is not null
         */
        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");
        carsBrandsMap.put(4, null);

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // This will not produce npe and it will do nothing
        carsBrandsMap.computeIfPresent(4, (key ,value) -> value.concat(" Gallardo"));

        // This will also do nothing as key 8 does not exist
        carsBrandsMap.computeIfPresent(8, (key ,value) -> value.concat(" Gallardo"));

        System.out.println("Printing the entries after computeIfPresent:");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // adding a dot after each value
        //This will not produce NPE as the null value will be ignored
        carsBrandsMap.keySet()
                .forEach(key ->  carsBrandsMap.computeIfPresent(key, (k, v) -> v.concat(".")));

        // printing after adding a dot to each entry
        System.out.println("HashMap after adding a dot to the end for each value");
        carsBrandsMap.entrySet().forEach(System.out::println);

    }

    public static void computeIfAbsent(){

        /* computeIfAbsent(K key, Function<? super K, ? extends V> function)
         * This method can change the value, provided a specific key and
         * by using a function which accepts the key
         * and returns the new value.
         * This will happen only if the key is null or it doesn't exist.
         */

        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");
        carsBrandsMap.put(4, null);
        carsBrandsMap.put(5, null);
        carsBrandsMap.put(7, null);

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // This will add a new entry 6 -> Ferrari
        carsBrandsMap.computeIfAbsent(6, key -> carsBrandsMap.put(key,"Ferrari"));

        // This will do nothing, as there is already an entry with key 6
        carsBrandsMap.computeIfAbsent(6, key -> carsBrandsMap.put(key,"VW"));

        // This will put the value Honda, for every key that maps to a null value
        carsBrandsMap.keySet()
                .forEach(key ->  carsBrandsMap.computeIfAbsent(key, k -> carsBrandsMap.put(k, "Honda") ));

        System.out.println("Map after computeIfAbsent");
        carsBrandsMap.entrySet().forEach(System.out::println);

    }

    public static void compute(){

        /* compute(K key, BiFunction<? super K, ? super V, ? extends V> function)
         * This method can change the value, provided a key and
         * by using a function which accepts the key and the value
         * and returns the new value
         */
        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // Let's say we want to replace only Toyota with the Brand Name + the model name
        // The compute method accepts the key and a function which will use the this specific key
        carsBrandsMap.compute(2, (key ,value) -> value.concat(" Corolla"));

        // print the result
        System.out.println("HashMap after compute:");
        carsBrandsMap.entrySet().forEach(System.out::println);

        //Everything worked fine, only the entry with key 2 was affected, but what if the value was null?
        carsBrandsMap.put(4,null);

        try {

            System.out.println();
            System.out.println("Trying to compute with null value...");

            //this will produce NullPointerException
            carsBrandsMap.compute(4, (key ,value) -> value.concat(" Gallardo"));
            System.out.println();

        }
        catch (NullPointerException exception){

            System.out.println("You should have used another method or check if null");
            System.out.println();
            try {
                // try to compute for a key that does not exist, will also produce NPE
                System.out.println("Trying to compute with a key that does not exist...");
                carsBrandsMap.compute(8, (key ,value) -> value.concat(" Gallardo"));
            }
            catch (NullPointerException e){
                System.out.println("You should have used another method or check if null");
                System.out.println();
            }
        }
    }

    public static void merge(){

        /* merge(K key,V value, BiFunction<? super V, ? super V, ? extends V> function)
         * The merge method accepts the key, the value to be associated with the old value and
         * a function which accepts the old Value,
         * the value given as the 2nd parameter in the merge method
         * and returns the result
         */

        HashMap<Integer, String> carsBrandsMap = new HashMap<>();
        carsBrandsMap.put(1, "BMW");
        carsBrandsMap.put(2, "Toyota");
        carsBrandsMap.put(3, "Opel");

        System.out.println();
        System.out.println("Initial HashMap: ");
        carsBrandsMap.entrySet().forEach(System.out::println);
        System.out.println();

        // Let's say we want to add the model only for Toyota

        //This
        carsBrandsMap.merge(2," Corolla",String::concat);

        // is the same as this
        //carsBrandsMap.merge(2," Corolla",(val,newVal) -> val.concat(newVal));

        // print the result
        System.out.println("HashMap after merging:");
        carsBrandsMap.entrySet().forEach(System.out::println);

    }




}
