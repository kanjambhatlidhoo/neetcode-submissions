class Pair {
    int min, max;

    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        Pair []dp = new Pair[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        dp[0] = new Pair(nums[0], nums[0]);

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int val1 = nums[i] * dp[i-1].min;
            int val2 = nums[i] * dp[i-1].max;

            dp[i].min = Math.min(nums[i], Math.min(val1, val2));
            dp[i].max = Math.max(nums[i], Math.max(val1, val2));

            max = Math.max(max, dp[i].max);
        }

        return max;
    }
}
