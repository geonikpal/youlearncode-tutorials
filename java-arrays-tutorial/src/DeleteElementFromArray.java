
public class DeleteElementFromArray {

    public static void main(String[] args) {

        String [] names = new String [] {"Akis", "Giorgos", "Nikos", "Giannis"};

        System.out.println("Array before any action:");
        printArray(names);

        // Delete at index 2
        names = deleteElement(names,2);

        System.out.println("Array after deletion of index 2:");
        printArray(names);

        // Delete at index 2 again
        names = deleteElement(names,5);

        System.out.println("Array after deletion of index 2:");
        printArray(names);

    }

    public static String[] deleteElement( String[] array, int index){

        if( index<0 || index >= array.length)
            throw new IllegalArgumentException("Index given is incorrect");
        //To completely delete an element from an array,
        // you can create a new array with size
        // equal to the array given minus 1 (since it will contain one less element)
        String [] arrayCopy = new String[array.length-1];
        // Then traverse through the old array and copy only the wanted elements
        for (int i = 0,j = 0; i < array.length ; i++,j++) {
            //If i equals the index of deletion,
            // do not assign a value,
            // and subtract the index of copyArray
            // so the two indices match
            // (i and j)
            if(i == index){
                j--;
            }
            // This element should be copies, as we do not want to delete it
            else {
                arrayCopy[j] = array[i];
            }
        }
        return arrayCopy;
    }

    public static void printArray(String[] array){

        for (int i = 0; i <array.length ; i++)
            System.out.println("Index : " + i + ", Element: "+array[i]);
        System.out.println();
    }

}
