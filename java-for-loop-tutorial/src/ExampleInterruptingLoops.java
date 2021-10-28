public class ExampleInterruptingLoops {
    public static void main(String[] args) {
        breakLoop();
        System.out.println("-------------------------------------------");
        continueLoop();
        System.out.println("-------------------------------------------");
        returnLoop();
    }

    /* When breaking a loop, no other statements in the loop will be executed*/
    public static void breakLoop() {
        for(int i = 0; i < 10; i++) {
            if(i == 5) {
                System.out.println("breakLoop: Breaking the loop");
                break;
            }
            System.out.println("breakLoop: My number is " + i);
        }
        System.out.println("breakLoop: I will be executed after loop ends!");
    }

    // When continuing a loop, the statements of the loop's current iteration will not be executed
    public static void continueLoop() {
        for(int i = 0; i < 10; i++) {
            if(i == 5) {
                System.out.println("continueLoop: Continuing the loop, I hate number 5...");
                continue;
            }
            System.out.println("continueLoop: My number is " + i);
        }
        System.out.println("continueLoop: I will be executed after loop ends!");
    }

    // When returning in a loop, execution of the methods stops at that point.
    public static void returnLoop() {
        for(int i = 0; i < 10; i++) {
            if(i == 5) {
                System.out.println("returnLoop: Number 5? Time to leave...");
                return; // if the method returns a type (e.g. int), we have to return a value of the type (e.g return -1;)
            }
            System.out.println("returnLoop: My number is " + i);
        }
        System.out.println("returnLoop: I hope will be executed after loop ends...");
    }
}
