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

        System.out.println("Score of clhMisspelled "+ clhMisspelled.codePoints().sum());
        System.out.println("Score of clh "+ clh.codePoints().sum());
        System.out.println("Score of clhUpperCase "+ clhUpperCase.codePoints().sum());
        System.out.println();
        System.out.println("compareTo clh and clhUpperCase "+clh.compareTo(clhMisspelled));
        System.out.println("compareToIgnoreCase clh and clhUpperCase "+clh.compareToIgnoreCase(clhUpperCase));
    }
}
