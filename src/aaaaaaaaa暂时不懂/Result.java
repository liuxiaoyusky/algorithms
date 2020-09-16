package aaaaaaaaa暂时不懂;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;



class Result {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER k
     */
    //input: in memory unsorted list with duplicated, n >= 2; k >= 0
    //output: count that all unique pairs that difference is k
    public static int countPairs(List<Integer> numbers, int k) {
        //keep track of uniqued viewed int
        int n = numbers.size();
        Set<Integer> set = new HashSet<>();
        Collections.sort(numbers);
        set.add(numbers.get(0));
        int count = 0;
        for (int i = 1; i < n; i++) {
            int cur = numbers.get(i);
            if (set.contains(cur - k) || set.contains(cur + k)) {
                count++;
            }
            set.add(i);
            while (i < (n - 1) && cur == numbers.get(i + 1)) {
                i++;
            }
        }
        return count;
    }

}

