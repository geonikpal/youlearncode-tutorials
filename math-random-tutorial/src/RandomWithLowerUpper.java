public class RandomWithLowerUpper {
    public static void main(String[] args) {
        // Get a random number between 1 and a number less than 100
        double a = 1 + Math.random()*(100 - 1);
        System.out.println(a);
        // Get a random number between 42.5 and a number less than 57.2
        double b = 42.5 + Math.random()*(57.2 - 42.5);
        // print the result
        System.out.println(b);
        //The lower and upper limit can be adjusted according to the following formula:
        // double x = lowerLimit + Math.random()*(upperLimit - lowerLimit)  returns a number in [lowerLimit, upperLimit)
        double lowerLimit = 1000;
        double upperLimit = 1100;
        System.out.printf("A random double in [%f, %f) : %f \n",lowerLimit,upperLimit,getRandomDoubleExclusive(lowerLimit,upperLimit));
        System.out.printf("A random integer in [%f, %f) : %d \n",lowerLimit,upperLimit,getRandomIntExclusive(lowerLimit,upperLimit));

        // To include the upper limit for integers, the formula is:
        // int x = lowerLimit + Math.random()*(upperLimit - lowerLimit + 1)  returns a number in [lowerLimit, upperLimit]
        lowerLimit = 1340;
        upperLimit = 1350;

        System.out.printf("A random integer in [%f, %f] : %d \n",lowerLimit,upperLimit,getRandomIntInclusive(lowerLimit,upperLimit));

    }

    public static double getRandomDoubleExclusive(double lowerLimit, double upperLimit){
        return lowerLimit + Math.random() * (upperLimit - lowerLimit);
    }

    public static int getRandomIntExclusive(double lowerLimit, double upperLimit){
        return (int)(lowerLimit + Math.random() * (upperLimit - lowerLimit));
    }

    public static int getRandomIntInclusive(double lowerLimit, double upperLimit){
        return (int)(lowerLimit + Math.random() * (upperLimit - lowerLimit + 1));
    }

}
