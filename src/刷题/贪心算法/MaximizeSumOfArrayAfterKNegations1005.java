package 刷题.贪心算法;

import java.util.Arrays;

/*
Given an integer array nums and an integer k, modify the array in the following way:

    choose an index i and replace nums[i] with -nums[i].

You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.



Example 1:
Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].

Example 2:
Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

Example 3:
Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].


Constraints:
    1 <= nums.length <= 104
    -100 <= nums[i] <= 100
    1 <= k <= 104

 */
public class MaximizeSumOfArrayAfterKNegations1005 {
    //input: int [] array, int k
    //output: int sum after negation

    //Three cases:
    // 1: more than k elements of negative number -> negate k negative number
    // 2: less negative numbers, has to negate positive -> i - 1 is negative and i is non-positive
    //2.1 even number left -> skip
    //2.2 odd number left -> pick smaller absolute value between i - 1 and i and make it negative
    public int largestSumAfterKNegationsII (int [] nums, int k) {
        Arrays.sort(nums);

        //negate first k negative numbers
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = - nums[i];
                k--;
            } else {
                break;
            }
        }

        //if count != k, find one to make it negative
        k = k % 2;
        if (k == 0) {
            return calSum(nums);
        } else {
            //corner case: i == 0 || i == nums.length
            int smaller = 0;
            if (i == 0) {
                smaller = nums[0];
            } else if (i == nums.length) {
                smaller = nums[nums.length -1];
            } else {
                smaller = Math.min(nums[i - 1], nums[i]);
            }
            return calSum(nums) - 2 * smaller;
        }
    }

    private int calSum(int [] nums) {
        int sum = 0;
        for (int cur: nums) {
            sum += cur;
        }
        return sum;
    }


    //update-------------------------------------------
    //sort the input array
    //flip the left most integer and resort it, do this k times
    public int largestSumAfterKNegationsI (int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            nums[0] = - nums[0];
            int left = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[left] > nums[j]) {
                    swap(nums, left, j);
                    left = j;
                } else {
                    break;
                }
            }
        }

        return calSum(nums);
    }

    private void swap(int [] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
