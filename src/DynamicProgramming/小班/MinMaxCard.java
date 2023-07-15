package DynamicProgramming.小班;

public class MinMaxCard {
    public int findMax(int [] nums) {
        //sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 3) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            return sum;
        }

        int [] dp = new int [nums.length];
        dp[0] = nums[0];
        dp[1] = dp[0] + nums[1];
        dp[2] = dp[1] + nums[2];

        int curSum = dp[2];

        for (int i = 3; i < nums.length; i++) {
            curSum += nums[i];
            int min = Math.min(dp[i - 1], dp[i - 2])
        }


    }
}
