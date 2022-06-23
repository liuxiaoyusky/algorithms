package 刷题.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
 */
public class combination {
    //input: two int n,k
    //output: list of int list
    //clarification: 1 <= n <= 20, 1 <= k <= n
    //pick only after i so we can avoid same element
    //for each value i in [1,n], they can be in or out,when totally k elements in,
    // put them in a list and save, and go to [i + 1, n], and for each element, they can be in or out
    public List<List<Integer>> combine(int n, int k) {
        Integer [] curCombination = new Integer[k];
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, 0, 1, curCombination, ans);
        return ans;
    }

    private void helper(int n, int k, int index, int curValue, Integer [] curCombination, List<List<Integer>> ans) {
        //base case
        if (index == k) {
            //Arrays.asList(curCombination) is modifiable
            //List.of() is immutable
            ans.add(List.of(curCombination));
            return;
        }

        //corner case
        if (curValue > n) {
            return;
        }

        //general case, there are (k - index) space to fill in
        for (int i = curValue; i <= n - (k - index) + 1; i++) {
            curCombination[index] = i;
            helper(n, k, index + 1, i + 1, curCombination, ans);
        }
    }
}
