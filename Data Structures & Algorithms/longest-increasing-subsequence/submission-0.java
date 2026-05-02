class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];

        for (int i = 0 ; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i ; j++) {
                dp[i] = nums[j] < nums[i] ? Math.max(dp[i], 1 + dp[j]) : dp[i];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
