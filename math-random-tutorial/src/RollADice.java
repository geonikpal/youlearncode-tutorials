import java.util.Scanner;

public class RollADice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose number of times to roll a dice");
        int number = scanner.nextInt();
        for (int i = 0;i < number; i++){
            System.out.println(getRandomIntInclusive(1,6));
        }
        System.out.println("Choose number of times to toss a coin");
        number = scanner.nextInt();
        for (int i = 0; i < number; i++){
            System.out.println(getCoinToss());
        }

    }
    // The method in the previous example
    public static int getRandomIntInclusive(double lowerLimit, double upperLimit){
        return (int)(lowerLimit + Math.random() * (upperLimit - lowerLimit + 1));
    }
    // To simulate a coin toss, get a random integer in [0, 1], and if it is 0, return Heads, else, return Tails
    public static String getCoinToss(){
        int result = getRandomIntInclusive(0,1);
        if(result == 0)
            return "Heads";
        else
            return "Tails";

    }

}
