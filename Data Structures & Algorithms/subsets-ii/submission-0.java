class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);

        go(nums, 0, curr, res);

        return res;
    }

    void go(int []nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(curr.stream().collect(Collectors.toList()));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            go(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);

            // go(nums, i + 1, curr, res);
        }
    }
}
