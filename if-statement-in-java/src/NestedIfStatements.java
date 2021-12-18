public class NestedIfStatements {

    public static void main(String[] args) {

        nestedIfsTable(true,true,false);

        nestedIfsTable(true, false , false);

        nestedIfsTable(true, false , true);
    }

    private static void nestedIfsTable(boolean isBlack, boolean isBroken, Boolean isOld){

        if(isBlack){
            if(isBroken){
                if(!isOld)
                    System.out.println("Table is Black, Broken and Old");
                else
                    System.out.println("Table is Black, Broken but not Old");
            }
            else {
                System.out.println("Table is Black and not Broken");
            }
        }
    }


}
