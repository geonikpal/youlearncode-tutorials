import java.util.Arrays;

public class StringConversions {
    public static void main(String[] args) {
        intToString();
        System.out.println();
        stringToInt();
        System.out.println();
        stringToCharArray();
    }


    static void intToString(){
        String a = String.valueOf(5);
        String b = Integer.toString(15);
    }

    static void stringToInt(){
        // Parsing numbers
        int a = Integer.parseInt("5");
        int b = Integer.valueOf("10");
        //This works
        int c = Integer.parseInt("05");
        // The following will produce NumberFormatException
        try {
            int d = Integer.parseInt("05.2");
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

        try {
            int d = Integer.parseInt("5.2s");
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        try {
            int d = Integer.parseInt("Hello");
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    static void stringToCharArray(){
        String clh = "CodeLearnHub";
        char[] array = clh.toCharArray();
        //sort the string
        Arrays.sort(array);
        StringBuilder builder = new StringBuilder();
        for (char c : array)
            builder.append(c);
        clh = builder.toString();
        System.out.println(clh);
    }
}
