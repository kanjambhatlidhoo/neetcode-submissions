class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        
        nums[1] = Math.max(nums[0], nums[1]);

        int max = Integer.MIN_VALUE;

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
