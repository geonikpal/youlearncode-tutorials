public class ExampleLabeledNestedLoops {
    public static void main(String[] args) {
        nestedUnlabeledLoop();
        System.out.println("********************************************");
        nestedLabeledLoop();
    }

    /* When in an inner group, breaking/continuing affects the inner loop only*/
    public static void nestedUnlabeledLoop() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1) {
                    System.out.println("nestedUnlabeledLoop: Skipping i = " + i);
                    break;
                }
                System.out.println("nestedUnlabeledLoop: "+ i + " " + j);
            }
            System.out.println("-----");
        }
        System.out.println("nestedUnlabeledLoop: Loops are finished!");
    }

    /* With labels, we can specify which loop to break/continue*/
    public static void nestedLabeledLoop() {
       outerLoop: for(int i = 0; i < 10; i++) {
           innerLoop: for(int j = 0; j < 3; j++) {
                if(i == 1) {
                    System.out.println("nestedLabeledLoop: Skipping unlabeled i = " + i);
                    break;
                }
               if(i == 4) {
                   System.out.println("nestedLabeledLoop: Skipping labeled i = " + i);
                   break innerLoop; // same as unlabeled case
               }
                if(i == 6) {
                    System.out.println("nestedLabeledLoop: Exitting at i = " + i);
                    break outerLoop;
                }
                System.out.println("nestedLabeledLoop: " + i + " " + j);
            }
            System.out.println("-----");
        }
        System.out.println("nestedLabeledLoop: Loops are finished!");
    }
}
