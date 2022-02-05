public class StringSplit {
    public static void main(String[] args) {
        split();
        System.out.println();
        splitTwoParams();
    }


    static void split(){
        // Simple String with commas
        String namesString = "Georgios,Nikolaos,Ioannis,Dimitris";
        String[] namesArray  = namesString.split(",");
        for(String name : namesArray)
            System.out.println(name);
        System.out.println();

        //Regex that matches a number between 0 and 9
        String countriesString = "Greece3USA6UK9";
        String[] countriesArray  = countriesString.split("[0-9]");
        for(String country : countriesArray)
            System.out.println(country);

        //Escape regex
        countriesString = "Greece.USA.UK";
        countriesArray  = countriesString.split("\\.");
        for(String country : countriesArray)
            System.out.println(country);
    }


    static void splitTwoParams(){
        String clh = "Code;Learn;Hub;is;the;Best";
        String[] clhSplitted = clh.split(";", 3);
        for(String word : clhSplitted)
            System.out.println(word);
        clhSplitted = clh.split(";", -2);
        for(String word : clhSplitted)
            System.out.println(word);
    }
}
