package String;

public class LongestConsecutive1sWithKMakeup {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // do it by prefix sum
        int fast=0;
        int slow=0;
        int count=0;
        int longest=0;
        while(fast<nums.length){
            if(nums[fast]==1){
                longest=Math.max(longest,fast-slow+1);
                fast++;
            }else if(count<k){
                count++;
                longest=Math.max(longest,fast-slow+1);
                fast++;
            }else if(nums[slow++]==0){//very talented design
                count--;
            }
        }
        return longest;
    }
}
