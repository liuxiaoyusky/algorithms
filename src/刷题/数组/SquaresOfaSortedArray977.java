package 刷题.数组;
/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial,
 could you find an O(n) solution using a different approach?
 */
public class SquaresOfaSortedArray977 {
    //input: sorted int []
    //output: sorted int squared []
    //two pointer: left, right to figure out which one is larger after square,
    //put the squared value from right to left in helper array
    public int [] sortedSquares(int [] nums) {
        int [] helper = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (index >= 0) {
            int sqLeft = nums[left] * nums[left];
            int sqRight = nums[right] * nums[right];
            if (sqLeft < sqRight) {
                helper[index--] = sqRight;
                right--;
            } else {
                helper[index--] = sqLeft;
                left++;
            }
        }

        return helper;
    }
}
