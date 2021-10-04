package GoogleOA;
/*
you are given an integer array arr. From some starting index, you can make a series of Jumsp.
The first,3rd,5th,... jumps are odd jumps. Others are even jumps.
Note the jumps are numbered, not the indices.

You may jump forward from index i to index j (i < j) if:
Odd jumps:
1. arr[i] <= array[j]  2. arr[j] < all other numbers after i.
2. arr[i] >= array[j] 2. arr[j] > all other numbers after i.
if same value, jump to j instead of j + k for k > 0

It may be the case that for some index i, no legal jumps.
 */

public class OddEvenJump {
    //
    public static int OddEvenJump(int A){
        int minDiff = Integer.MAX_VALUE;

        int curNum = 10;
        return curNum;
    }
}
