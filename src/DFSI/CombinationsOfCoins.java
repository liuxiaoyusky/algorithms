package DFSI;

import java.util.ArrayList;
import java.util.List;
/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments

    coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
    target - a non-negative integer representing the target number of cents, eg. 99

Assumptions

    coins is not null and is not empty, all the numbers in coins are positive
    target >= 0
    You have infinite number of coins for each of the denominations, you can pick any number of the coins.

Return

    a list of ways of combinations of coins to sum up to be target.
    each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.

Examples

coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
 */
public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<Integer> ();
        //corner case
        if (target < 0) {
            return ans;
        }

        combinationsHelper(target, coins, cur, 0, ans);
        return ans;
    }

    private void combinationsHelper(int target, int[] coins, List<Integer> cur, int index, List<List<Integer>> ans) {
        //base case
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                cur.add(target / coins[index]);
                //to save the result instead of a reference, we need to make a new copy
                ans.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }

        //follow the rules
        int num = target / coins[index];
        for (int i = num; i >= 0; i--) {
            cur.add(i);
            combinationsHelper(target - i * coins[index], coins, cur, index + 1, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
