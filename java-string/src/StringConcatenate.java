public class StringConcatenate {

    public static void main(String[] args) {
        builder();
        System.out.println();
        concat();
        System.out.println();
        plusOperator();
    }

    static void builder(){
        String code = "Code";
        String learn = "Learn";
        String hub = "Hub";
        StringBuilder sb = new StringBuilder();
        String clh = sb.append(code).append(learn).append(hub).toString();
        System.out.println(clh);
    }

    static void concat(){
        String code = "Code";
        String learn = "Learn";
        String hub = "Hub";
        System.out.println(code.concat(learn).concat(hub));
    }

    static void plusOperator(){
        String code = "Code";
        String learn = "Learn";
        String hub = "Hub";
        System.out.println(code + learn + hub);
    }
}
