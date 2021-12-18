public class BMI {

    public static void main(String[] args) {
        // In meters
        double height = 1.70;
        // In kilograms
        double weight = 60;
        printBMIResultOptimized(height, weight);
        height = 1.75;
        weight = 45;
        printBMIResultOptimized(height, weight);
        height = 2.00;
        weight = 250;
        printBMIResultOptimized(height, weight);
        height = 1.79;
        weight = 84;
        printBMIResultOptimized(height, weight);
    }

    private static void printBMIResultOptimized(double height, double weight){
        double BMI = weight/Math.pow(height,2);
        System.out.println("The Height is: "+ height + " and the Weight is: "+weight);
        System.out.print("This person is: ");
        if(BMI < 16)
            System.out.println("Underweight (Severe thinness)");
        else if (BMI < 17)
            System.out.println("Underweight (Moderate thinness)");
        else if (BMI < 18.5)
            System.out.println("Underweight (Mild thinness)");
        else if (BMI < 24.9)
            System.out.println("Normal Range");
        else if (BMI < 29.9)
            System.out.println("Overweight (Pre-obese)");
        else if (BMI < 34.9)
            System.out.println("Obese (Class I)");
        else if (BMI < 39.9)
            System.out.println("Obese (Class II)");
        else
            System.out.println("Obese (Class III)");
    }

    private static void printBMIResultNotOptimized(double height, double weight){

        // The formula for BMI is weight / height^2
        double BMI = weight/Math.pow(height,2);
        System.out.println("The Height is: "+ height + " and the Weight is: "+weight);
        System.out.print("This person is: ");
        if(BMI < 16)
            System.out.println("Underweight (Severe thinness)");
        else if (BMI >= 16 && BMI < 17)
            System.out.println("Underweight (Moderate thinness)\t");
        else if (BMI >= 17 && BMI < 18.5)
            System.out.println("Underweight (Mild thinness)\t");
        else if (BMI >= 18.5 && BMI < 24.9)
            System.out.println("Normal Range");
        else if (BMI >= 24.9 && BMI < 29.9)
            System.out.println("Overweight (Pre-obese)");
        else if (BMI >= 29.9 && BMI < 34.9)
            System.out.println("Obese (Class I)");
        else if (BMI >= 34.9 && BMI < 39.9)
            System.out.println("Obese (Class II)");
        else if (BMI >= 39.9)
            System.out.println("Obese (Class III)");
    }


}
