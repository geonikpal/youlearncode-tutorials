import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CountWords {

    public static final String SENTENCES = "I met an interesting turtle while the song on the radio blasted away." +
            "He loved eating his bananas in hot dog buns." +
            "I'm not a party animal, but I do like animal parties." +
            "The ice-cream trucks bring back bad memories for all of us." +
            "The bug was having an excellent day until he hit the windshield." +
            "I trust everything that's written in purple ink." +
            "If you really strain your ears, you can just about hear the sound of no one giving a damn." +
            "We have a lot of rain in June." +
            "He stomped on his fruit loops and thus became a cereal killer." +
            "This made him feel like an old-style rootbeer float smells.";

    public static void main(String[] args) {
        printWordsMap(SENTENCES);
    }


    public static void printWordsMap(String sentences){

        // replacing punctuation marks with spaces as we don't want them to count as words, and then make every word lowercase
        sentences = sentences.replaceAll("[.,!?]"," ").toLowerCase();

        //split by space
        List<String> words = Arrays.asList(sentences.split("\\s"));

        //remove any space that might exist
        words = words.stream()
                .map(word -> word.replace(" ",""))
                .filter(word -> !word.equals(""))
                .collect(Collectors.toList());

        //The map that we'll use
        HashMap<String, Integer> wordsMap = new HashMap<>();

        words.forEach(word -> {

            //Before java 8

            //if(wordsMap.containsKey(word))
            //    wordsMap.replace(word, wordsMap.get(word) + 1);
            //else
            //    wordsMap.put(word,1);

            //using the getOrDefault
            //wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);

            //using merge
            wordsMap.merge(word,1, Integer::sum);

        });

        // Sort by value
        List <Map.Entry <String, Integer>> entries = new ArrayList<>(wordsMap.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        //Print the result
        entries.forEach(entry -> System.out.println("The word \"" + entry.getKey() + "\" occurred " + entry.getValue() + " times"));

    }
}
