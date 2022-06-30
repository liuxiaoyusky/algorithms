package 刷题.数组;

/*
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of
which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:
    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which
the time complexity is O(n log(n)).
 */
public class MinmumSizeSubarraySum209 {
    //input: int [] nums
    //output: int, length of smallest subArray
    //[i,j) sliding windows, when sum[i,j) < target, j++; when sum[i,j) >= target, update result, i++
    public int minSubArrayLen(int target, int[] nums) {
        //given nums[i].length >= 1

        //corner case
        if (nums == null) {
            return 0;
        }

        int left = 0;//i: next value to delete
        int right = 0;//j: next value to add on right
        int sum = 0;
        int length = 0;
        while (right < nums.length || sum >= target) {
            if (sum < target) {
                sum += nums[right++];
            } else {
                //update length
                //corner case, first length
                int newLength = right - left;
                if (length == 0) {
                    length = newLength;
                }
                //general case
                else {
                    length = Math.min(length, newLength);
                }

                //move left bound of sliding window
                sum -= nums[left++];
            }
        }

        return length;
    }
}
