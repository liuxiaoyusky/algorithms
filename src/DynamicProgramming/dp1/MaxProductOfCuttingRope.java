package DynamicProgramming.dp1;
/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
Assumptions
    n >= 2
Examples
    n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
 */

public class MaxProductOfCuttingRope {
    //at least one cut
    //use DP to find the longest for the rest
    public int maxProduct(int length) {
        //corner case
        if (length == 2) {
            return 1;
        }
        int [] memory = new int [length + 1];//let memory[k] stores the max for k length(could has no cut)
        memory[1] = 1;
        memory[2] = 2;

        //find max for i length with at least one cut
        for (int i = 3; i <= length; i++) {
            //one cut at j
            for (int j = 1; j <= i/2; j++) {
                memory[i] = Math.max(memory[i], memory[j] * memory[i - j]);
            }
            if(i == length) {
                return memory[i];
            }
            memory[i] = Math.max(memory[i], i);
        }

        return memory[length];
    }
}
