import java.util.Arrays;

public class QuestionsAboutArrays {


    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, -5};
        printArray(numbers);
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }



    private static int[] addOneAndReturn(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
        return array;
    }

    private static void printArray(int[] numbers){
        for(int i : numbers){
            System.out.print(i+" ");
        }
    }
}
