package 刷题.贪心算法;
/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2



Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000


 */
public class JumpGameII45 {
    public int jumpI(int[] nums) {
        int [] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if (counts[i + j] == 0) {
                        counts[i + j] = Integer.MAX_VALUE;
                    }
                    counts[i + j] = Math.min(counts[i + j], counts[i] + 1);
                }
            }
        }
        return counts[counts.length - 1];
    }

    //update, since we don't need to know how to reach current location,
    // I just need to know the most far away place I can reach
    //eg: at i, I can reach next k location in 1 step, at i + 1, step ++
    // for i + 1 to i+k, discover most far away location j that I can reach, at i + k, step++
    //if j > end, return current step + 1
    public int jump(int[] nums) {
        //corner case
        if (nums.length < 2) {
            return 0;
        }
        int step = 0;
        int curRange = 0;
        int maxRange = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //base case
            if (maxRange >= nums.length - 1) {
                return step + 1;
            }

            //beyond the furtherest location for this step
            if (i > curRange) {
                step++;
                curRange = maxRange;
            }

            //general case
            maxRange = Math.max(i + nums[i], maxRange);
        }
        return -1;
    }
}
