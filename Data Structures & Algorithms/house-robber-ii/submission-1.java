class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int []withoutFirst = new int[nums.length - 1];
        int []withoutLast = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            withoutLast[i] = nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            withoutFirst[i-1] = nums[i];
        }


        return Math.max(this.steal(withoutLast), this.steal(withoutFirst));
    }

    private int steal(int [] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        nums[1] = Math.max(nums[0], nums[1]);

        int max = Integer.MIN_VALUE;

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]);
        }
        
        for (int num: nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
