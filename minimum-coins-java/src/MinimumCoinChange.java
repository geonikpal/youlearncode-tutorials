
import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumCoinChange {


    public static int minCoinsDynamic(int[] coins, int value) {

        // minCoinsForValue[v] will contain the minimum coins needed for value v
        int[] minCoinsForValue = new int[value + 1];

        //Fill all entries 1...length - 1 with a very high balue
        Arrays.fill(minCoinsForValue, 1, minCoinsForValue.length, Integer.MAX_VALUE);

        //Find the minimumNumber of coins for all values <= target value
        for (int currentValue = 1; currentValue <= value; currentValue++) {
            for (int coinValue : coins) {
                //Pick only the coins that we might lead to a solution
                if (coinValue <= currentValue) {

                    int minCoinsForValueMinusCoin = minCoinsForValue[currentValue - coinValue];

                    // This check is in order not to have underflow
                    if (minCoinsForValueMinusCoin != Integer.MAX_VALUE) {

                        //e.g. for value 5 and coin 2, minCoinsForValue[5] = 1 + minCoinsValue[5 - 2]
                        //which means we pick a coin 2 and the optimal solution for achieving value 3
                        int possibleMinCoins = 1 + minCoinsForValueMinusCoin;
                        //Update the minimum
                        minCoinsForValue[currentValue] = Math.min(
                                minCoinsForValue[currentValue],
                                possibleMinCoins
                        );
                    }
                }
            }
        }

        if (minCoinsForValue[value] == Integer.MAX_VALUE)
            return -1;

        return minCoinsForValue[value];
    }

    public static int minCoinsDynamicLambda(int[] coins, int value) {

        // minCoinsForValue[v] will contain the minimum coins needed for value v
        int[] minCoinsForValue = new int[value + 1];

        //Fill all entries 1...length - 1 with a very high balue
        Arrays.fill(minCoinsForValue, 1, minCoinsForValue.length, Integer.MAX_VALUE);

        //Find the minimumNumber of coins for all values <= target value
        IntStream.range(1, value + 1).forEach(currentValue -> {
            final int copyOfCurrentValue = currentValue;
            Arrays
                    .stream(coins)
                    .filter(coin -> coin <= copyOfCurrentValue)
                    .map(coin -> minCoinsForValue[copyOfCurrentValue - coin])
                    .filter(minCoinsForValueMinusCoin -> minCoinsForValueMinusCoin != Integer.MAX_VALUE)
                    .forEach(minCoinsForValueMinusCoin -> {
                        //e.g. for value 5 and coin 2, minCoinsForValue[5] = 1 + minCoinsValue[5 - 2]
                        //which means we pick a coin 2 and the optimal solution for achieving value 3
                        int possibleMinCoins = 1 + minCoinsForValueMinusCoin;
                        //Update the minimum
                        minCoinsForValue[copyOfCurrentValue] = Math.min(
                                minCoinsForValue[copyOfCurrentValue],
                                possibleMinCoins
                        );
                    });
        });

        if (minCoinsForValue[value] == Integer.MAX_VALUE)
            return -1;

        return minCoinsForValue[value];
    }

    public static int minCoinsBruteForce(int[] coins, int value) {

        //If value is 0, minimum number of coins are zero
        if(value == 0){
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        // We will try all coins
        for (int coin : coins) {
            //We only care for coins <= value
            if (coin <= value) {

                int valueIfWeChooseCoin = value - coin;
                //We have not found the solution yet
                if (valueIfWeChooseCoin == 0) {
                    // No more subproblems to solve
                    return 1;
                } else if (valueIfWeChooseCoin > 0) {
                    //The solution will be equal to
                    // the number of coins required to achieve
                    // value = value - coin + 1(which is the coin that we chose)
                    int resultForSubproblem = minCoinsBruteForce(coins, valueIfWeChooseCoin);
                    //We do not want to consider solutions that are not solutions(MAX VALUE or -1)
                    if (resultForSubproblem != Integer.MAX_VALUE && resultForSubproblem != -1) {
                        int possibleMinCoins = resultForSubproblem + 1;
                        //Compare the solution we found with the best solution until now
                        minCoins = Math.min(minCoins, possibleMinCoins);
                    }
                }
            }
        }

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }


}


