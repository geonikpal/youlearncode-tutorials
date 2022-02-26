public class StringCompare {
    public static void main(String[] args) {
        equals();
        System.out.println();
        compareTo();
    }


    static void equals(){
        String clh = "Code Learn Hub";
        String clhother = "Code Learn Hub";
        String clhNew  = new String("Code Learn Hub");

        System.out.println("clh == clhother? "+(clh == clhother));
        System.out.println("clh == clhNew? "+(clh == clhNew));
        System.out.println("clh.equals(clhother)? "+(clh.equals(clhother)));
        System.out.println("clh.equals(clhNew)? "+(clh.equals(clhNew)));
    }

    static void compareTo(){
        String clhMisspelled = "Code Learn Hab";
        String clh = "Code Learn Hub";
        String clhUpperCase = clh.toUpperCase();
        String clhMixedCase = "CodE LeaRn HUb";
        int codePointAtClh = clh.codePointAt(clh.length()-2);
        int codePointAtClhMisspelled = clhMisspelled.codePointAt(clh.length()-2);

        System.out.println("Codepoint value of \"Code Learn Hub\" first different character: "
                + codePointAtClh);
        System.out.println("Codepoint value of \"Code Learn Hab\" first different character: "
                + codePointAtClhMisspelled);
        System.out.println("Difference between them: "
                + String.valueOf(codePointAtClh-codePointAtClhMisspelled));
        System.out.println("\"Code Learn Hab\".compareTo(\"Code Learn Hab\") will return: "
                + clh.compareTo(clhMisspelled));

        System.out.println();

        System.out.println("\"Code Learn Hub\".compareTo(\"CODE LEARN HUB\") will return: "
                + clh.compareTo(clhUpperCase));
        System.out.println("\"Code Learn Hub\".compareToIgnoreCase(\"CODE LEARN HUB\") will return: "
                + clh.compareToIgnoreCase(clhUpperCase));
        System.out.println("\"Code Learn Hub\".compareToIgnoreCase(\"CodE LeaRn HUb\") will return: "
                + clh.compareToIgnoreCase(clhMixedCase));

    }

}
