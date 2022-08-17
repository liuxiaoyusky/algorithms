package DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.


Assumptions

There could be duplicate characters in the original set.

​

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].
 */
public class allSubsetsIIOfSizeK {
    //assume with duplicate letters but dedup answer
    //sort set first, two pointers, slow and fast
    // [0,slow-1] is the answer
    // [fast,] candidates
    // [slow,fast] duplicate subsets, useless in permutation
    public List<String> subSetsIIOfSizeK(String set, int k) {
        List<String> ans = new ArrayList<>();
        char [] array = set.toCharArray();
        Arrays.sort(array);
        helper(array, 0, 0, k, ans);
        return ans;
    }

    private void helper(char [] array, int cur, int next, int k, List<String> ans) {
        //base case
        if (cur == k) {
            ans.add(new String(array, 0, k));
            return;
        }

        for (int i = next; i < array.length; i++) {
            swap(array, cur, i);
            helper(array, cur + 1, i + 1, k, ans);

            //bracktrack
            swap(array, cur, i);

            //avoid same letter in this round
            while (i + 1 < array.length && array[i] == array[i + 1]) {
                i++;
            }


        }
    }


    private void swap(char [] array, int a, int b){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
