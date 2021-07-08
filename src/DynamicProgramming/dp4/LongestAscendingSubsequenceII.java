package DynamicProgramming.dp4;
/*
Given an array A[0]...A[n-1] of integers, find out the longest ascending subsequence. If there are multiple results, then return any valid result.

Assumptions

    A is not null

Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: [2,3,4,5]
Because [2, 3, 4, 5] is one of the longest ascending subsequences.
 */
public class LongestAscendingSubsequenceII {
    //naive solution: find all conbinations of subsequence and then select the longest ascending one
    // prune rule: if a[i] >= a[i + 1],stop and return the current length, and find max;
    //for each index, compare the length with our without the current char

    //dp way
    //we have an array to mentain the length of longest ascending including current char;
    // and an array to mentain the index of previous character
    //for each location, campare with each previous loc to find max and update index
    public int[] longest(int[] array) {
        // corner case
        if (array == null || array.length == 0) {
            return new int [0];
        }

        //track
        int [] length = new int [array.length];
        int [] index = new int [array.length];
        int last_character_index = 0;
        int max_length = 1;

        for (int i = 0; i < array.length; i++) {
            //base case
            length[i] = 1;
            index[i] = -1;
            //campare value of i with each value before i
            for (int j = 0; j < i; j++) {
                //find the longest ascending with current char
                if(array[i] > array[j]) {
                    int cur_length = length[j] + 1;
                    if (cur_length > length[i]) {
                        length[i] = cur_length;
                        index[i] = j;
                    }
                }
            }
            //try update max
            if (length[i] > max_length) {
                max_length = length[i];
                last_character_index = i;
            }
        }

        //constract the longest subsequence
        int [] ans = new int [max_length];
        int cur_length = max_length;
        int cur_index = last_character_index;
        while (cur_length > 0) {
            ans[--cur_length] = array[cur_index];
            cur_index = index[cur_index];
        }


        return ans;
    }
}
