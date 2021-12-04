import java.util.HashMap;
import java.util.Map;

public class IterateAMap {

    public static void main(String[] args) {
        forEach();
        enhancedForLoop();
    }


    public static void forEach(){

        Map<String, String> countries = new HashMap<>();
        countries.put("Greece", "Europe");
        countries.put("Spain", "Europe");
        countries.put("Algeria", "Africa");
        countries.put("USA", "North America");
        countries.put("Brazil", "South America");

        countries.forEach((key, value) -> {
            //actions
            countries.replace("USA", "NA");
        });

        //Another way to iterate a map using forEach, is through entrySet() method
        // But this forEach applies to a set, not a map

        //Simplest way to print the whole map
        countries.entrySet().forEach(System.out::println);

        //Doing actions for each entry, by using Map.Entry inner class
        countries.entrySet().forEach(entry -> {
            //actions e.g.
        });

        System.out.println();
    }

    public static void enhancedForLoop(){

        Map<String, String> countries = new HashMap<>();
        countries.put("Greece", "Europe");
        countries.put("Spain", "Europe");
        countries.put("Algeria", "Africa");
        countries.put("USA", "North America");
        countries.put("Brazil", "South America");

        for(Map.Entry<String, String> entry : countries.entrySet()){
            //Actions
        }

        //Or you can use just the keyset method
        for(String key : countries.keySet()){
            //Actions, now using the key instead of entry
        }

        // Print the map
        for(Map.Entry<String, String> entry : countries.entrySet()){
            System.out.println(entry);
        }
    }
}
