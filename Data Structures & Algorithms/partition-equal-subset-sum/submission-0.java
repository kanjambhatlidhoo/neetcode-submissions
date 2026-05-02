class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return go(nums, nums.length - 1, 0, sum);
    }

    boolean go(int []nums, int idx, int curr, int sum) {
        if (curr > sum / 2) {
            return false;
        }

        if (idx < 0) {
            return false;
        }

        if (curr == sum/2) {
            return true;
        }

        return go(nums, idx-1, curr + nums[idx], sum) ||
            go(nums, idx-1, curr, sum);
    }
}
